package com.odsstudio.contactsbook.data.database

import androidx.room.*
import com.odsstudio.contactsbook.data.model.NoteEntity


@Dao
interface NoteDao {

    @Query("SELECT * FROM noteentity")
    suspend fun getNotes(): List<NoteEntity>

    @Query("SELECT * FROM noteentity WHERE id IN (:noteId)")
    suspend fun getNote(noteId: Int): NoteEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE, )
    suspend fun insertNote(note: NoteEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(notes: List<NoteEntity>)

    @Delete
    suspend fun deleteUser(note: NoteEntity)

}