package com.github.l_roro.bootcampsdp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GreetingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting)

        val name = intent.extras?.getString("Name")
        val greetingMessage: TextView = findViewById(R.id.greetingMessage)
        val msg = "Hi there $name"
        greetingMessage.text = msg
    }
}