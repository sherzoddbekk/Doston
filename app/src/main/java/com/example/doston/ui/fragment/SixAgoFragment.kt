package com.example.doston.ui.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.doston.R
import com.example.doston.databinding.FragmentFiveAgoBinding
import com.example.doston.databinding.FragmentSixAgoBinding
import com.example.doston.model.TestsAgeFive
import com.example.doston.model.TestsAgeSix
import viewBinding

class SixAgoFragment:Fragment(R.layout.fragment_six_ago) {
    private val binding by viewBinding { FragmentSixAgoBinding.bind(it) }

    private var testsAgeSixList: MutableList<TestsAgeSix> = arrayListOf()
    private var images = listOf<Int>(
        R.drawable.im_clock_12_30,
        R.drawable.im_clock_04_00,
        R.drawable.im_clock_07_30,
        R.drawable.im_clock_09_06,
        R.drawable.im_clock_11_00,
        R.drawable.im_clock_07_48,
        R.drawable.im_clock_03_32,
        R.drawable.im_clock_04_56,
        R.drawable.im_clock_03_10,
        R.drawable.im_clock_06_00
    )
    private var currentQ = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillTests()
        testsAgeSixList.shuffle()
        initView()

        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun initView() {
        setTest(currentQ)
        binding.apply {

            tvAnswer1.setOnClickListener {

                if (testsAgeSixList[currentQ].correctAnswer == 0) {
                    if (currentQ < testsAgeSixList.size - 1) {
                        currentQ++
                        showCorrectDialog()
                    } else if (currentQ == testsAgeSixList.size - 1) showCompleteDialog()
                } else showWrongDialog()
            }

            tvAnswer2.setOnClickListener {
                if (testsAgeSixList[currentQ].correctAnswer == 1) {
                    if (currentQ < testsAgeSixList.size - 1) {
                        currentQ++
                        showCorrectDialog()
                    } else if (currentQ == testsAgeSixList.size - 1) showCompleteDialog()
                } else showWrongDialog()
            }

            tvAnswer3.setOnClickListener {
                if (testsAgeSixList[currentQ].correctAnswer == 2) {
                    if (currentQ < testsAgeSixList.size - 1) {
                        currentQ++
                        showCorrectDialog()
                    } else if (currentQ == testsAgeSixList.size - 1) showCompleteDialog()
                } else showWrongDialog()
            }

        }

    }

    private fun setTest(index: Int){
        val testsAgeSix = testsAgeSixList[index]
        binding.apply {
            ivClock.setImageResource(testsAgeSix.image)
            tvAnswer1.text = testsAgeSix.answers[0]
            tvAnswer2.text = testsAgeSix.answers[1]
            tvAnswer3.text = testsAgeSix.answers[2]
        }
    }

    private fun showCorrectDialog() {
        val alertDialog = AlertDialog.Builder(requireContext())
            .setView(R.layout.dialog_correct)
            .show()
        alertDialog.setCancelable(false)


        alertDialog.findViewById<TextView>(R.id.tv_next).setOnClickListener {
            alertDialog.dismiss()

            setTest(currentQ)
        }
    }

    private fun showWrongDialog() {
        val alertDialog = AlertDialog.Builder(requireContext())
            .setView(R.layout.dialog_wrong)
            .show()
        alertDialog.setCancelable(false)

        alertDialog.findViewById<TextView>(R.id.tv_next).setOnClickListener {
            alertDialog.dismiss()
//            currentQ++
//            reset()
//            setQuestions(currentQ)
        }
    }

    private fun showCompleteDialog() {
        val alertDialog = AlertDialog.Builder(requireContext())
            .setView(R.layout.dialog_complete)
            .show()
        alertDialog.setCancelable(false)
        testsAgeSixList.shuffle()

        alertDialog.findViewById<TextView>(R.id.tv_next).setOnClickListener {

            currentQ = 0
            setTest(currentQ)
            alertDialog.dismiss()
        }
        alertDialog.findViewById<TextView>(R.id.tv_back).setOnClickListener {
            findNavController().navigateUp()
            alertDialog.dismiss()
        }

    }

    private fun fillTests(){

        testsAgeSixList.add(TestsAgeSix(images[0], listOf("12:20", "12:30", "01:00"), 1))
        testsAgeSixList.add(TestsAgeSix(images[1], listOf("04:00", "04:30", "03:00"), 0))
        testsAgeSixList.add(TestsAgeSix(images[2], listOf("07:20", "07:30", "08:00"), 1))
        testsAgeSixList.add(TestsAgeSix(images[3], listOf("09:00", "09:30", "09:06"), 2))
        testsAgeSixList.add(TestsAgeSix(images[4], listOf("11:00", "12:00", "11:10"), 0))
        testsAgeSixList.add(TestsAgeSix(images[5], listOf("07:48", "07:55", "08:00"), 0))
        testsAgeSixList.add(TestsAgeSix(images[6], listOf("03:20", "03:32", "03:50"), 1))
        testsAgeSixList.add(TestsAgeSix(images[7], listOf("04:56", "05:00", "04:45"), 0))
        testsAgeSixList.add(TestsAgeSix(images[8], listOf("03:20", "03:00", "03:10"), 2))
        testsAgeSixList.add(TestsAgeSix(images[9], listOf("05:50", "07:00", "06:00"), 2))

    }

}