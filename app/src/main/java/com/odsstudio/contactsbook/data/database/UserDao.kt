package com.odsstudio.contactsbook.data.database

import androidx.room.*
import com.odsstudio.contactsbook.data.model.UserEntity


@Dao
interface UserDao {

    @Query("SELECT * FROM userentity")
    suspend fun getTokens(): List<UserEntity>

//    @Query("SELECT * FROM userentity WHERE id IN (:userId)")
//    suspend fun getToken(userId: Int): String

    @Insert(onConflict = OnConflictStrategy.REPLACE, )
    suspend fun insertToken(user: UserEntity)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertUsers(tokens: List<UserEntity>)

    @Delete
    suspend fun deleteUser(token: UserEntity)
}