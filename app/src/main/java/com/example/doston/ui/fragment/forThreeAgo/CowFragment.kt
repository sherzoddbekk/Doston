package com.example.doston.ui.fragment.forThreeAgo

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.doston.R
import com.example.doston.databinding.FragmentBearForThreeAgoBinding
import com.example.doston.databinding.FragmentCatForThreeAgoBinding
import com.example.doston.databinding.FragmentCowForThreeAgoBinding
import viewBinding

class CowFragment:Fragment(R.layout.fragment_cow_for_three_ago) {

    private lateinit var mediaPlayer: MediaPlayer
    private val binding by viewBinding { FragmentCowForThreeAgoBinding.bind(it) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }


    private fun initView() {
        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.s_cow) // Replace "your_sound" with the sound file name
        binding.speaker.setOnClickListener {
            mediaPlayer.start()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }


}