package com.odsstudio.contactsbook.workers

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.core.app.NotificationCompat
import androidx.fragment.app.FragmentManager
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import com.odsstudio.contactsbook.Const.WORKER_CHANNEL_ID
import com.odsstudio.contactsbook.R
import com.odsstudio.contactsbook.ui_fragments.notification_fragments.SecondNotificationFragment
import kotlinx.coroutines.delay
import java.lang.Exception
import kotlin.random.Random

class MyFirstWorker(
    private val context: Context,
    workerParams: WorkerParameters
): CoroutineWorker(context, workerParams) {


    override suspend fun doWork(): Result {
        return try {
            showNotification()
            val firstNum = inputData.getInt("First number", 0)
            val secondNum = inputData.getInt("Second number", 0)
            val operant = inputData.getInt("Operant", 0)

            var result = 0

            when(operant) {
                0 -> {
                    result = firstNum + secondNum
                }
                1 -> {
                    result = firstNum - secondNum
                }
                2 -> {
                    result = firstNum * secondNum
                }
                3 -> {
                    result = firstNum / secondNum
                }
            }

            Log.d("result", result.toString())
            delay(2000L)

            val output = Data.Builder().putInt("Result", result).build()


            Result.success(output)
        } catch (e: Exception) {
            Log.e("MyException", "Что-то пошло не так!!!")
            Result.failure()
        }
    }


    private suspend fun showNotification() {

        setForeground(
            ForegroundInfo(
                Random.nextInt(),
                NotificationCompat.Builder(context, WORKER_CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_baseline_book_24)
                    .setContentText("Подсчет идет")
                    .setContentTitle("Работа воркера")
                    .build()
            )
        )

    }
}