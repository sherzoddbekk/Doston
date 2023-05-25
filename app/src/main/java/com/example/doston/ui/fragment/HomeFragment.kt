package com.example.doston.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.doston.R
import com.example.doston.databinding.ActivityMainBinding
import com.example.doston.databinding.FragmnetHomeBinding

class HomeFragment : Fragment(R.layout.fragmnet_home) {

    private lateinit var binding: FragmnetHomeBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }


    private fun initView() {

        binding.tv3.setOnClickListener {
            findNavController().navigate(R.id.threeAgoFragment)
        }
    }

}