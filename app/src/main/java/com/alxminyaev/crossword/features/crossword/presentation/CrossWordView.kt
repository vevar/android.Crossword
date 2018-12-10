package com.alxminyaev.crossword.features.crossword.presentation

import com.alxminyaev.crossword.features.crossword.domain.model.CrossWord
import com.alxminyaev.crossword.features.MvpView

interface CrossWordView : MvpView {
    fun createAndShowCrossWord(crossWord: CrossWord)

}