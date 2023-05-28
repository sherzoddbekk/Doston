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
import com.example.doston.databinding.FragmentHomeBinding
import com.example.doston.model.Answer
import com.example.doston.model.QuestionOne
import com.example.doston.model.QuestionTwo
import com.example.doston.model.TestsAgeFive
import viewBinding
import kotlin.random.Random

class FiveAgoFragment : Fragment(R.layout.fragment_five_ago) {

    private val binding by viewBinding { FragmentFiveAgoBinding.bind(it) }

    private var testsAgeFiveList: MutableList<TestsAgeFive> = arrayListOf()
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
        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }
    }


    private fun initView() {
        setQuestions(currentQ)
        val testsAgeFive = testsAgeFiveList[currentQ]
        binding.apply {

            tvAnswer1.setOnClickListener {

                Log.d("RRR", "CAN : ${testsAgeFive.answer.correctAnswer}")
                if (testsAgeFiveList[currentQ].answer.correctAnswer == 0) {
                    if (currentQ < testsAgeFiveList.size - 1) {
                        showCorrectDialog()
                        currentQ++
                    } else if (currentQ == testsAgeFiveList.size - 1) showCompleteDialog()
                } else showWrongDialog()
            }

            tvAnswer2.setOnClickListener {
                Log.d("RRR", "CAN : ${testsAgeFiveList[currentQ].answer.correctAnswer}")
                if (testsAgeFiveList[currentQ].answer.correctAnswer == 1) {
                    if (currentQ < testsAgeFiveList.size - 1) {
                        showCorrectDialog()
                        currentQ++
                    } else if (currentQ == testsAgeFiveList.size - 1) showCompleteDialog()
                } else showWrongDialog()
            }

            tvAnswer3.setOnClickListener {
                Log.d("RRR", "CAN : ${testsAgeFiveList[currentQ].answer.correctAnswer}")
                if (testsAgeFiveList[currentQ].answer.correctAnswer == 2) {
                    if (currentQ < testsAgeFiveList.size - 1) {
                        showCorrectDialog()
                        currentQ++
                    } else if (currentQ == testsAgeFiveList.size - 1) showCompleteDialog()
                } else showWrongDialog()
            }

        }
    }

    private fun setQuestions(index: Int) {
        val testsAgeFive = testsAgeFiveList[index]
        Log.d("RRR", "TEST : $testsAgeFive")
        binding.apply {

            for (i in 0 until testsAgeFive.questionOne.count) {
                (glFruits1.getChildAt(i) as ImageView).apply {
                    setImageResource(testsAgeFive.questionOne.image)
                    visibility = View.VISIBLE
                }
            }

            for (i in 0 until testsAgeFive.questionTwo.count) {
                (glFruits2.getChildAt(i) as ImageView).apply {
                    setImageResource(testsAgeFive.questionTwo.image)
                    visibility = View.VISIBLE
                }
            }

            tvAnswer1.text = testsAgeFive.answer.answers[0].toString()
            tvAnswer2.text = testsAgeFive.answer.answers[1].toString()
            tvAnswer3.text = testsAgeFive.answer.answers[2].toString()
        }
    }

    private fun reset() {
        binding.apply {
            for (i in 0 until glFruits1.childCount) {
                glFruits1.getChildAt(i).visibility = View.INVISIBLE
            }
            for (i in 0 until glFruits2.childCount) {
                glFruits2.getChildAt(i).visibility = View.INVISIBLE
            }

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
        testsAgeFiveList.shuffle()

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

    private fun fillQuestions() {
        for (i in 0..9) {
            val count1 = Random.nextInt(2, 8)
            val count2 = Random.nextInt(2, 8)
            val correctAnswer = Random.nextInt(0, 3)
            val answers = mutableListOf<Int>()
            repeat(3) {
                var randomNumber = Random.nextInt(-4, 8)

                while (randomNumber == 0) {
                    randomNumber = Random.nextInt(-4, 8)
                }

                answers.add(count1 + count2 + randomNumber)
            }
            answers[correctAnswer] = count1 + count2
            val testsAgeFive = TestsAgeFive(
                QuestionOne(count1, images[Random.nextInt(0, 8)]),
                QuestionTwo(count2, images[Random.nextInt(0, 8)]),
                Answer(
                    answers, correctAnswer
                ),
                '+'
            )
            testsAgeFive.answer.answers
            testsAgeFiveList.add(testsAgeFive)

        }


    }

}