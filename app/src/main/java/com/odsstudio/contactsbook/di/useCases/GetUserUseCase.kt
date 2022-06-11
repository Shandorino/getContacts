package com.odsstudio.contactsbook.di.useCases

import com.odsstudio.contactsbook.data.model.User
import kotlinx.coroutines.flow.Flow

interface GetUserUseCase {

    operator fun invoke(): Flow<List<User>>
}