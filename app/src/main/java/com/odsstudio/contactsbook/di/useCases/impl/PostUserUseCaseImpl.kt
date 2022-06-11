package com.odsstudio.contactsbook.di.useCases.impl

import com.odsstudio.contactsbook.data.model.UserApi
import com.odsstudio.contactsbook.di.repositories.ApiRepository
import com.odsstudio.contactsbook.di.useCases.PostUserUseCase
import okhttp3.MultipartBody
import javax.inject.Inject

class PostUserUseCaseImpl @Inject constructor(
    private val apiRepository: ApiRepository
) : PostUserUseCase {


    override fun invoke(userApi: UserApi) = apiRepository.postUser(userApi)
}