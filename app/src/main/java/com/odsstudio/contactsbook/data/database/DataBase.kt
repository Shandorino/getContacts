package com.odsstudio.contactsbook.data.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.odsstudio.contactsbook.data.model.NoteEntity
import com.odsstudio.contactsbook.data.model.UserEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class DataBase: RoomDatabase() {

    abstract fun noteDao(): NoteDao
}