package br.com.ajchagas.technewsapi.ui.fragment

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
import br.com.ajchagas.technewsapi.ui.adapter.RecyclerViewListNewsAdapter
import br.com.ajchagas.technewsapi.ui.extension.mostraErro
import br.com.ajchagas.technewsapi.ui.viewmodel.PageViewModel
import kotlinx.android.synthetic.main.default_news.*
import org.koin.android.ext.android.inject

class EntertainmentNewsFragment : Fragment(){

    var whenNewsClicked: (Article) -> Unit = {}

    private val viewModel by inject<PageViewModel>()

    private val adapter by inject<RecyclerViewListNewsAdapter>()

    companion object{
        fun newInstance() : EntertainmentNewsFragment {
            return EntertainmentNewsFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.default_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapterOfRecycler()
        getTopHealinesNews()
        setupRefresh()
    }

    private fun setupRefresh() {
        activity_main_swipe.setOnRefreshListener {
            viewModel.getEntertainmentNews()
        }
    }

    private fun setupAdapterOfRecycler() {
        val recyclerView = activity_main_recyclerview
        recyclerView.adapter = adapter
        setupAdapterRecyclerView()
    }

    private fun setupAdapterRecyclerView() {
        adapter?.clickListener = whenNewsClicked
    }

    private fun getTopHealinesNews() {
        viewModel.getEntertainmentNews().observe(this, Observer {
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
