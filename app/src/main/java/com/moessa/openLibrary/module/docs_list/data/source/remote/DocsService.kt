package com.moessa.openLibrary.module.docs_list.data.source.remote

import com.moessa.openLibrary.module.docs_list.data.model.GetDocsListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DocsService {
    @GET("search.json")
    suspend fun getDocsList(
        @Query("title") title: String
    ): Response<GetDocsListResponse>
}