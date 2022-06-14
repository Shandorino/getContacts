package com.odsstudio.contactsbook.di.useCases

import okhttp3.MultipartBody
import okhttp3.RequestBody

interface PostAddUserUseCase {

    operator fun invoke(part: MultipartBody.Part, partMap: LinkedHashMap<String, RequestBody>)

}