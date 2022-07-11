package com.example.customviewapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pager: ViewPager2 = findViewById(R.id.pager)
        val pageAdapter = MyFragmentAdapter(this)
        pager.adapter = pageAdapter
        val tab_layout: TabLayout = findViewById(R.id.tab_layout);
        val tabLayoutMediator = TabLayoutMediator(
            tab_layout, pager, true
        ) { tab, position -> }
        tabLayoutMediator.attach()
    }
}