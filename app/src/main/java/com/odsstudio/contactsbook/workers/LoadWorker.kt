package com.odsstudio.contactsbook.workers

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import com.odsstudio.contactsbook.Const.DONWLOAD_WORKER_CHANNEL_ID
import com.odsstudio.contactsbook.R
import com.odsstudio.contactsbook.di.useCases.PostAddUserUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineExceptionHandler
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import java.io.InputStream
import kotlin.random.Random

@HiltWorker
class LoadWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted workerParams: WorkerParameters,
    private val postAddUserUseCase: PostAddUserUseCase
) : CoroutineWorker(context, workerParams){


    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e("Exception", throwable.toString())
    }

    override suspend fun doWork(): Result {
        return try {

            showNotification()


            val userName = inputData.getString("userName")
            val userLastName = inputData.getString("userLastName")
            val imageUri = inputData.getString("imageUri")

            if (userName != null && userLastName != null) {
                val imageFile = File(Uri.parse(imageUri).path)


                val mp: LinkedHashMap<String, RequestBody> = LinkedHashMap()

                var rb = RequestBody.create(
                    MediaType.parse("text/plain"), userName
                )
                mp["fullName"] = rb

                rb = RequestBody.create(MediaType.parse("text/plain"), userLastName)
                mp["email"] = rb

                rb = RequestBody.create(MediaType.parse("text/plain"), "qqq")
                mp["password"] = rb

                rb = RequestBody.create(MediaType.parse("text/plain"), "12345")
                mp["phoneNumber"] = rb

                val iStream = context.contentResolver.openInputStream(Uri.parse(imageUri))

                val bytes = iStream?.let { getBytes(it) }

                val filePart: MultipartBody.Part = MultipartBody.Part.createFormData("file", imageFile.path, RequestBody.create(
                    MediaType.parse("image/png"), bytes))


                postAddUserUseCase.invoke(filePart, mp)

                Result.success()
            } else
                Result.failure()




//            delay(10000)


        } catch (e: Exception) {
            e.message?.let { Log.e("ebat", it) }
            Result.failure()
        }
    }

    @Throws(IOException::class)
    private fun getBytes(inputStream: InputStream): ByteArray? {
        val byteBuffer = ByteArrayOutputStream()
        val bufferSize = 20971520
        val buffer = ByteArray(bufferSize)
        var len = 0
        while (inputStream.read(buffer).also { len = it } != -1) {
            byteBuffer.write(buffer, 0, len)
        }
        return byteBuffer.toByteArray()
    }

    private suspend fun showNotification() {

        setForeground(
            ForegroundInfo(
                Random.nextInt(),
                NotificationCompat.Builder(context, DONWLOAD_WORKER_CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_baseline_book_24)
                    .setContentText("jhhjhkhjkhjkhjk")
                    .setContentTitle("Загрузка изображения")
                    .build()
            )
        )
    }
}