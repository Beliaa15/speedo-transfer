package com.belia.speedotransfer.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belia.speedotransfer.api.APIService
import com.belia.speedotransfer.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val _user = MutableStateFlow<User>(User())
    val user: MutableStateFlow<User> = _user

    fun getUser(userId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _user.update {
                    APIService.callable.getUser(userId)
                }
                    Log.d("trace", "getUser: ${_user.value.id}")
            } catch (e: Exception) {
                Log.d("trace", "Error: ${e.message}")
            }
        }
    }
}