package com.odsstudio.contactsbook.di.useCases.database_usecase

import com.odsstudio.contactsbook.data.model.Note
import kotlinx.coroutines.flow.Flow

interface GetNotesUseCase {

    operator fun invoke(): Flow<List<Note>>

}