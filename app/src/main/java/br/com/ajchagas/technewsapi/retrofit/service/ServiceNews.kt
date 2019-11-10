package br.com.ajchagas.technewsapi.retrofit.service

import br.com.ajchagas.technewsapi.model.News
import retrofit2.Call
import retrofit2.http.GET

interface ServiceNews {

    @GET("top-headlines?country=us&apiKey=288e2e5064f4453bb4686e65de93e1e3")
    fun getNewsApi() : Call<News>
}