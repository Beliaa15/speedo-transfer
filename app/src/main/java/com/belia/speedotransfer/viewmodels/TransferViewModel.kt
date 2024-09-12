package com.belia.speedotransfer.viewmodels

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belia.speedotransfer.api.APIService
import com.belia.speedotransfer.model.TransferRequest
import com.belia.speedotransfer.util.TokenManager
import com.belia.speedotransfer.util.sendNotification
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.math.BigDecimal

class TransferViewModel(application: Application) : AndroidViewModel(application) {
    var amount by mutableStateOf(BigDecimal.ZERO)
    private var errorMessage by mutableStateOf("")
    var isLoading by mutableStateOf(false)

    val tokenManager = TokenManager(application)

    fun transfer(senderAccount: String, recipientAccount: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val token = tokenManager.getToken()
                if (token.isNullOrEmpty()) {
                    val transferRequest = TransferRequest(senderAccount, recipientAccount, amount)
                    val response = APIService.callable.transferMoney(token!!, transferRequest)
                    Log.d("trace", "transfer: $response")
                }
            } catch (http: HttpException) {
                if (http.code() == 401) {
                    Log.d("trace", "Error: ${http.message}")
                } else {
                    Log.d("trace", "Error: ${http.message()}")
                }
            } catch (e: Exception) {
                Log.d("trace", "Error: ${e.message}")
            }
        }
    }

}