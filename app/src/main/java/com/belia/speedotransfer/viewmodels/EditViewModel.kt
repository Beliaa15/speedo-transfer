package com.belia.speedotransfer.viewmodels

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.belia.speedotransfer.api.APIService
import com.belia.speedotransfer.model.ChangePasswordRequest
import com.belia.speedotransfer.model.EditProfileRequest
import com.belia.speedotransfer.util.TokenManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.time.LocalDateTime

class EditViewModel(application: Application) : AndroidViewModel(application) {
    var name by mutableStateOf("")
    var email by mutableStateOf("")
    var oldpassword by mutableStateOf("")
    var newpassword by mutableStateOf("")
    var dateOfBirth by mutableStateOf("")
    var country by mutableStateOf("")
    var errorMessage by mutableStateOf("")
    var isLoading by mutableStateOf(false)

    val tokenManager = TokenManager(application)
    val token = tokenManager.getToken()

    fun changePassword(userId: String){
        isLoading = true
        errorMessage = ""

        // Launching coroutine for network call
        viewModelScope.launch (Dispatchers.IO) {
            try {
                val changePassword = ChangePasswordRequest(oldpassword, newpassword)
                val response = APIService.callable.changePassword(token!!, userId, changePassword)
                Log.d("trace", "changePassword: ${response.name}")
            } catch (http: HttpException) {
                if(http.code() == 401){
                    Log.d("trace", "Error: ${http.message}")
                } else {
                    Log.d("trace", "Error: ${http.message()}")
                }
            } catch (e: Exception) {
                Log.d("trace", "Error: ${e.message}")
            }
        }
    }

    fun editProfile(userId: String){
        isLoading = true
        errorMessage = ""

        // Launching coroutine for network call
        viewModelScope.launch (Dispatchers.IO) {
            try {
                val editProfileRequest = EditProfileRequest(userId, LocalDateTime.now().toString(), name, email, country, dateOfBirth)
                val response = APIService.callable.editProfile(token!!, userId, editProfileRequest)

                Log.d("trace", "editProfile: ${response.name}")
            } catch (http: HttpException) {
                if(http.code() == 401){
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