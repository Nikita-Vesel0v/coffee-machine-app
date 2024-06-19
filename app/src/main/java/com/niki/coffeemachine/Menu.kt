package com.niki.coffeemachine

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        var intent: Intent
        val buyButtonView = findViewById<Button>(R.id.buy)
        buyButtonView.setOnClickListener {
            intent = Intent(this, BuyActivity::class.java)
            startActivity(intent)
        }
        val fillButtonView = findViewById<Button>(R.id.fill)
        fillButtonView.setOnClickListener {
            intent = Intent(this, FillActivity::class.java)
            startActivity(intent)
        }
        val takeButtonView = findViewById<Button>(R.id.take)
        takeButtonView.setOnClickListener {
            intent = Intent(this, TakeActivity::class.java)
            startActivity(intent)
        }
        val remainingButtonView = findViewById<Button>(R.id.remaining)
        remainingButtonView.setOnClickListener {
            intent = Intent(this, RemainingActivity::class.java)
            startActivity(intent)
        }
        val exitButtonView = findViewById<Button>(R.id.exit)
        exitButtonView.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        Log.i(TAG, "MenuActivity#onCreate")
    }
}