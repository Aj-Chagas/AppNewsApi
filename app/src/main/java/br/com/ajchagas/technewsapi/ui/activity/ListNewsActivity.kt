package br.com.ajchagas.technewsapi.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import br.com.ajchagas.technewsapi.R
import br.com.ajchagas.technewsapi.repository.RepositoryNews
import br.com.ajchagas.technewsapi.retrofit.webClient.NewsWebClient
import br.com.ajchagas.technewsapi.ui.activity.extension.mostraErro
import br.com.ajchagas.technewsapi.ui.viewmodel.ListNewsViewModel
import br.com.ajchagas.technewsapi.ui.viewmodel.factory.ListNewsViewModelFactory


class ListNewsActivity : AppCompatActivity() {

    private val viewmodel by lazy {
        //A partir do provedor é possivel identificar se a Activity foi recriada por meio de mudanças de configuração e, caso positivo, se ele consegue enviar a mesma instância criada da primeira vez, do ViewModel, e é por isto que precisamos do provedor, para controlar esta responsabilidade para nós.
        val repository = RepositoryNews()
        val factory = ListNewsViewModelFactory(repository)
        val provedor = ViewModelProviders.of(this, factory)
        provedor.get(ListNewsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewmodel.buscaNoticias(quandoSucesso = {
            val articles = it?.articles
            val article = articles?.get(0)
            article?.title.toString()

        }, quandoFalha = {
            mostraErro("Não foi possível carregar as notícias")
        })

    }


}
