package com.cybersoft.whatsdelete.data.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cybersoft.whatsdelete.data.repositories.NotificationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


/* Created by Shahid Iqbal on 12/26/2022. */

@HiltViewModel
class NotificationViewModel @Inject constructor(private val repo: NotificationRepository) :
    ViewModel() {

    val readNotification = repo.readNotifications.stateIn(
        viewModelScope, SharingStarted.Lazily, emptyList()
    )

    val title = mutableStateOf("Home")

    fun deleteAll() = viewModelScope.launch(Dispatchers.IO) {
        repo.deleteAll()
    }
}