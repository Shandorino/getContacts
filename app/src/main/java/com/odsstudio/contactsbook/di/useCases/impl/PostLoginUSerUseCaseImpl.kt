package com.odsstudio.contactsbook.di.useCases.impl

import com.odsstudio.contactsbook.data.model.SimpleUser
import com.odsstudio.contactsbook.di.repositories.ApiRepository
import com.odsstudio.contactsbook.di.useCases.PostLoginUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostLoginUSerUseCaseImpl @Inject constructor(
    private val apiRepository: ApiRepository
): PostLoginUserUseCase {

    override fun invoke(simpleUser: SimpleUser): Flow<String> = apiRepository.postLoginUser(simpleUser).flowOn(Dispatchers.IO)

}