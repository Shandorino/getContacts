package com.odsstudio.contactsbook.di.useCases.impl

import com.odsstudio.contactsbook.di.repositories.ApiRepository
import com.odsstudio.contactsbook.di.useCases.PostAddUserUseCase
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class PostAddUserUseCaseImpl @Inject constructor(
    private val apiRepository: ApiRepository
): PostAddUserUseCase {

    override fun invoke(part: MultipartBody.Part, partMap: LinkedHashMap<String, RequestBody>) = apiRepository.postAddUser(partMap, part)

}