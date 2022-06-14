package com.odsstudio.contactsbook.di.useCases

import com.odsstudio.contactsbook.data.model.User
import com.odsstudio.contactsbook.data.model.UserApi
import kotlinx.coroutines.flow.Flow

interface GetUserUseCase {

    operator fun invoke(token: String): Flow<User>

}