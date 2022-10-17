package com.moessa.openLibrary.module.docs_list.domain.usecase

import com.moessa.openLibrary.module.docs_list.data.model.DocModel
import com.moessa.openLibrary.module.docs_list.domain.entity.param.GetDocsListParam
import com.moessa.openLibrary.module.docs_list.domain.repository.DocsRepository
import javax.inject.Inject

class GetDocsListUseCase @Inject constructor(private val repository: DocsRepository) {
    suspend operator fun invoke(param: GetDocsListParam): List<DocModel>? {
        return with(param) {
            repository.getDocsList(title)
        }
    }
}