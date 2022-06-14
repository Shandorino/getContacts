package com.odsstudio.contactsbook.data.model

data class User(

    val id: Int?,
    val fullName: String,
    val email: String,
    var avatar: String,
) {
    fun toUserApi() = UserApi(
        fullName = fullName,
        email = email,
        avatar = avatar,
        id = id?.toInt()
    )
}
