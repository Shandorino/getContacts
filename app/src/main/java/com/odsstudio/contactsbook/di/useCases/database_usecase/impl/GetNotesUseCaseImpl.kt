package com.odsstudio.contactsbook.di.useCases.database_usecase.impl

import com.odsstudio.contactsbook.data.model.Note
import com.odsstudio.contactsbook.di.repositories.DataBaseRepository
import com.odsstudio.contactsbook.di.useCases.database_usecase.GetNotesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetNotesUseCaseImpl @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
): GetNotesUseCase {
    override fun invoke(): Flow<List<Note>> = dataBaseRepository.getNotes().flowOn(Dispatchers.IO)
}