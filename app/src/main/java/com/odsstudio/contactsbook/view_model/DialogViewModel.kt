package com.odsstudio.contactsbook.view_model

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odsstudio.contactsbook.data.model.UserApi
import com.odsstudio.contactsbook.di.useCases.PostUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.net.URI
import javax.inject.Inject


//@HiltViewModel
class DialogViewModel : ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->

        Log.e("Exception", throwable.toString())

    }

}