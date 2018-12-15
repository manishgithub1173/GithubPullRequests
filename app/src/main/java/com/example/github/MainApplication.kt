package com.example.github

import android.app.Application

class MainApplication : Application() {

    companion object {
        var instance: MainApplication? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}