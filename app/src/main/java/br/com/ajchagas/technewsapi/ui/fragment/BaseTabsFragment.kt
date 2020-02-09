package br.com.ajchagas.technewsapi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.ajchagas.technewsapi.R
import br.com.ajchagas.technewsapi.model.Article
import br.com.ajchagas.technewsapi.model.News
import br.com.ajchagas.technewsapi.ui.adapter.RecyclerViewListNewsAdapter
import kotlinx.android.synthetic.main.default_news.*
import org.koin.android.ext.android.inject

open class BaseTabsFragment : Fragment() {

    var whenNewsClicked: (Article) -> Unit = {}

    protected val adapter by inject<RecyclerViewListNewsAdapter>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.default_news, container, false)
    }

    protected fun setupAdapterOfRecycler() {
        val recyclerView = activity_main_recyclerview
        recyclerView.adapter = adapter
        setupAdapterRecyclerView()
    }

    private fun setupAdapterRecyclerView() {
        adapter?.clickListener = whenNewsClicked
    }

    protected fun getListOfArticles(news: News) = news?.articles
}