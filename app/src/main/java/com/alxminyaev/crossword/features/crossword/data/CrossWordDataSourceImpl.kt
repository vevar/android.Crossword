package com.alxminyaev.crossword.features.crossword.data

import android.content.Context
import com.alxminyaev.crossword.Carry
import com.alxminyaev.crossword.R
import com.alxminyaev.crossword.features.crossword.domain.model.CrossWord
import com.alxminyaev.crossword.service.XmlCrossWordParser

class CrossWordDataSourceImpl(val context: Context) : CrossWordDataSource {

    override fun loadCrossWord(carry: Carry<CrossWord>) {
        val parser = XmlCrossWordParser()
        val inputStream = context.applicationContext.resources.openRawResource(R.raw.crossword_exemple_1)
        try {
            val crossWord = parser.getCrossWord(inputStream)
            carry.onSuccess(crossWord)
        } catch (throwable: Throwable) {
            carry.onFailure(throwable)
        }
    }

}
