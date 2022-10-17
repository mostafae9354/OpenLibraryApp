package com.moessa.openLibrary.module.docs_list.data.repository

import com.moessa.openLibrary.core.utils.NetworkHelper
import com.moessa.openLibrary.module.docs_list.data.model.DocModel
import com.moessa.openLibrary.module.docs_list.data.model.mapper.toDocModel
import com.moessa.openLibrary.module.docs_list.data.model.mapper.toDocRecord
import com.moessa.openLibrary.module.docs_list.data.source.local.DocDao
import com.moessa.openLibrary.module.docs_list.data.source.remote.DocsService
import com.moessa.openLibrary.module.docs_list.domain.repository.DocsRepository
import javax.inject.Inject

class DocsRepositoryImpl @Inject constructor(
    private val service: DocsService,
    private val docsDao: DocDao,
    private val networkHelper: NetworkHelper
) : DocsRepository {
    override suspend fun getDocsList(title: String): List<DocModel>? {
        if (networkHelper.isNetworkConnected())
            return service.getDocsList(title).body()?.docsList.also {
                docsDao.nukeTable()
                if (it != null) {
                    docsDao.insertAll(it.map { docModel ->
                        docModel.toDocRecord()
                    })
                }
            }
        return docsDao.getAll().map {
            it.toDocModel()
        }
    }
}