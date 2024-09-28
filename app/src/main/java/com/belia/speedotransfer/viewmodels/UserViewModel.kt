package com.belia.speedotransfer.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.belia.speedotransfer.api.APIService
import com.belia.speedotransfer.model.User
import com.belia.speedotransfer.util.TokenManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException

class UserViewModel (application: Application) : AndroidViewModel(application) {
    private val _user = MutableStateFlow<User>(User())
    val user: StateFlow<User> = _user

    private val tokenManager = TokenManager(application)

    fun getUser(userId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val token = tokenManager.getToken()
            val authToken = "Bearer $token"
            try {
                if(token.isNullOrEmpty()){
                    Log.d("trace", "Token is null or empty")
                    return@launch
                }
                _user.update {
                    APIService.callable.getUser(authToken)
                }
                Log.d("trace", "getUser: ${_user.value.id}")
            } catch (http: HttpException) {
                if(http.code() == 401){
                    Log.d("trace", "Error1: ${http.message} and token is: $token")
                } else {
                    Log.d("trace", "Error2: ${http.message()} and token is: $token")
                }
            } catch (e: Exception) {
                Log.d("trace", "Error: ${e.message}")
            }
        }
    }
}