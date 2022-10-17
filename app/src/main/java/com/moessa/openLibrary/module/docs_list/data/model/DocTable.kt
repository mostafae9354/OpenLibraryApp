package com.moessa.openLibrary.module.docs_list.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "docs")
data class DocTable(
    var cover: Int? = null,
    var editionCount: Int? = null,
    var title: String? = null,
    var authorName: String? = null,
    var firstPublishYear: Int? = null
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}