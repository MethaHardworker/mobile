package ru.fefu.myapplication.database

import android.app.Application

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        Dap.init(this)
    }
}