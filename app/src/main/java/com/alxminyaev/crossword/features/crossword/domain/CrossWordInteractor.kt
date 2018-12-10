package com.alxminyaev.crossword.features.crossword.domain

import com.alxminyaev.crossword.Carry
import com.alxminyaev.crossword.features.crossword.domain.model.CrossWord

interface CrossWordInteractor {
    fun loadCrossWord(carry: Carry<CrossWord>)
}
