package com.belia.speedotransfer.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belia.speedotransfer.api.APIService
import com.belia.speedotransfer.model.TransferRequest
import com.belia.speedotransfer.util.sendNotification
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.math.BigDecimal

class TransferViewModel : ViewModel(){
    var amount by mutableStateOf(BigDecimal.ZERO)
    private var errorMessage by mutableStateOf("")
    var isLoading by mutableStateOf(false)

    fun transfer(senderAccount: String, recipientAccount: String){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val transferRequest = TransferRequest(senderAccount, recipientAccount, amount)
                val response = APIService.callable.transferMoney(transferRequest)
                Log.d("trace", "transfer: $response")
            } catch (e: Exception) {
                // Handle error (e.g., show error message)
                errorMessage = e.message ?: "Login failed"
                Log.d("trace", "Error: $errorMessage")
            } finally {
                isLoading = false
            }
        }
    }

}