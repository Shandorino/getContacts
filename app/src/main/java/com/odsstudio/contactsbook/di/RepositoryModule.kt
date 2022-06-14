package com.odsstudio.contactsbook.di

import com.odsstudio.contactsbook.di.repositories.ApiRepository
import com.odsstudio.contactsbook.di.repositories.DataBaseRepository
import com.odsstudio.contactsbook.di.repositories.impl.ApiRepositoryImpl
import com.odsstudio.contactsbook.di.repositories.impl.DataBaseRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsApiRepository(apiRepositoryImpl: ApiRepositoryImpl): ApiRepository

}