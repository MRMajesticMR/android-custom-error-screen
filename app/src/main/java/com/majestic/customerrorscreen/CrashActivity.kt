package com.majestic.customerrorscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class CrashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalExceptionHandler.getThrowableFromIntent(intent)?.let { error ->
            Log.e("CrashActivity", "GlobalExceptionHandler: ", error)
        }

        setContentView(R.layout.activity_crash)
    }
}