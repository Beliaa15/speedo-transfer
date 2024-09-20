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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignUpViewModel: ViewModel() {
    var name by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var confirmPassword by mutableStateOf("")
    var dateOfBirth by mutableStateOf("")
    var country by mutableStateOf("")
    var isLoading by mutableStateOf(false)
    private val _isSignedUp = MutableStateFlow(false)
    val isSignedUp = _isSignedUp.asStateFlow()

    fun signUp(signUpRequest: SignUpRequest){
        isLoading = true

        // Launching coroutine for network call
        viewModelScope.launch (Dispatchers.IO) {
            try {
                val response = APIService.callable.register(signUpRequest)
                _isSignedUp.value = true
                Log.d("trace", "signUp: ${response.message}")
            } catch (e: Exception) {
                Log.d("trace", "SignUpError: ${e.localizedMessage}")
                _isSignedUp.value = false
            } finally {
                isLoading = false
            }
        }
    }

    fun resetIsSignedUp(){
        _isSignedUp.value = false
    }
}