package com.example.doston.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.doston.R
import com.example.doston.databinding.FragmentHomeBinding
import viewBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding { FragmentHomeBinding.bind(it) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }


    private fun initView() {

        binding.tv3.setOnClickListener {
            findNavController().navigate(R.id.threeAgoFragment)
        }
        binding.tv4.setOnClickListener {
            findNavController().navigate(R.id.fourAgoFragment)
        }
        binding.tv5.setOnClickListener {
            findNavController().navigate(R.id.fiveAgoFragment)
        }
        binding.tv6.setOnClickListener {
            findNavController().navigate(R.id.sixAgoFragment)
        }

    }

}