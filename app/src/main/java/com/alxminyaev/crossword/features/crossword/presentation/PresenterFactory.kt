package com.alxminyaev.crossword.features.crossword.presentation

import android.content.Context
import com.alxminyaev.crossword.App
import com.alxminyaev.crossword.features.crossword.data.CrossWordDataSource
import com.alxminyaev.crossword.features.crossword.data.CrossWordDataSourceImpl
import com.alxminyaev.crossword.features.crossword.data.CrossWordRepository
import com.alxminyaev.crossword.features.crossword.data.CrossWordRepositoryImpl
import com.alxminyaev.crossword.features.crossword.domain.CrossWordInteractor
import com.alxminyaev.crossword.features.crossword.domain.CrossWordInteractorImpl

class PresenterFactory {

    companion object {
        fun createPresenter(context: Context): CrossWordPresenter {

            val dataSource: CrossWordDataSource = CrossWordDataSourceImpl(context)
            val repository: CrossWordRepository = CrossWordRepositoryImpl(dataSource)
            val interactor: CrossWordInteractor = CrossWordInteractorImpl(repository)

            return CrossWordPresenter(interactor)
        }
    }
}