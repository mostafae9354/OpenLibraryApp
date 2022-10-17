package com.moessa.openLibrary.module.docs_list.presentation.uimodel.mapper

import com.moessa.openLibrary.module.docs_list.domain.entity.DocsEntity
import com.moessa.openLibrary.module.docs_list.presentation.uimodel.DocUiModel

fun DocsEntity.toUiModel() = DocUiModel(
    cover = cover,
    editionCount = editionCount,
    title = title,
    authorName = authorName,
    firstPublishYear = firstPublishYear
)