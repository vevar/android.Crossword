package com.alxminyaev.crossword.features.crossword.domain.model

class CrossWord {

    private var maxWidth = 0
    private var maxHeight = 0

    private val listWords: MutableList<Word> = mutableListOf()

    fun getMaxWidth(): Int = maxWidth
    fun getMaxHeight(): Int = maxHeight

    fun addWord(parsWord: Word) {
        listWords.add(parsWord)
        if (parsWord.orientation == Word.HORIZONTAL && parsWord.answer.length + parsWord.start_x > maxWidth) {
            maxWidth = parsWord.answer.length + parsWord.start_x
        } else if (parsWord.orientation == Word.VERTICAL && parsWord.answer.length +parsWord.start_y> maxHeight) {
            maxHeight = parsWord.answer.length + parsWord.start_y
        }
    }


    fun getListWords(): List<Word> {
        return listWords
    }
}