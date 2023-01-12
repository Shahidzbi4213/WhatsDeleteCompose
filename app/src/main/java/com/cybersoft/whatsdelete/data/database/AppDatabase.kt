package com.cybersoft.whatsdelete.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cybersoft.whatsdelete.models.SingleNotification


// Created by Shahid Iqbal on 08/01/2023.

@Database(
    entities = [SingleNotification::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(IconConverter::class)
abstract class AppDatabase : RoomDatabase() {

   abstract fun mainDao(): NotificationDao
}