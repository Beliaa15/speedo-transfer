package com.belia.speedotransfer.viewmodels

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.belia.speedotransfer.api.APIService
import com.belia.speedotransfer.model.LoginRequest
import com.belia.speedotransfer.util.TokenManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class LoginViewModel(application: Application) : ErrorViewModel(application) {

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var errorMessage by mutableStateOf("")
    var userId by mutableStateOf("0")

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn = _isLoggedIn.asStateFlow()

    private val _loginError = MutableStateFlow<String?>(null)
    val loginError = _loginError.asStateFlow()

    private val tokenManager = TokenManager(application)
    val token = tokenManager.getToken()

    fun loginUser() {
        _isLoading.value = true
        errorMessage = ""
        resetErrors()
        resetIsLoggedIn()

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val loginRequest = LoginRequest(email, password)
                val response = APIService.callable.login(loginRequest)
                userId = response.userId
                tokenManager.saveToken(response.token)
                _isLoggedIn.value = true
                Log.d("trace", "loginUser: ${response.message}")
            } catch (http: HttpException) {
                if (http.code() == 401) {
                    _isLoggedIn.value = false
                    errorMessage = "Invalid email or password"
                    _loginError.value = errorMessage
                } else if (http.code() == 422)  {
                    errorMessage = "Account not Found"
                    _loginError.value = errorMessage
                } else {
                    handleError(http)
                }
            } catch (e: Exception) {
                handleError(e)
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun resetIsLoggedIn() {
        _isLoggedIn.value = false
    }

    fun resetLoginError() {
        _loginError.value = null
    }

    fun logoutUser() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = APIService.callable.logout(token!!)
            } catch (e: Exception) {
                // Handle error (e.g., show error message)
                errorMessage = e.message ?: "Logout failed"
                Log.d("trace", "Error: $errorMessage")
            } finally {
                _isLoading.value = false
            }
        }
    }
}
