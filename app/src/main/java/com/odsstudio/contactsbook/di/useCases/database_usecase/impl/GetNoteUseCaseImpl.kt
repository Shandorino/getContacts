package com.odsstudio.contactsbook.di.useCases.database_usecase.impl

import com.odsstudio.contactsbook.data.model.Note
import com.odsstudio.contactsbook.di.repositories.DataBaseRepository
import com.odsstudio.contactsbook.di.useCases.database_usecase.GetNoteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetNoteUseCaseImpl @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
): GetNoteUseCase {

    override fun invoke(noteId: Int): Flow<Note> = dataBaseRepository.getNote(noteId).flowOn(Dispatchers.IO)
}