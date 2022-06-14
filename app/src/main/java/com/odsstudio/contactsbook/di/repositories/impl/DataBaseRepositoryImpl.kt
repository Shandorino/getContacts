package com.odsstudio.contactsbook.di.repositories.impl

import android.util.Log
import com.odsstudio.contactsbook.data.database.NoteDao
import com.odsstudio.contactsbook.data.database.UserDao
import com.odsstudio.contactsbook.data.model.Note
import com.odsstudio.contactsbook.data.model.NoteEntity
import com.odsstudio.contactsbook.data.model.User
import com.odsstudio.contactsbook.data.model.UserEntity
import com.odsstudio.contactsbook.di.repositories.DataBaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DataBaseRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
): DataBaseRepository {

    override fun getNotes(): Flow<List<Note>> = flow {
        val notes = noteDao.getNotes().map { it.toNote() }
        emit(notes)
    }

    override fun getNote(noteId: Int): Flow<Note> = flow {
        val note = noteDao.getNote(noteId).toNote()
        emit(note)
    }

    override fun insertNote(note: Note): Flow<Unit> = flow {
        noteDao.insertNote(note.toNoteEntity())
    }

    override fun insertNotes(notes: List<Note>): Flow<Unit> = flow {
        val notesEntity = notes.map { it.toNoteEntity() }
        noteDao.insertNotes(notesEntity)
    }

    override fun deleteNote(note: Note): Flow<Unit> = flow {
        noteDao.deleteUser(note.toNoteEntity())
    }
}