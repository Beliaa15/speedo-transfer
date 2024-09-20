package com.belia.speedotransfer.viewmodels

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
    var isLoading by mutableStateOf(false)
    var userId by mutableStateOf("0")

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn = _isLoggedIn.asStateFlow()

    private val _notFound = MutableStateFlow(false)
    val notFound = _notFound.asStateFlow()

    private val tokenManager = TokenManager(application)
    val token = tokenManager.getToken()

    fun loginUser() {
        isLoading = true
        errorMessage = ""
        _notFound.value = false
        resetErrors()
        resetNotFound()

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val loginRequest = LoginRequest(email, password)
                val response = APIService.callable.login(loginRequest)
                _isLoggedIn.value = true
                userId = response.userId
                tokenManager.saveToken(response.token)
                Log.d("trace", "loginUser: ${response.message}")
            } catch (http: HttpException) {
                if (http.code() == 400) {
                    _notFound.value = true
                } else {
                    handleError(http)
                }
            } catch (e: Exception) {
                handleError(e)
            } finally {
                isLoading = false
            }
        }
    }

    fun resetNotFound() {
        _notFound.value = false
    }

    fun resetIsLoggedIn() {
        _isLoggedIn.value = false
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
                isLoading = false
            }
        }
    }
}