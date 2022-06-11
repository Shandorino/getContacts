package com.odsstudio.contactsbook.di.useCases.impl

import com.odsstudio.contactsbook.di.repositories.ApiRepository
import com.odsstudio.contactsbook.di.useCases.PostUserImageUseCase
import okhttp3.MultipartBody
import javax.inject.Inject

class PostUserImageUseCaseImpl @Inject constructor(
    private val apiRepository: ApiRepository
): PostUserImageUseCase {
    override fun invoke(part: MultipartBody.Part) = apiRepository.postUserImage(part)
}