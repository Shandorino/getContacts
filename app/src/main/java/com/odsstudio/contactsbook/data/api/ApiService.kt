package com.odsstudio.contactsbook.data.api

import com.odsstudio.contactsbook.data.model.UserApi
import dagger.Provides
import okhttp3.MultipartBody
import retrofit2.http.*


interface ApiService {

    @GET("getUser")
    suspend fun getUser(): List<UserApi>

    @POST("getUser")
    suspend fun postUser(@Body userApi: UserApi)


    @POST("userImage")
    suspend fun postUserImage(@Body image: MultipartBody.Part)
}