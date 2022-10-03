package com.majestic.customerrorscreen

import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        GlobalExceptionHandler.initialize(this, CrashActivity::class.java)
    }
}