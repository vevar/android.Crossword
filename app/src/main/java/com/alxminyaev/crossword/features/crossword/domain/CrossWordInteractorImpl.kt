package com.alxminyaev.crossword.features.crossword.domain

import com.alxminyaev.crossword.Carry
import com.alxminyaev.crossword.features.crossword.data.CrossWordRepository
import com.alxminyaev.crossword.features.crossword.domain.model.CrossWord

class CrossWordInteractorImpl(private val repository: CrossWordRepository) : CrossWordInteractor {
    override fun loadCrossWord(carry: Carry<CrossWord>) {
        repository.loadCrossWord(carry)
    }

}
