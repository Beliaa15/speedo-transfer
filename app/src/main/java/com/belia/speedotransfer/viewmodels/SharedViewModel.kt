package com.belia.speedotransfer.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SharedViewModel : ViewModel(){
    private val _userId = MutableStateFlow<String>("0")
    val userId = _userId.asStateFlow()

    private val _token = MutableStateFlow<String>("")
    val token = _token.asStateFlow()

    fun setUserId(userId: String) {
        _userId.value = userId
    }

    fun setToken(userToken: String){
        _token.value = userToken
    }
}