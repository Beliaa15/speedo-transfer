package com.belia.speedotransfer.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.belia.speedotransfer.ui.errors.ErrorScreen
import com.belia.speedotransfer.ui.errors.NoInternetScreen
import com.belia.speedotransfer.viewmodels.ErrorViewModel

@Composable
fun HandleErrors(
    viewModel: ErrorViewModel,
    onRetry: () -> Unit,
    content: @Composable () -> Unit
) {
    val serverError by viewModel.serverError.collectAsState()
    val networkError by viewModel.networkError.collectAsState()

    when {
        serverError -> ErrorScreen()
        networkError -> NoInternetScreen(onRetry = onRetry)
        else -> content()
    }
}