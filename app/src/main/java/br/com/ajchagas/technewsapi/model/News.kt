package br.com.ajchagas.technewsapi.model

import com.google.gson.annotations.SerializedName

class News(
    @SerializedName("status") val status: String,
    @SerializedName("totalResults") val totalResults: Int,
    @SerializedName("articles") val articles: List<Article>
)

