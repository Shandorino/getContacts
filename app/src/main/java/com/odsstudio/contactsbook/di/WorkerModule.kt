package com.odsstudio.contactsbook.di

import com.odsstudio.contactsbook.di.useCases.PostAddUserUseCase
import com.odsstudio.contactsbook.di.useCases.PostLoginUserUseCase
import com.odsstudio.contactsbook.di.useCases.impl.PostAddUserUseCaseImpl
import com.odsstudio.contactsbook.di.useCases.impl.PostLoginUSerUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface WorkerModule {

//    @Binds
//    abstract fun bindsPostUserUseCase(postUserUseCaseImpl: PostUserUseCaseImpl): PostUserUseCase
//
//    @Binds
//    abstract fun bindsPostUserImageUseCase(postUserImageUseCaseImpl: PostUserImageUseCaseImpl): PostUserImageUseCase

    @Binds
    fun bindsPostAddUserUseCase(postAddUserUseCaseImpl: PostAddUserUseCaseImpl): PostAddUserUseCase

    @Binds
    fun bindsPostLoginUserUseCase(postLoginUserUseCaseImpl: PostLoginUSerUseCaseImpl): PostLoginUserUseCase

}