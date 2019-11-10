package br.com.ajchagas.technewsapi.model

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("source") val source : Source,
    @SerializedName("author") val author: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("url") val url: String,
    @SerializedName("urlToImage") val urlToImage: String,
    @SerializedName("publishedAt") val publisheAt: String,
    @SerializedName("content") val content: String
)


