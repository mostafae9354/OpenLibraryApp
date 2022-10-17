package com.moessa.openLibrary.module.docs_list.domain.repository

import com.moessa.openLibrary.module.docs_list.data.model.DocModel

interface DocsRepository {
    suspend fun getDocsList(title: String): List<DocModel>?
}