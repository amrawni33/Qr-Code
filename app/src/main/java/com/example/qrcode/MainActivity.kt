package com.example.qrcode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var scanning1=findViewById<Button>(R.id.scanning)
        var generating1=findViewById<Button>(R.id.generating)
        var i=Intent(this,scanning::class.java)
        var j=Intent(this,generating::class.java)

        scanning1.setOnClickListener { startActivity(i) }
        generating1.setOnClickListener { startActivity(j) }

    }
}