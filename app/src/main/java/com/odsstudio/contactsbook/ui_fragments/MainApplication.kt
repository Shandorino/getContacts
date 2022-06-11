package com.odsstudio.contactsbook.ui_fragments

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import com.odsstudio.contactsbook.Const.DONWLOAD_WORKER_CHANNEL_ID
import com.odsstudio.contactsbook.Const.SERVICE_CHANNEL_ID
import com.odsstudio.contactsbook.Const.WORKER_CHANNEL_ID
import dagger.Provides
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


@HiltAndroidApp
class MainApplication: Application(), Configuration.Provider {

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

        val downloadWorkerChannel = NotificationChannel(
            DONWLOAD_WORKER_CHANNEL_ID,
            "Download worker channel",
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
            createNotificationChannel(downloadWorkerChannel)
        }
    }

    @Inject
    lateinit var workerFactory: HiltWorkerFactory


    override fun getWorkManagerConfiguration() =
        Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()

}