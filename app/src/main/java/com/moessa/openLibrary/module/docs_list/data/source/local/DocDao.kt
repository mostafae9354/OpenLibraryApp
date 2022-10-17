package com.moessa.openLibrary.module.docs_list.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.moessa.openLibrary.module.docs_list.data.model.DocTable

/**
 * Data access object to query the database.
 */
@Dao
interface DocDao {

    @Query("SELECT * FROM docs ORDER BY id DESC")
    fun getAll(): List<DocTable>

    @Insert
    fun insertAll(docs: List<DocTable>)

    @Query("DELETE FROM docs")
    fun nukeTable()
}
