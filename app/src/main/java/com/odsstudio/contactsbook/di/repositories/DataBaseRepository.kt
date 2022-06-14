package com.odsstudio.contactsbook.di.repositories

import com.odsstudio.contactsbook.data.model.Note
import com.odsstudio.contactsbook.data.model.NoteEntity
import com.odsstudio.contactsbook.data.model.User
import com.odsstudio.contactsbook.data.model.UserEntity
import kotlinx.coroutines.flow.Flow


interface DataBaseRepository {

    fun getNotes(): Flow<List<Note>>

    fun getNote(noteId: Int): Flow<Note>

    fun insertNote(note: Note): Flow<Unit>

    fun insertNotes(notes: List<Note>): Flow<Unit>

    fun deleteNote(note: Note): Flow<Unit>

}