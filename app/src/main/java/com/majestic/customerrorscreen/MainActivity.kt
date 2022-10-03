package com.majestic.customerrorscreen

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var bCrash: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bCrash = findViewById(R.id.bCrash)

        bCrash.setOnClickListener {
            throw Exception("Some test error")
        }
    }
}