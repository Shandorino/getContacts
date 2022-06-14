package com.odsstudio.contactsbook.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odsstudio.contactsbook.data.model.User
import com.odsstudio.contactsbook.di.useCases.GetUserUseCase
import com.odsstudio.contactsbook.di.useCases.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RetrofitViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val getUsersUseCase: GetUsersUseCase
)
: ViewModel() {

    private val _user = MutableStateFlow<List<User>>(listOf())
    val user = _user.asStateFlow()


    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->

        Log.e("Exception", throwable.toString())

    }

    fun getUser() {
        viewModelScope.launch(exceptionHandler) {
            getUsersUseCase.invoke().collect {
                _user.emit(it)
            }

        }
    }


}