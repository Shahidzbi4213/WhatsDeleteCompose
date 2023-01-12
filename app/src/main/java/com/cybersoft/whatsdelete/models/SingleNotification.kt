package com.cybersoft.whatsdelete.models

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey


// Created by Shahid Iqbal on 12/26/2022.

@Entity(tableName = "tbl_notifications")
data class SingleNotification(

    val title: String?,
    val text: String?,
    val appIcon: Bitmap?,
    val stackMsg:String?,
    val profileImage: Bitmap?,
    @PrimaryKey
    val postTime: String,
)