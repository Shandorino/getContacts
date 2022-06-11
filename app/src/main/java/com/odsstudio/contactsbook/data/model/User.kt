package com.odsstudio.contactsbook.data.model

data class User(
    val id: Int?,
    val name: String,
    var image: String,
    val lastName: String
) {
    fun toUserApi() = UserApi(
        name = name,
        lastName = lastName,
        image = image,
        id = id.toString()
    )
}
