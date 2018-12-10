package com.alxminyaev.crossword.features

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<T : MvpView> : AppCompatActivity() {

    private lateinit var presenter: MvpPresenter<T>

    abstract fun getPresenter(): MvpPresenter<T>

    abstract fun getMvpView(): T


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = getPresenter()
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(getMvpView())
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}