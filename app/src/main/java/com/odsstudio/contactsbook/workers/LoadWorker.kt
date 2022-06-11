package com.odsstudio.contactsbook.workers

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.net.toFile
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import com.odsstudio.contactsbook.Const.DONWLOAD_WORKER_CHANNEL_ID
import com.odsstudio.contactsbook.Const.WORKER_CHANNEL_ID
import com.odsstudio.contactsbook.R
import com.odsstudio.contactsbook.data.model.UserApi
import com.odsstudio.contactsbook.di.useCases.PostUserImageUseCase
import com.odsstudio.contactsbook.di.useCases.PostUserUseCase
import com.odsstudio.contactsbook.di.useCases.impl.PostUserUseCaseImpl
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okio.Utf8
import java.io.File
import java.net.URI
import javax.inject.Inject
import kotlin.random.Random

@HiltWorker
class LoadWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted workerParams: WorkerParameters,
    private val postUserUseCase: PostUserUseCase,
    private val postUserImageUseCase: PostUserImageUseCase
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
                val user = UserApi(name = userName, lastName = userLastName, image = imageFile.name, id = null)
                val filePart: MultipartBody.Part = MultipartBody.Part.createFormData("image", imageFile.path, RequestBody.create(
                    MediaType.parse("image/*"), imageFile.path))

                postUserUseCase.invoke(user)
               // postUserImageUseCase.invoke(filePart)
                Result.success()
            } else
                Result.failure()




//            delay(10000)


        } catch (e: Exception) {
            e.message?.let { Log.e("ebat", it) }
            Result.failure()
        }
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