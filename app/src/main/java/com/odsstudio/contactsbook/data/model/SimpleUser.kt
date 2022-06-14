package com.odsstudio.contactsbook.data.model

import com.google.gson.annotations.SerializedName

data class SimpleUser(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)
