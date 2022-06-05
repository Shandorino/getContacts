package com.odsstudio.contactsbook.ui_fragments

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import com.odsstudio.contactsbook.Const.SERVICE_CHANNEL_ID
import com.odsstudio.contactsbook.Const.WORKER_CHANNEL_ID

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        createNotificationChannel()
    }


    private fun createNotificationChannel() {

        val workerChannel = NotificationChannel(
            WORKER_CHANNEL_ID,
            "Worker channel",
            NotificationManager.IMPORTANCE_HIGH
        )

        val serviceChannel = NotificationChannel(
            SERVICE_CHANNEL_ID,
            "Service channel",
            NotificationManager.IMPORTANCE_HIGH
        )

        val notificationManager = getSystemService(NotificationManager::class.java)

        with(notificationManager) {
            createNotificationChannel(serviceChannel)
            createNotificationChannel(workerChannel)
        }
    }

}