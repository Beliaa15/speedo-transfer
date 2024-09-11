package com.belia.speedotransfer.util

import android.app.Notification
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.compose.ui.res.painterResource
import androidx.core.app.NotificationManagerCompat
import com.belia.speedotransfer.R

class NotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        sendNotification(
            title = intent?.getStringExtra("title")!!,
            text = intent.getStringExtra("text")!!,
            context = context!!
        )
    }
}

fun sendNotification(title: String, text: String, context: Context) {
    val largeIcon = BitmapFactory.decodeResource(context.resources, R.drawable.ic_speedo_notification)

    val builder = Notification.Builder(context, "200")
        .setContentText(text)
        .setContentTitle(title)
        .setAutoCancel(true)
        .setSmallIcon(R.drawable.ic_speedo_notification)
        .setLargeIcon(largeIcon)
        .setBadgeIconType(R.drawable.ic_speedo_notification)

    NotificationManagerCompat.from(context).notify(200, builder.build())
}