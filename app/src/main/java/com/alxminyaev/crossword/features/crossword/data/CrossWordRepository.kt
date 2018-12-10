package com.alxminyaev.crossword.features.crossword.data

import com.alxminyaev.crossword.Carry
import com.alxminyaev.crossword.features.crossword.domain.model.CrossWord

interface CrossWordRepository {
    fun loadCrossWord(carry: Carry<CrossWord>)
}
