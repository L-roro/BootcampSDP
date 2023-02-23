package com.github.l_roro.bootcampsdp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun mainButtonClick(view: View) {
        val intent = Intent(this, GreetingActivity::class.java)
        val textBox = findViewById<TextView>(R.id.mainTextBox)
        val bundle: Bundle = Bundle()
        bundle.putString("Name", textBox.text.toString())
        intent.putExtras(bundle)
        startActivity(intent)
    }
}