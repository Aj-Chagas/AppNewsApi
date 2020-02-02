package br.com.ajchagas.technewsapi.retrofit.service

import br.com.ajchagas.technewsapi.model.News
import retrofit2.Call
import retrofit2.http.GET

interface ServiceNews {

    @GET("top-headlines?country=pt&apiKey=288e2e5064f4453bb4686e65de93e1e3")
    fun getTopHealinesNews() : Call<News>

    @GET("top-headlines?country=br&category=business&apiKey=288e2e5064f4453bb4686e65de93e1e3")
    fun getBusinessNews() : Call<News>

    @GET("top-headlines?country=br&category=entertainment&apiKey=288e2e5064f4453bb4686e65de93e1e3")
    fun getEntertainmentNews(): Call<News>

    @GET("top-headlines?country=br&category=technology&apiKey=288e2e5064f4453bb4686e65de93e1e3")
    fun getTechnologyNews(): Call<News>

}