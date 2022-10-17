package com.moessa.openLibrary.module.docs_list.data.model

import com.google.gson.annotations.SerializedName

data class DocModel(
    @SerializedName("cover_i") var cover: Int? = null,
    @SerializedName("edition_count") var editionCount: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("author_name") var authorNames: ArrayList<String>? = null,
    @SerializedName("first_publish_year") var firstPublishYear: Int? = null
)