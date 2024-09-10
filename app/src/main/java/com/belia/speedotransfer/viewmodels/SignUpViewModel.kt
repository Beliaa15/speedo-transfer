package com.belia.speedotransfer.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belia.speedotransfer.api.APIService
import com.belia.speedotransfer.model.SignUpRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpViewModel: ViewModel() {
    var name by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var confirmPassword by mutableStateOf("")
    var dateOfBirth by mutableStateOf("")
    var country by mutableStateOf("")
    var errorMessage by mutableStateOf("")
    var isLoading by mutableStateOf(false)
    var isSignedUp by mutableStateOf(false)

    fun signUp(){
        isLoading = true
        errorMessage = ""

        // Launching coroutine for network call
        viewModelScope.launch (Dispatchers.IO) {
            try {
                val signUpRequest = SignUpRequest(name, email, password, confirmPassword, dateOfBirth, country)
                val response = APIService.callable.register(signUpRequest)

                Log.d("trace", "signUp: ${response.name}")
            } catch (e: Exception) {
                Log.d("trace", "Error: ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }
}