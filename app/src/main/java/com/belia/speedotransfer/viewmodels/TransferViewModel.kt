package com.belia.speedotransfer.viewmodels

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.belia.speedotransfer.api.APIService
import com.belia.speedotransfer.model.TransferRequest
import com.belia.speedotransfer.util.TokenManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.math.BigDecimal

class TransferViewModel(application: Application) : ErrorViewModel(application) {
    var amount by mutableStateOf(BigDecimal.ZERO)
    private var errorMessage by mutableStateOf("")
    var isLoading by mutableStateOf(false)
    private val _notFound = MutableStateFlow(false)
    val notFound = _notFound.asStateFlow()

    val tokenManager = TokenManager(application)

    fun transfer(senderAccount: String, recipientAccount: String) {
        viewModelScope.launch(Dispatchers.IO) {
            isLoading = true
            resetErrors()
            try {
                val token = tokenManager.getToken()
                if (!token.isNullOrEmpty()) {
                    val transferRequest = TransferRequest(senderAccount, recipientAccount, amount)
                    val response = APIService.callable.transferMoney(token, transferRequest)
                    Log.d("trace", "transfer: $response")
                    _notFound.update { false }
                }
            } catch (http: HttpException) {
                when (http.code()) {
                    401 -> Log.d("trace", "Error: ${http.message}")
                    400 -> _notFound.value = true
                    else -> handleError(http)
                }
            } catch (e: Exception) {
                handleError(e)
            } finally {
                isLoading = false
            }
        }
    }
}