package com.odsstudio.contactsbook.di.repositories.impl

import com.odsstudio.contactsbook.data.api.ApiService
import com.odsstudio.contactsbook.data.model.User
import com.odsstudio.contactsbook.data.model.UserApi
import com.odsstudio.contactsbook.di.repositories.ApiRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): ApiRepository {


    override fun getUser(): Flow<List<User>> = flow{
        val user = apiService.getUser().map { it.toUser() }
        emit(user)
    }

    override fun postUser(userApi: UserApi) {
        CoroutineScope(Dispatchers.IO).launch {
            apiService.postUser(userApi =  userApi)
        }
    }

    override fun postUserImage(part: MultipartBody.Part) {
        CoroutineScope(Dispatchers.IO).launch {
            apiService.postUserImage(part)
        }
    }
}