package br.com.ajchagas.technewsapi.ui.activity.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import br.com.ajchagas.technewsapi.NOT_CONNECTION_MSG
import br.com.ajchagas.technewsapi.R
import br.com.ajchagas.technewsapi.model.Article
import br.com.ajchagas.technewsapi.model.News
import br.com.ajchagas.technewsapi.ui.activity.extension.mostraErro
import br.com.ajchagas.technewsapi.ui.adapter.RecyclerViewListNewsAdapter
import br.com.ajchagas.technewsapi.ui.viewmodel.ListNewsViewModel
import kotlinx.android.synthetic.main.main_news_fragments.*
import org.koin.android.ext.android.inject

class MainNewsFragment : Fragment() {

    var whenNewsClicked: (Article) -> Unit = {}

    private val viewModel by inject<ListNewsViewModel>()

    private val adapter by inject<RecyclerViewListNewsAdapter>()

    companion object{
        fun newInstance() : MainNewsFragment {
            return MainNewsFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_news_fragments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configuraAdapterDoRecycler()
        buscaNoticias()
        configuraRefresh()
    }

    private fun configuraRefresh() {
        activity_main_swipe.setOnRefreshListener {
            viewModel.buscaNoticias()
        }
    }

    private fun configuraAdapterDoRecycler() {
        val recyclerView = activity_main_recyclerview
        recyclerView.adapter = adapter
        configuraAdapter()
    }

    private fun configuraAdapter() {
        adapter?.clickListener = whenNewsClicked
    }

    private fun buscaNoticias() {
        viewModel.buscaNoticias().observe(this, Observer {
            activity_main_swipe.isRefreshing = false
            it?.dado?.let { news ->
                getListOfArticles(news)?.let { articles -> adapter?.update(articles) }
            }
            it?.erro?.let {
                mostraErro(NOT_CONNECTION_MSG)
            }
        })
    }

    private fun getListOfArticles(news: News) = news?.articles
}
