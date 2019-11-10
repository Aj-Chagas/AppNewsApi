package br.com.ajchagas.technewsapi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.ajchagas.technewsapi.retrofit.webClient.NewsWebClient

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NewsWebClient().buscaNoticias(quandoSucesso = {
            val articles = it?.articles
            val article = articles?.get(0)
            article?.title.toString()

        }, quandoFalha = {
            Toast.makeText(this, it, Toast.LENGTH_LONG)
        })

    }


}
