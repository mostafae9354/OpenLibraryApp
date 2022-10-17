package com.moessa.openLibrary.core.di.module

import android.content.Context
import androidx.room.Room
import com.moessa.openLibrary.module.docs_list.data.source.local.AppDatabase
import com.moessa.openLibrary.module.docs_list.data.source.local.DocDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideLogDao(database: AppDatabase): DocDao = database.docDao()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase =
        Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "docs.db"
        ).build()
}