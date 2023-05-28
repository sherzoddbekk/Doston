package com.example.doston.model

data class TestsAgeFour(var questionOnes: QuestionOnes, var answers: Answers)

data class QuestionOnes(var count: Int, var image: Int)


data class Answers(var answers: List<Int>, var correctAnswer: Int)