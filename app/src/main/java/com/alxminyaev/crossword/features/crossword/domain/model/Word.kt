package com.alxminyaev.crossword.features.crossword.domain.model

data class Word(
    val number: Int,
    val orientation: Int,
    val start_x: Int,
    val start_y: Int,
    val question: String,
    val answer: String
){
    companion object {
        const val HORIZONTAL = 0
        const val VERTICAL = 1
    }
}