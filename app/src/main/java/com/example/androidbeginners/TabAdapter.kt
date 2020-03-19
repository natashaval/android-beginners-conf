package com.example.androidbeginners

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

//https://demonuts.com/kotlin-tablayout/
class TabAdapter(manager: FragmentManager, totalTabs: Int): FragmentPagerAdapter(manager, totalTabs) {
    private val tabCount: Int = totalTabs
    private var fragmentList = ArrayList<Fragment>()
    private var fragmentTitle = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return tabCount
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitle[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitle.add(title)
    }
}