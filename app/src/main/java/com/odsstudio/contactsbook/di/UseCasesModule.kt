package com.odsstudio.contactsbook.di

import com.odsstudio.contactsbook.di.useCases.GetUserUseCase
import com.odsstudio.contactsbook.di.useCases.GetUsersUseCase
import com.odsstudio.contactsbook.di.useCases.PostAddUserUseCase
import com.odsstudio.contactsbook.di.useCases.PostLoginUserUseCase
import com.odsstudio.contactsbook.di.useCases.database_usecase.*
import com.odsstudio.contactsbook.di.useCases.database_usecase.impl.*
import com.odsstudio.contactsbook.di.useCases.impl.GetUserUseCaseImpl
import com.odsstudio.contactsbook.di.useCases.impl.GetUsersUseCaseImpl
import com.odsstudio.contactsbook.di.useCases.impl.PostAddUserUseCaseImpl
import com.odsstudio.contactsbook.di.useCases.impl.PostLoginUSerUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
interface UseCasesModule {

    @Binds
    fun bindsGetUserUseCase(getUserUseCaseImpl: GetUserUseCaseImpl): GetUserUseCase

    @Binds
    fun bindsPostAddUserUseCase(postAddUserUseCaseImpl: PostAddUserUseCaseImpl): PostAddUserUseCase

    @Binds
    fun bindsPostLoginUserUseCase(postLoginUSerUseCaseImpl: PostLoginUSerUseCaseImpl): PostLoginUserUseCase

    @Binds
    fun bindsGetUsersUseCase(getUsersUseCaseImpl: GetUsersUseCaseImpl): GetUsersUseCase

    //DataBase Binds

    @Binds
    fun bindsGetNoteUseCase(getNoteUseCaseImpl: GetNoteUseCaseImpl): GetNoteUseCase

    @Binds
    fun bindsGetNotesUseCase(getNotesUseCaseImpl: GetNotesUseCaseImpl): GetNotesUseCase

    @Binds
    fun bindsInsertNoteUseCase(insertNoteUseCaseImpl: InsertNoteUseCaseImpl): InsertNoteUseCase

    @Binds
    fun bindsInsertNoteUseCase(insertNoteUseCaseImpl: InsertNotesUseCaseImpl): InsertNotesUseCase

    @Binds
    fun bindsDeleteNoteUseCase(deleteNoteUseCaseImpl: DeleteNoteUseCaseImpl): DeleteNoteUseCase

}