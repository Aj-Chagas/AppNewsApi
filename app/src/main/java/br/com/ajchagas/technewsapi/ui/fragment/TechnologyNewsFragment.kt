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

class TechnologyNewsFragment : BaseTabsFragment() {

    private val viewModel by inject<PageViewModel>()

    companion object{
        fun newInstance() : TechnologyNewsFragment {
            return TechnologyNewsFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapterOfRecycler()
        getTopHealinesNews()
        setupRefresh()
    }

    private fun setupRefresh() {
        activity_main_swipe.setOnRefreshListener {
            viewModel.getTechnologyNews()
        }
    }

    private fun getTopHealinesNews() {
        viewModel.getTechnologyNews().observe(this, Observer {
            activity_main_swipe.isRefreshing = false
            it?.dado?.let { news ->
                getListOfArticles(news)?.let { articles -> adapter?.update(articles) }
            }
            it?.erro?.let {
                mostraErro(NOT_CONNECTION_MSG)
            }
        })
    }
}
