package com.cybersoft.whatsdelete.data.database

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream


// Created by Shahid Iqbal on 08/01/2023.


class IconConverter() {

    @TypeConverter
    fun fromIcon(icon: Bitmap?): ByteArray? {
        return if (icon == null) {
            null
        } else {
            val outputStream = ByteArrayOutputStream()
            icon.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
            outputStream.toByteArray()
        }
    }

    @TypeConverter
    fun toIcon(iconByteArray: ByteArray?): Bitmap? {
        return if (iconByteArray == null) {
            null
        } else {
            BitmapFactory.decodeByteArray(iconByteArray, 0, iconByteArray.size)
        }
    }
}
