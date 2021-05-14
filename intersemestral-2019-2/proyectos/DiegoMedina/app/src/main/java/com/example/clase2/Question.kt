package com.example.clase2

import java.io.Serializable

data class Question(val type: String, val question: String, val answer1: String, val answer2: String, val answer3: String, val validAnswer: Int) : Serializable