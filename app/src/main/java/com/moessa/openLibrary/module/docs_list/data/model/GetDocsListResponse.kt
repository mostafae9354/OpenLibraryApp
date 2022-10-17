package com.moessa.openLibrary.module.docs_list.data.model

import com.google.gson.annotations.SerializedName

data class GetDocsListResponse(
    @SerializedName("start") var start: Int? = null,
    @SerializedName("num_found") var numFound: String? = null,
    @SerializedName("docs") var docsList: ArrayList<DocModel>? = null
)