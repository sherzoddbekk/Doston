package com.example.doston.ui.fragment.forThreeAgo

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.doston.R
import com.example.doston.databinding.FragmentDogForThreeAgoBinding
import com.example.doston.databinding.FragmentThreeAgoBinding
import viewBinding

class DogFragment:Fragment(R.layout.fragment_dog_for_three_ago) {
    private lateinit var mediaPlayer: MediaPlayer
    private val binding by viewBinding { FragmentDogForThreeAgoBinding.bind(it) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }


    private fun initView() {
        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.s_dog) // Replace "your_sound" with the sound file name
        binding.speaker.setOnClickListener {
            mediaPlayer.start()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

}