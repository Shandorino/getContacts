package com.odsstudio.contactsbook.di.useCases

import okhttp3.MultipartBody

interface PostUserImageUseCase {

    operator fun invoke(part: MultipartBody.Part)
}