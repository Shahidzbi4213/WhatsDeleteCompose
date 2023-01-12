package com.cybersoft.whatsdelete.data.di

import android.content.Context
import androidx.room.Room
import com.cybersoft.whatsdelete.data.database.AppDatabase
import com.cybersoft.whatsdelete.data.database.NotificationDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


// Created by Shahid Iqbal on 12/26/2022.

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "app_db").build()

    @Singleton
    @Provides
    fun NotificationDao(appDatabase: AppDatabase): NotificationDao = appDatabase.mainDao()
}