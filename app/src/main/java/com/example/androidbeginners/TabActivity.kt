package com.example.androidbeginners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab.*
import timber.log.Timber

class TabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)

        Timber.d("personArray in TabActivity: $personArray")
        setUpTabLayout()
    }

    private fun setUpTabLayout() {
        tab_layout.addTab(tab_layout.newTab().setText("List View"))
        tab_layout.addTab(tab_layout.newTab().setText("Recycler View"))
        tab_layout.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = TabAdapter(supportFragmentManager, tab_layout.tabCount)
        adapter.addFragment(ListFragment.newInstance(personArray), "List Fragment")
        adapter.addFragment(RecyclerFragment.newInstance(personArray), "Recycler Fragment")
        view_pager_layout.adapter = adapter

        tab_layout.setupWithViewPager(view_pager_layout)
//        tab_layout.addOnTabSelectedListener()
    }
}
