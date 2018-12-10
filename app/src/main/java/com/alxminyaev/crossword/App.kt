package com.alxminyaev.crossword

import android.app.Application
import android.content.Context

class App : Application() {
    companion object {
        fun getApp(context: Context): App {
            return context.applicationContext as App
        }
    }


}