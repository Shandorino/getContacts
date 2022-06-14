package com.odsstudio.contactsbook.di.useCases.impl

import com.odsstudio.contactsbook.data.model.User
import com.odsstudio.contactsbook.di.repositories.ApiRepository
import com.odsstudio.contactsbook.di.useCases.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetUserUseCaseImpl @Inject constructor(
    private val apiRepository: ApiRepository
): GetUserUseCase {

    override fun invoke(token: String): Flow<User> = apiRepository.getUser(token).flowOn(Dispatchers.IO)

}