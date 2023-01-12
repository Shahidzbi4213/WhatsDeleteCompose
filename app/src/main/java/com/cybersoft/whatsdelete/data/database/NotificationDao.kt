package com.cybersoft.whatsdelete.data.database


// Created by Shahid Iqbal on 08/01/2023.

import androidx.room.*
import com.cybersoft.whatsdelete.models.SingleNotification
import kotlinx.coroutines.flow.Flow

@Dao
interface NotificationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(singleNotification: SingleNotification)

    @Delete
    suspend fun delete(singleNotification: SingleNotification)

    @Query("DELETE  FROM tbl_notifications")
    suspend fun deleteAll()

    @Query("SELECT * FROM tbl_notifications")
    fun getAll(): Flow<List<SingleNotification>>

}