package com.odsstudio.contactsbook.di

import com.odsstudio.contactsbook.di.useCases.PostUserImageUseCase
import com.odsstudio.contactsbook.di.useCases.PostUserUseCase
import com.odsstudio.contactsbook.di.useCases.impl.PostUserImageUseCaseImpl
import com.odsstudio.contactsbook.di.useCases.impl.PostUserUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class WorkerModule {

    @Binds
    abstract fun bindsPostUserUseCase(postUserUseCaseImpl: PostUserUseCaseImpl): PostUserUseCase

    @Binds
    abstract fun bindsPostUserImageUseCase(postUserImageUseCaseImpl: PostUserImageUseCaseImpl): PostUserImageUseCase
}