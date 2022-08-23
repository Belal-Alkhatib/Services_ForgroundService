package com.example.and2_nluc3_forfroundservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.and2_nluc3_forfroundservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            val i = Intent(this,MyService::class.java)
            ContextCompat.startForegroundService(this,i)
        }

        binding.btnStop.setOnClickListener {
            val i = Intent(this,MyService::class.java)
            stopService(i)
        }
    }
}