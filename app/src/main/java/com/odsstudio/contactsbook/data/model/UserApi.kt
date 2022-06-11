package com.odsstudio.contactsbook.data.model

import com.google.gson.annotations.SerializedName

data class UserApi(
    @SerializedName("name")
    val name: String,
    @SerializedName("lastname")
    val lastName: String,
    @SerializedName("image")
    var image: String,
    @SerializedName("id")
    val id: String?
) {
    fun toUser() = User(
        name = name,
        lastName = lastName,
        image = image,
        id = id?.toInt()
    )
}
