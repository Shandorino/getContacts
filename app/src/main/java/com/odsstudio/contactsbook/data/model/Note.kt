package com.odsstudio.contactsbook.data.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Note(

    val id: Int,
    val title: String,
    val body: String
) {
    fun toNoteEntity() = NoteEntity(
        id = id,
        title = title,
        body = body
    )
}
