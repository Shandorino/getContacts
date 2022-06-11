package com.odsstudio.contactsbook.di.useCases

import com.odsstudio.contactsbook.data.model.UserApi
import okhttp3.MultipartBody

interface PostUserUseCase {

    operator fun invoke(userApi: UserApi)
}