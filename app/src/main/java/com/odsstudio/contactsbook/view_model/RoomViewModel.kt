package com.odsstudio.contactsbook.view_model

import androidx.lifecycle.ViewModel
import com.odsstudio.contactsbook.di.useCases.database_usecase.GetNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class RoomViewModel @Inject constructor(
    getNoteUseCase: GetNoteUseCase
): ViewModel() {


}