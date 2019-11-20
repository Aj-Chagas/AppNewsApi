package br.com.ajchagas.technewsapi.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.ajchagas.technewsapi.R
import br.com.ajchagas.technewsapi.model.News
import br.com.ajchagas.technewsapi.repository.RepositoryNews
import br.com.ajchagas.technewsapi.retrofit.RetrofitConfig
import br.com.ajchagas.technewsapi.retrofit.service.ServiceNews
import br.com.ajchagas.technewsapi.retrofit.webClient.NewsWebClient
import br.com.ajchagas.technewsapi.ui.activity.extension.mostraErro
import br.com.ajchagas.technewsapi.ui.reciclerview.adapter.ListNewsAdapter
import br.com.ajchagas.technewsapi.ui.viewmodel.ListNewsViewModel
import br.com.ajchagas.technewsapi.ui.viewmodel.factory.ListNewsViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Retrofit


class ListNewsActivity : AppCompatActivity() {

    private val viewmodel by lazy {
        //A partir do provedor é possivel identificar se a Activity foi recriada por meio de mudanças de configuração e, caso positivo, se ele consegue enviar a mesma instância criada da primeira vez, do ViewModel, e é por isto que precisamos do provedor, para controlar esta responsabilidade para nós.
        val repository = RepositoryNews()
        val factory = ListNewsViewModelFactory(repository)
        val provedor = ViewModelProviders.of(this, factory)
        provedor.get(ListNewsViewModel::class.java)
    }

    private val adapter by lazy{
        ListNewsAdapter(context = this, clickListener = { article ->
            val intent = Intent(this, DetailsNewsActivity::class.java)
            intent.putExtra("url", article.url)
            intent.putExtra("title", article.title)
            startActivity(intent)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configuraAdapterDoRecycler()
        buscaNoticias()
        title = "Home"

        activity_main_swipe.setOnRefreshListener {
            viewmodel.buscaNoticias()
        }
    }

    private fun configuraAdapterDoRecycler() {
        val recyclerView = activity_main_recyclerview
        recyclerView.adapter = adapter
    }


    private fun buscaNoticias() {
        viewmodel.buscaNoticias().observe(this, Observer {
            activity_main_swipe.isRefreshing = false
            it?.dado?.let {
                val articles = it?.articles
                articles?.let { artigos -> adapter.atualiza(artigos)
                }
            }

            it?.erro?.let {
                mostraErro("Sem conexão com a internet")

            }

        })
    }
}
