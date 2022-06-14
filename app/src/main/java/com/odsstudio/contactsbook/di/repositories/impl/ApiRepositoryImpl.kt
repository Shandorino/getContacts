package com.odsstudio.contactsbook.di.repositories.impl

import android.util.Log
import com.odsstudio.contactsbook.data.api.ApiService
import com.odsstudio.contactsbook.data.model.SimpleUser
import com.odsstudio.contactsbook.data.model.User
import com.odsstudio.contactsbook.di.repositories.ApiRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): ApiRepository {


    override fun getUser(token: String): Flow<User> = flow{
        val user = apiService.getUser(token).toUser()
        emit(user)
    }

    override fun postAddUser(partMap: LinkedHashMap<String, RequestBody>, part: MultipartBody.Part) {
        CoroutineScope(Dispatchers.IO).launch {
            partMap.values.forEach {
                Log.d("=========>", it.contentType().toString())
            }

            apiService.postAddUser(partMap, part)
        }
    }

    override fun postLoginUser(simpleUser: SimpleUser): Flow<String> = flow {
        val token = apiService.postLoginUser(simpleUser)
        emit(token)
    }

    override fun getUsers(): Flow<List<User>> = flow {
        val users = apiService.getUsers().map {it.toUser()}
        emit(users)
    }
}