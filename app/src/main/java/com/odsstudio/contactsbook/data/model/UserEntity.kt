package com.odsstudio.contactsbook.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class UserEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int?,
//    @ColumnInfo(name = "fullName")
//    val fullName: String,
//    @ColumnInfo(name = "password")
//    val password: String,
//    @ColumnInfo(name = "email")
//    val email: String,
//    @ColumnInfo(name = "phoneNumber")
//    val phoneNumber: String,
//    @ColumnInfo(name = "avatar")
//    var avatar: String,
    @ColumnInfo(name = "token")
    val token: String
) {
//    fun toUser() = User(
//        fullName = fullName,
//        password = password,
//        email = email,
//        phoneNumber = phoneNumber,
//        avatar = avatar,
//        token = token,
//        id = id?.toInt()
//    )
}
