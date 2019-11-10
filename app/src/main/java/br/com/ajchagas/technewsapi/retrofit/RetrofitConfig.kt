package br.com.ajchagas.technewsapi.retrofit

import br.com.ajchagas.technewsapi.retrofit.service.ServiceNews
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {

    private val BASE_URL: String = "https://newsapi.org/v2/"

    private val client by lazy{
        val interceptador = HttpLoggingInterceptor()
        interceptador.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
            .addInterceptor(interceptador)
            .build()
    }


    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val serviceNews : ServiceNews by lazy {
        retrofit.create(ServiceNews::class.java)
    }

}