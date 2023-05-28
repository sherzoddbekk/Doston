package com.example.doston.ui.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.doston.R
import com.example.doston.databinding.FragmentFiveAgoBinding
import com.example.doston.databinding.FragmentFourAgoBinding
import com.example.doston.model.*
import viewBinding
import kotlin.random.Random

class FourAgoFragment:Fragment(R.layout.fragment_four_ago) {
    private val binding by viewBinding { FragmentFourAgoBinding.bind(it) }
    private var testsAgeFourList: MutableList<TestsAgeFour> = arrayListOf()
    private var images = listOf<Int>(
        R.drawable.im_fruit_1,
        R.drawable.im_fruit_2,
        R.drawable.im_fruit_3,
        R.drawable.im_fruit_4,
        R.drawable.im_fruit_5,
        R.drawable.im_fruit_6,
        R.drawable.im_fruit_7,
        R.drawable.im_fruit_8,
        R.drawable.im_fruit_9
    )
    private var currentQ = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        reset()
        fillQuestions()
        initView()
    }


    private fun fillQuestions() {
        for (i in 0..9) {
            val count = Random.nextInt(2, 8)
            val correctAnswer = Random.nextInt(0, 3)
            val answers = mutableListOf<Int>()
            repeat(3) {
                var randomNumber = Random.nextInt(-2, 8)

                while (randomNumber == 0) {
                    randomNumber = Random.nextInt(-2, 8)
                }

                answers.add(count + randomNumber)
            }
            answers[correctAnswer] = count
            val testsAgeFour = TestsAgeFour(
                QuestionOnes(count, images[Random.nextInt(0, 8)]),
                Answers(
                    answers, correctAnswer
                ),

            )
            testsAgeFour.answers.answers
            testsAgeFourList.add(testsAgeFour)

        }


    }

    private fun reset() {
        binding.apply {
            for (i in 0 until glFruits1.childCount) {
                glFruits1.getChildAt(i).visibility = View.INVISIBLE
            }
        }
    }


    private fun initView() {
        setQuestions(currentQ)
        val testsAgeFour = testsAgeFourList[currentQ]
        binding.apply {

            tvAnswer1.setOnClickListener {

                Log.d("RRR", "CAN : ${testsAgeFour.answers.correctAnswer}")
                if (testsAgeFourList[currentQ].answers.correctAnswer == 0) {
                    if (currentQ < testsAgeFourList.size - 1) {
                        showCorrectDialog()
                        currentQ++
                    } else if (currentQ == testsAgeFourList.size - 1) showCompleteDialog()
                } else showWrongDialog()
            }

            tvAnswer2.setOnClickListener {
                Log.d("RRR", "CAN : ${testsAgeFourList[currentQ].answers.correctAnswer}")
                if (testsAgeFourList[currentQ].answers.correctAnswer == 1) {
                    if (currentQ < testsAgeFourList.size - 1) {
                        showCorrectDialog()
                        currentQ++
                    } else if (currentQ == testsAgeFourList.size - 1) showCompleteDialog()
                } else showWrongDialog()
            }

            tvAnswer3.setOnClickListener {
                Log.d("RRR", "CAN : ${testsAgeFourList[currentQ].answers.correctAnswer}")
                if (testsAgeFourList[currentQ].answers.correctAnswer == 2) {
                    if (currentQ < testsAgeFourList.size - 1) {
                        showCorrectDialog()
                        currentQ++
                    } else if (currentQ == testsAgeFourList.size - 1) showCompleteDialog()
                } else showWrongDialog()
            }

        }
    }

    private fun setQuestions(index: Int) {
        val testsAgeFour = testsAgeFourList[index]
        Log.d("RRR", "TEST : $testsAgeFour")
        binding.apply {

            for (i in 0 until testsAgeFour.questionOnes.count) {
                (glFruits1.getChildAt(i) as ImageView).apply {
                    setImageResource(testsAgeFour.questionOnes .image)
                    visibility = View.VISIBLE
                }
            }

            tvAnswer1.text = testsAgeFour.answers.answers[0].toString()
            tvAnswer2.text = testsAgeFour.answers.answers[1].toString()
            tvAnswer3.text = testsAgeFour.answers.answers[2].toString()
        }
    }

    private fun showCorrectDialog() {
        val alertDialog = AlertDialog.Builder(requireContext())
            .setView(R.layout.dialog_correct)
            .show()
        alertDialog.setCancelable(false)


        alertDialog.findViewById<TextView>(R.id.tv_next).setOnClickListener {
            alertDialog.dismiss()

            reset()
            setQuestions(currentQ)
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
        testsAgeFourList.shuffle()

        alertDialog.findViewById<TextView>(R.id.tv_next).setOnClickListener {
            reset()
            currentQ = 0
            setQuestions(currentQ)
            alertDialog.dismiss()
        }
        alertDialog.findViewById<TextView>(R.id.tv_back).setOnClickListener {
            findNavController().navigateUp()
            alertDialog.dismiss()
        }

    }

}