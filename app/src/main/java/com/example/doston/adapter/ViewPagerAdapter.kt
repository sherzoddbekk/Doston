package com.example.doston.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.doston.ui.fragment.forThreeAgo.BearFragment
import com.example.doston.ui.fragment.forThreeAgo.CatFragment
import com.example.doston.ui.fragment.forThreeAgo.DogFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 3 // Number of fragments
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> DogFragment() // Replace Fragment1 with your first fragment class
            1 -> CatFragment() // Replace Fragment2 with your second fragment class
            2 -> BearFragment() // Replace Fragment3 with your third fragment class
            else -> DogFragment()
        }
    }
}