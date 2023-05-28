package com.example.doston.model

data class TestsAgeFive(var questionOne: QuestionOne, var questionTwo: QuestionTwo, var answer: Answer, var query: Char)

data class QuestionOne(var count: Int, var image: Int)

data class QuestionTwo(var count: Int, var image: Int)

data class Answer(var answers: List<Int>, var correctAnswer: Int)