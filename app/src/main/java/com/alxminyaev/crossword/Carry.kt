package com.alxminyaev.crossword

interface Carry<T> {
    fun onSuccess(result: T)
    fun onFailure(throwable: Throwable)
}