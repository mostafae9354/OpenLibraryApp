package com.moessa.openLibrary.module.docs_list.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.moessa.openLibrary.module.docs_list.data.model.DocTable

/**
 * SQLite Database for storing the logs.
 */
@Database(entities = [DocTable::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun docDao(): DocDao
}
