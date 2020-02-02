package br.com.ajchagas.technewsapi.ui.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.com.ajchagas.technewsapi.R
import br.com.ajchagas.technewsapi.ui.activity.fragment.MainNewsFragment

class TabsPagerAdapter(val context: Context,
                       fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    companion object{
        private val TAB_TITLES =
            intArrayOf(R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3)
    }

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> MainNewsFragment.newInstance()
            else -> null
        }
    }

    override fun getCount(): Int {
        return 1
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

}
