package com.niki.coffeemachine

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FillActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fill)
        val waterText = findViewById<EditText>(R.id.water)
        val milkText = findViewById<EditText>(R.id.milk)
        val beansText = findViewById<EditText>(R.id.beans)
        val cupsText = findViewById<EditText>(R.id.cups)
        val addButton = findViewById<Button>(R.id.add)
        addButton.setOnClickListener {
            coffeeMachine.fill(waterText, milkText, beansText, cupsText)
            Toast.makeText(this, "All added", Toast.LENGTH_SHORT).show()
        }



    }
}