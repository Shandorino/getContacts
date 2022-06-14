package com.odsstudio.contactsbook.di.repositories

import com.odsstudio.contactsbook.data.model.SimpleUser
import com.odsstudio.contactsbook.data.model.User
import com.odsstudio.contactsbook.data.model.UserApi
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import okhttp3.RequestBody

interface ApiRepository {

   fun getUser(token: String): Flow<User>

   fun postAddUser(partMap: LinkedHashMap<String, RequestBody>, part: MultipartBody.Part)

   fun postLoginUser(simpleUser: SimpleUser) : Flow<String>

   fun getUsers(): Flow<List<User>>

}