package br.com.ajchagas.technewsapi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import br.com.ajchagas.technewsapi.model.News
import br.com.ajchagas.technewsapi.retrofit.RetrofitConfig
import br.com.ajchagas.technewsapi.retrofit.webClient.NewsWebClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getNews()


    }

    private fun getNews() {
        val serviceNews = RetrofitConfig().serviceNews
        val call = serviceNews.getNewsApi()

        call.enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.i("teste", "deu falha")
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                Log.i("teste", "deu sucesseso")
            }


        })
    }

}
