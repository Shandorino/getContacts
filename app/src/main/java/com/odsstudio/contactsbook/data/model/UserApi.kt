package com.odsstudio.contactsbook.data.model


import com.google.gson.annotations.SerializedName

data class UserApi(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("fullName")
    val fullName: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("avatar")
    var avatar: String
) {
    fun toUser() = User(
        fullName = fullName,
        email = email,
        avatar = avatar,
        id = id?.toInt()
    )
}
