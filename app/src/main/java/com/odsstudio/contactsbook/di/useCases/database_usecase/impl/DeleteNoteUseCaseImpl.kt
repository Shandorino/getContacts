package com.odsstudio.contactsbook.di.useCases.database_usecase.impl

import com.odsstudio.contactsbook.data.model.Note
import com.odsstudio.contactsbook.di.repositories.DataBaseRepository
import com.odsstudio.contactsbook.di.useCases.database_usecase.DeleteNoteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DeleteNoteUseCaseImpl @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
): DeleteNoteUseCase {

    override fun invoke(note: Note): Flow<Unit> = dataBaseRepository.deleteNote(note).flowOn(Dispatchers.IO)
}