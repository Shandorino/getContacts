package com.odsstudio.contactsbook.di.useCases

import com.odsstudio.contactsbook.data.model.SimpleUser
import kotlinx.coroutines.flow.Flow

interface PostLoginUserUseCase {

    operator fun invoke(simpleUser: SimpleUser): Flow<String>

}