package com.niki.coffeemachine

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TakeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take)
        val takeButton = findViewById<Button>(R.id.take_money)
        val statusView: TextView = findViewById(R.id.status2)
        Log.i(TAG, "TakeActivity#start")
        coffeeMachine.status(statusView)
        Log.i(TAG, "TakeActivity#status 1")
        takeButton.setOnClickListener {
            coffeeMachine.take()
            Toast.makeText(this, "You took all the money", Toast.LENGTH_SHORT).show()
            coffeeMachine.status(statusView)
        }
        val backButton = findViewById<Button>(R.id.back)
        backButton.setOnClickListener {
            intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }


    }
}