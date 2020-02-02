package br.com.ajchagas.technewsapi.ui.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.com.ajchagas.technewsapi.R
import br.com.ajchagas.technewsapi.ui.activity.fragment.EntertainmentNewsFragment
import br.com.ajchagas.technewsapi.ui.activity.fragment.TechnologyNewsFragment
import br.com.ajchagas.technewsapi.ui.fragment.BusinessNewsFragment
import br.com.ajchagas.technewsapi.ui.fragment.MainNewsFragment

class TabsPagerAdapter(
    private val context: Context,
    fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    companion object{
        private val TAB_TITLES =
            intArrayOf(R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3, R.string.tab_text_4)
    }

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> MainNewsFragment.newInstance()
            1 -> BusinessNewsFragment.newInstance()
            2 -> EntertainmentNewsFragment.newInstance()
            3 -> TechnologyNewsFragment.newInstance()
            else -> null
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

}
