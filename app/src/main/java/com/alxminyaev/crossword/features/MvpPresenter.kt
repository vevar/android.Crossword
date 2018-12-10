package com.alxminyaev.crossword.features

open class MvpPresenter<View : MvpView> {

    protected var view: View? = null

    fun attachView(view: View) {
        this.view = view
        onViewReady()
    }

    fun detachView() {
        this.view = null
    }

    protected open fun onViewReady() {

    }
}