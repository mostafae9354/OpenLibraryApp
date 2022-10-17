package com.moessa.openLibrary.module.docs_list.data.model.mapper

import com.moessa.openLibrary.module.docs_list.data.model.DocModel
import com.moessa.openLibrary.module.docs_list.data.model.DocTable
import com.moessa.openLibrary.module.docs_list.domain.entity.DocsEntity

fun DocModel.toEntity() = DocsEntity(
    cover = cover,
    editionCount = editionCount,
    title = title,
    authorName = authorNames?.get(0),
    firstPublishYear = firstPublishYear
)

fun DocModel.toDocRecord() = DocTable(
    cover = cover,
    editionCount = editionCount,
    title = title,
    authorName = authorNames?.get(0),
    firstPublishYear = firstPublishYear
)

fun DocTable.toDocModel() = DocModel(
    cover = cover,
    editionCount = editionCount,
    title = title,
    authorNames = arrayListOf(authorName ?: ""),
    firstPublishYear = firstPublishYear
)