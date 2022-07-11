package com.example.customviewapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyFragmentAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragmentThree.newInstanceModeOne()
            1 -> FragmentThree.newInstanceModeTwo()
            2 -> FragmentThree.newInstanceModeThree()
            else -> FragmentThree.newInstanceModeOne()
        }
    }
}