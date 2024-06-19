package com.niki.coffeemachine

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val TAG = "Lifecycle"
val coffeeMachine = CoffeeMachine()
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val buttonView = findViewById<Button>(R.id.button)
        buttonView.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }
        Log.i(TAG, "MainActivity#onCreate")
    }
    override fun onStart() {
        super.onStart()
        Log.i(TAG, "MainActivity#onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "MainActivity#onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "MainActivity#onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "MainActivity#onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "MainActivity#onDestroy")
    }

}