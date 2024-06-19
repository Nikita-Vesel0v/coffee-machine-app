package com.niki.coffeemachine

import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class CoffeeMachine : AppCompatActivity() {
    private lateinit var buyActivity: BuyActivity
    private var availableMoney = 2000
    private var availableWater = 2000
    private var availableMilk = 2000
    private var availableBeans = 2000
    private var availableCups = 10

    private var moneyPerCup = 0
    private var waterPerCup = 0
    private var milkPerCup = 0
    private var beansPerCup = 0

    fun setEspresso() {
        moneyPerCup = 4; waterPerCup = 250; milkPerCup = 0; beansPerCup = 16
    }
    fun setLatte() {
        moneyPerCup = 7; waterPerCup = 350; milkPerCup = 75; beansPerCup = 20
    }
    fun setCappuccino(){
        moneyPerCup = 6; waterPerCup = 200; milkPerCup = 100; beansPerCup = 12
    }

    private fun availableResources(): Boolean {
        val result = when {
            availableCups < 1 ->
                "Sorry, not enough cups!"
            availableWater - waterPerCup < 0 ->
                "Sorry, not enough water!"
            availableMilk - milkPerCup < 0 ->
                "Sorry, not enough milk!"
            availableBeans - beansPerCup < 0 ->
                "Sorry, not enough coffee beans!"
            else ->
                "I have enough resources, making you a coffee!"
        }
        Log.i(TAG, "Resource#beforeToast")
        Toast.makeText(buyActivity, result, Toast.LENGTH_SHORT).show()
        return (result == "I have enough resources, making you a coffee!")
    }

    fun buy(activity: BuyActivity) {
        Log.i(TAG, "Buy#start")

        buyActivity = activity
        if (availableResources()) {
            availableMoney += moneyPerCup
            availableBeans -= beansPerCup
            availableWater -= waterPerCup
            availableMilk -= milkPerCup
            availableCups--
        }
        Log.i(TAG, "Buy#finish")

    }

    fun fill(water: EditText, milk: EditText, beans: EditText, cups: EditText) {
        Log.i(TAG, "Fill#start")
//        println("\nWrite how many ml of water you want to add:")
        Log.i(TAG, "Fill#afterParse")
        availableWater += try {
            water.getText().toString().toInt()
        } catch (e: NumberFormatException) {
            // handle the exception
            0
        }
        Log.i(TAG, "Fill#afterWater")
//        println("Write how many ml of milk you want to add:")
        availableMilk += try {
            milk.getText().toString().toInt()
        } catch (e: NumberFormatException) {
            // handle the exception
            0
        }
//        println("Write how many grams of coffee beans you want to add:")
        availableBeans += try {
            beans.getText().toString().toInt()
        } catch (e: NumberFormatException) {
            // handle the exception
            0
        }
//        println("Write how many disposable cups you want to add:\n")
        availableCups += try {
            water.getText().toString().toInt()
        } catch (e: NumberFormatException) {
            // handle the exception
            0
        }

        Log.i(TAG, "Fill#finish")
    }

    fun take() {
        availableMoney = 0
    }

    fun status(textView: TextView) {
        Log.i(TAG, "Status#start")
        val result = "The coffee machine has:\n     $availableWater ml of water\n     $availableMilk ml of milk\n       $availableBeans g of coffee beans\n     $availableCups disposable cups\n    $availableMoney of money"

        result.also { textView.text = it }
        Log.i(TAG, "Status#finish")
    }
}