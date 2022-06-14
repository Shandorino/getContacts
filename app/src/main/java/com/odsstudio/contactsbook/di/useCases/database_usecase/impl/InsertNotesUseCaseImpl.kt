package com.odsstudio.contactsbook.di.useCases.database_usecase.impl

import com.odsstudio.contactsbook.data.model.Note
import com.odsstudio.contactsbook.di.repositories.DataBaseRepository
import com.odsstudio.contactsbook.di.useCases.database_usecase.InsertNotesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class InsertNotesUseCaseImpl @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
): InsertNotesUseCase {

    override fun invoke(notes: List<Note>): Flow<Unit> = dataBaseRepository.insertNotes(notes).flowOn(Dispatchers.IO)
}