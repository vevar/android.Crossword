package com.alxminyaev.crossword.features.crossword.presentation

import android.util.Log
import com.alxminyaev.crossword.Carry
import com.alxminyaev.crossword.features.crossword.domain.CrossWordInteractor
import com.alxminyaev.crossword.features.crossword.domain.model.CrossWord
import com.alxminyaev.crossword.features.MvpPresenter

class CrossWordPresenter(private val crossWordInteractor: CrossWordInteractor) : MvpPresenter<CrossWordView>() {

    override fun onViewReady() {
        super.onViewReady()
        loadCrossWord()
    }

    private fun loadCrossWord() {
        crossWordInteractor.loadCrossWord(object : Carry<CrossWord> {
            override fun onSuccess(result: CrossWord) {
                view?.createAndShowCrossWord(result)
            }

            override fun onFailure(throwable: Throwable) {
                Log.e("ERORR", throwable.message, throwable)
            }

        })
    }
}
