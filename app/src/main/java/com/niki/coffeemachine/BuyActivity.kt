package com.niki.coffeemachine

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BuyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy)
        val statusView = findViewById<TextView>(R.id.status)
        coffeeMachine.status(statusView)
        val espresso = findViewById<Button>(R.id.espresso)
        espresso.setOnClickListener {
            coffeeMachine.setEspresso()
            coffeeMachine.buy(this)
            coffeeMachine.status(statusView)
        }
        val latte = findViewById<Button>(R.id.latte)
        latte.setOnClickListener {
            coffeeMachine.setLatte()
            coffeeMachine.buy(this)
            coffeeMachine.status(statusView)
        }
        val cappuccino = findViewById<Button>(R.id.cappuccino)
        cappuccino.setOnClickListener {
            coffeeMachine.setCappuccino()
            coffeeMachine.buy(this)
            coffeeMachine.status(statusView)
        }


        val backButton = findViewById<Button>(R.id.back)
        backButton.setOnClickListener {
            intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }
        val takeButton = findViewById<Button>(R.id.take)
        takeButton.setOnClickListener {
            intent = Intent(this, TakeActivity::class.java)
            startActivity(intent)
        }
        val fillButton = findViewById<Button>(R.id.fill)
        fillButton.setOnClickListener {
            intent = Intent(this, FillActivity::class.java)
            startActivity(intent)
        }

    }
}