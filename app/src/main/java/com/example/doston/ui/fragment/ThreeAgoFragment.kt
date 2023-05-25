package com.example.doston.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.doston.R
import com.example.doston.adapter.ViewPagerAdapter
import com.example.doston.databinding.FragmentHomeBinding
import com.example.doston.databinding.FragmentThreeAgoBinding
import viewBinding

class ThreeAgoFragment : Fragment(R.layout.fragment_three_ago) {
    private lateinit var viewPager: ViewPager2
    private val binding by viewBinding { FragmentThreeAgoBinding.bind(it) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }


    private fun initView() {
        viewPager = binding.viewPager
        val adapter = ViewPagerAdapter(requireActivity())
        viewPager.adapter = adapter

        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}