package com.odsstudio.contactsbook.data.api

import com.odsstudio.contactsbook.data.model.SimpleUser
import com.odsstudio.contactsbook.data.model.UserApi
import dagger.Provides
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*


interface ApiService {

    @GET("users/getUser")
    suspend fun getUser(@Query("token") token: String): UserApi

    @POST("auth/login")
    suspend fun postLoginUser(@Body simpleUser: SimpleUser): String

    @Multipart
    @POST("users/addUser")
    suspend fun postAddUser(
        @PartMap partMap: LinkedHashMap<String, RequestBody>,
        @Part part: MultipartBody.Part
    )

    @GET("users/getUsers")
    suspend fun getUsers(): List<UserApi>

}