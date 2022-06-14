package com.odsstudio.contactsbook.di.useCases.database_usecase

import com.odsstudio.contactsbook.data.model.Note
import kotlinx.coroutines.flow.Flow

interface DeleteNoteUseCase {

    operator fun invoke(note: Note): Flow<Unit>

}