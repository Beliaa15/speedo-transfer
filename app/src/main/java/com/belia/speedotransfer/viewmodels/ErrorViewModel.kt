package com.belia.speedotransfer.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import retrofit2.HttpException
import java.io.IOException

open class ErrorViewModel(application: Application) : AndroidViewModel(application) {
    private val _serverError = MutableStateFlow(false)
    val serverError = _serverError.asStateFlow()

    private val _networkError = MutableStateFlow(false)
    val networkError = _networkError.asStateFlow()

    protected fun handleError(e: Exception) {
        when (e) {
            is HttpException -> {
                if (e.code() >= 500) {
                    _serverError.value = true
                }
            }
            is IOException -> {
                _networkError.value = true
            }
            else -> {
                _serverError.value = true
            }
        }
    }

    fun resetErrors() {
        _serverError.value = false
        _networkError.value = false
    }
}