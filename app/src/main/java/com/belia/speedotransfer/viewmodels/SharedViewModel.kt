package com.belia.speedotransfer.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SharedViewModel : ViewModel(){
    private val _userId = MutableStateFlow<Int>(0)
    val userId = _userId.asStateFlow()

    fun setUserId(userId: Int) {
        _userId.value = userId
    }
}