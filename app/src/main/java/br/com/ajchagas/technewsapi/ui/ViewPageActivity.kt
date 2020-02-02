package br.com.ajchagas.technewsapi.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import br.com.ajchagas.technewsapi.R
import br.com.ajchagas.technewsapi.TITLE_KEY
import br.com.ajchagas.technewsapi.URL_KEY
import br.com.ajchagas.technewsapi.model.Article
import br.com.ajchagas.technewsapi.ui.activity.DetailsNewsActivity
import br.com.ajchagas.technewsapi.ui.activity.fragment.EntertainmentNewsFragment
import br.com.ajchagas.technewsapi.ui.fragment.MainNewsFragment
import br.com.ajchagas.technewsapi.ui.adapter.TabsPagerAdapter
import br.com.ajchagas.technewsapi.ui.fragment.BusinessNewsFragment
import kotlinx.android.synthetic.main.activity_view_page.*

class ViewPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_page)
        setupTabsPagerAdapter()
    }

    private fun setupTabsPagerAdapter() {
        view_pager.adapter = TabsPagerAdapter(this, supportFragmentManager)
        tabs.setupWithViewPager(view_pager)
    }

    override fun onAttachFragment(fragment: Fragment?) {
        super.onAttachFragment(fragment)
        when(fragment){
            is MainNewsFragment -> fragment.whenNewsClicked = this::openDetailsNewsActivity
            is BusinessNewsFragment -> fragment.whenNewsClicked = this::openDetailsNewsActivity
            is EntertainmentNewsFragment -> fragment.whenNewsClicked = this::openDetailsNewsActivity
        }
    }

    private fun openDetailsNewsActivity(article : Article) {
        val intent = Intent(this, DetailsNewsActivity::class.java)
        intent.putExtra(URL_KEY, article.url)
        intent.putExtra(TITLE_KEY, article.title)
        startActivity(intent)
    }
}
