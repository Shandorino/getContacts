package com.odsstudio.contactsbook.di.useCases.database_usecase

import androidx.work.workDataOf
import com.odsstudio.contactsbook.data.model.Note
import kotlinx.coroutines.flow.Flow

interface InsertNoteUseCase {

    operator fun invoke(note: Note): Flow<Unit>

}