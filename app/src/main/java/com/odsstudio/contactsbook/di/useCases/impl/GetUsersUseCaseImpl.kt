package com.odsstudio.contactsbook.di.useCases.impl

import com.odsstudio.contactsbook.data.model.User
import com.odsstudio.contactsbook.di.repositories.ApiRepository
import com.odsstudio.contactsbook.di.useCases.GetUsersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetUsersUseCaseImpl @Inject constructor(
    private val apiRepository: ApiRepository
): GetUsersUseCase {

    override fun invoke(): Flow<List<User>> = apiRepository.getUsers().flowOn(Dispatchers.IO)

}