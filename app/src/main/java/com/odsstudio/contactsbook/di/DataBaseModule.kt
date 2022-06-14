package com.odsstudio.contactsbook.di

import android.content.Context
import androidx.room.Room
import com.odsstudio.contactsbook.data.database.DataBase
import com.odsstudio.contactsbook.data.database.NoteDao
import com.odsstudio.contactsbook.data.database.UserDao
import com.odsstudio.contactsbook.di.repositories.DataBaseRepository
import com.odsstudio.contactsbook.di.repositories.impl.DataBaseRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DataBaseModule {

    @Binds
    abstract fun bindsDataBaseRepository(dataBaseRepositoryImpl: DataBaseRepositoryImpl): DataBaseRepository


    companion object {

        @Provides
        fun provideUSerDao(database: DataBase): NoteDao
            = database.noteDao()


        @Provides
        @Singleton
        fun provideDataBase(@ApplicationContext appContext: Context)
            : DataBase = Room.databaseBuilder(
            appContext,
            DataBase::class.java,
            "notes"
            ).build()

    }
}