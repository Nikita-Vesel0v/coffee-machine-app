package com.niki.coffeemachine

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RemainingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remaining)
        val statusView = findViewById<TextView>(R.id.status3)
        val getStatusButton = findViewById<Button>(R.id.getStatus)
        getStatusButton.setOnClickListener {
            coffeeMachine.status(statusView)
        }
        val backButton = findViewById<Button>(R.id.back)
        backButton.setOnClickListener {
            intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }
    }
}