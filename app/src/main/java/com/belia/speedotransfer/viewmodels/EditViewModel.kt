package com.belia.speedotransfer.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belia.speedotransfer.api.APIService
import com.belia.speedotransfer.model.ChangePasswordRequest
import com.belia.speedotransfer.model.EditProfileRequest
import com.belia.speedotransfer.model.SignUpRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class EditViewModel : ViewModel() {
    var name by mutableStateOf("")
    var email by mutableStateOf("")
    var oldpassword by mutableStateOf("")
    var newpassword by mutableStateOf("")
    var dateOfBirth by mutableStateOf("")
    var country by mutableStateOf("")
    var errorMessage by mutableStateOf("")
    var isLoading by mutableStateOf(false)
    var isSignedUp by mutableStateOf(false)

    fun changePassword(userId: Int){
        isLoading = true
        errorMessage = ""

        // Launching coroutine for network call
        viewModelScope.launch (Dispatchers.IO) {
            try {
                val changePassword = ChangePasswordRequest(oldpassword, newpassword)
                val response = APIService.callable.changePassword(userId, changePassword)


                Log.d("trace", "changePassword: ${response.name}")
            } catch (e: Exception) {
                Log.d("trace", "Error: ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }

    fun editProfile(userId: Int){
        isLoading = true
        errorMessage = ""

        // Launching coroutine for network call
        viewModelScope.launch (Dispatchers.IO) {
            try {
                val editProfileRequest = EditProfileRequest(userId, LocalDateTime.now().toString(), name, email, country, dateOfBirth)
                val response = APIService.callable.editProfile(userId, editProfileRequest)

                Log.d("trace", "editProfile: ${response.name}")
            } catch (e: Exception) {
                Log.d("trace", "Error: ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }

}