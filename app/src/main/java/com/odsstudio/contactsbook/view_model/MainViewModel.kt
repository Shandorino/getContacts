package com.odsstudio.contactsbook.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel: ViewModel() {

    private val text = MutableStateFlow("")
    val text_ = text.asStateFlow()

    fun dataChanget(mytext: String) {

        text.value = mytext

    }


}