package com.moessa.openLibrary.module.docs_list.domain.entity

data class DocsEntity(

    var cover: Int? = null,
    var editionCount: Int? = null,
    var title: String? = null,
    var authorName: String? = null,
    var firstPublishYear: Int? = null
)