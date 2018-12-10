package com.alxminyaev.crossword.features.crossword.data

import com.alxminyaev.crossword.Carry
import com.alxminyaev.crossword.features.crossword.domain.model.CrossWord

class CrossWordRepositoryImpl(private val dataSource: CrossWordDataSource) : CrossWordRepository {
    override fun loadCrossWord(carry: Carry<CrossWord>) {
        dataSource.loadCrossWord(carry)
    }
}