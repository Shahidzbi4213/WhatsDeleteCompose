package com.cybersoft.whatsdelete.data.repositories

import android.annotation.SuppressLint
import android.app.Notification
import android.content.Context
import android.os.Bundle
import android.service.notification.StatusBarNotification
import androidx.core.graphics.drawable.toBitmap
import com.cybersoft.whatsdelete.data.database.NotificationDao
import com.cybersoft.whatsdelete.models.SingleNotification
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


// Created by Shahid Iqbal on 12/26/2022.

class NotificationRepository @Inject constructor(
    private val dao: NotificationDao,
    @ApplicationContext private val context: Context
) {

    val readNotifications = dao.getAll()


    @SuppressLint("NewApi")
     fun saveNotifications(sbn: StatusBarNotification?) {
        sbn?.notification?.extras?.let {

            val user = it.getString(Notification.EXTRA_TITLE)
            val message = it.getString(Notification.EXTRA_TEXT)
            val appIcon = sbn.notification.smallIcon?.loadDrawable(context)?.toBitmap()
            val profileImage = sbn.notification.getLargeIcon()?.loadDrawable(context)?.toBitmap()

            var detail = ""

            sbn.notification.let { notification ->
                (notification?.extras?.getParcelableArray(Notification.EXTRA_MESSAGES)
                    ?.forEach { p ->
                        val bundle = p as? Bundle
                        detail += "${bundle?.getString("sender")} :: ${bundle?.getString("text")}"
                    })
            }

            val time = SimpleDateFormat(
                "dd/MM/yyyy  hh:mm:ss a", Locale.ENGLISH
            ).format(sbn.postTime)


            if (user != null && isMessageValid(message)
                && !it.getBoolean(Notification.EXTRA_IS_GROUP_CONVERSATION)
            ) {

                SingleNotification(
                    title = user, text = message,
                    appIcon = appIcon, postTime = time,
                    profileImage = profileImage,
                    stackMsg = detail

                )
            } else null


        }.also {
            it?.let { notifications ->
                CoroutineScope(Dispatchers.IO).launch {
                    dao.insert(notifications)
                }
            }
        }
    }

    suspend fun deleteAll() {
        try {
            dao.deleteAll()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun isMessageValid(message: String?): Boolean {
        return message?.let {
            !message.contains("Checking for new messages", true)
                    && !message.contains("Photo", true)
                    && !message.contains("Photos", true)
                    && !message.contains("Video", true)
                    && !message.contains("Videos", true)
                    && !message.contains("chats", true)
                    && !message.contains("messages", true)
        } ?: false


    }
}