package com.odsstudio.contactsbook.di

import com.odsstudio.contactsbook.di.useCases.GetUserUseCase
import com.odsstudio.contactsbook.di.useCases.PostUserUseCase
import com.odsstudio.contactsbook.di.useCases.impl.GetUserUseCaseImpl
import com.odsstudio.contactsbook.di.useCases.impl.PostUserUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCasesModule {

    @Binds
    abstract fun bindsGetUserUseCase(getUserUseCaseImpl: GetUserUseCaseImpl): GetUserUseCase

    @Binds
    abstract fun bindsPostUserUseCase(postUserUseCaseImpl: PostUserUseCaseImpl): PostUserUseCase
}