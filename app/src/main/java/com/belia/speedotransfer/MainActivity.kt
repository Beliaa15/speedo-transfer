package com.belia.speedotransfer

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.belia.speedotransfer.ui.theme.SpeedoTransferTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        createNotificationChannel(this)
        setContent {
            SpeedoTransferTheme {
                /*TODO
                   Add appNavigation host to start everything
                */
            }
        }
    }
}

private fun createNotificationChannel(context: Context) {
    val name = "Transactions"
    val importance = NotificationManager.IMPORTANCE_DEFAULT
    val channel = NotificationChannel("200", name, importance)
    channel.description = "Successful Transactions"

    val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    manager.createNotificationChannel(channel)
}