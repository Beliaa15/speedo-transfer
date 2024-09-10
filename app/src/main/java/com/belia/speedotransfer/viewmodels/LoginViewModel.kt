package com.belia.speedotransfer.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belia.speedotransfer.api.APIService
import com.belia.speedotransfer.model.LoginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var errorMessage by mutableStateOf("")
    var isLoading by mutableStateOf(false)
    var isLoggedIn by mutableStateOf(false)
    var userId by mutableIntStateOf(0)

    fun loginUser() {
        isLoading = true
        errorMessage = ""

        // Launching coroutine for network call
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val loginRequest = LoginRequest(email, password)
                val response = APIService.callable.login(loginRequest)

                // Handle success response (e.g., store token)
                isLoggedIn = true
                userId = response.userId
                Log.d("trace", "loginUser: ${response.token}, ${response.userId}")
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