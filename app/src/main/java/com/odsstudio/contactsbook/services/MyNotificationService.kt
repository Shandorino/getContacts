package com.odsstudio.contactsbook.services

import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import com.odsstudio.contactsbook.Const.ACTION_PAUSE_SERVICE
import com.odsstudio.contactsbook.Const.ACTION_START_OR_RESUME_SERVICE
import com.odsstudio.contactsbook.Const.ACTION_STOP_SERVICE
import com.odsstudio.contactsbook.Const.SERVICE_CHANNEL_ID
import com.odsstudio.contactsbook.Const.SERVICE_NOTIFICATION_ID
import com.odsstudio.contactsbook.R


class MyNotificationService: LifecycleService() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("qwerty", "start")
        intent?.let {
            when(it.action) {
                ACTION_START_OR_RESUME_SERVICE -> {
                    startForeGroundService()
                    Log.d("qwerty", "start1")
                }
                ACTION_PAUSE_SERVICE -> {
                    Log.d("qwerty", "start")
                }
                ACTION_STOP_SERVICE -> {
                    Log.d("qwerty", "start")
                }
                else -> {
                    Log.d("qwerty", "start2")
                }
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun startForeGroundService() {
        NotificationCompat.Builder(
            this,
            SERVICE_CHANNEL_ID
        ).setSmallIcon(R.drawable.ic_baseline_auto_awesome_motion_24)
            .setContentText("Service work")
            .setContentTitle("Contacts App")
            .build()
            .also {
                startForeground(SERVICE_NOTIFICATION_ID, it)
            }
    }

}