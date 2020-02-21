package br.com.ajchagas.technewsapi.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import br.com.ajchagas.technewsapi.NOT_CONNECTION_MSG
import br.com.ajchagas.technewsapi.ui.extension.mostraErro
import br.com.ajchagas.technewsapi.ui.viewmodel.PageNewsViewModel
import kotlinx.android.synthetic.main.default_news.*
import org.koin.android.ext.android.inject

class TechnologyNewsFragment : BaseTabsFragment() {

    private val viewModel by inject<PageNewsViewModel>()

    companion object{
        fun newInstance() : TechnologyNewsFragment {
            return TechnologyNewsFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapterOfRecycler()
        showLoading()
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
                goneLoading()
                getListOfArticles(news)?.let { articles -> adapter?.update(articles) }
            }
            it?.erro?.let {
                mostraErro(NOT_CONNECTION_MSG)
            }
        })
    }
}
