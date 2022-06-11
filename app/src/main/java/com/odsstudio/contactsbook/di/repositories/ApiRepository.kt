package com.odsstudio.contactsbook.di.repositories

import com.odsstudio.contactsbook.data.model.User
import com.odsstudio.contactsbook.data.model.UserApi
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody

interface ApiRepository {

   fun getUser(): Flow<List<User>>

   fun postUser(userApi: UserApi)

   fun postUserImage(path: MultipartBody.Part)
}