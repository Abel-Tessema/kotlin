package com.belajash.justjava

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.main_activity)
    }

    private var numberOfCoffee = 1

    fun submitOrder(view: View) {
        displayQuantity(numberOfCoffee)
        displayPrice(numberOfCoffee * 5)
    }

    private fun displayQuantity(number: Int) {
        val quantityTextView = findViewById<TextView>(R.id.quantityTextView)
        quantityTextView.text = "" + number
    }

    private fun displayPrice(number: Int) {
        val priceTextView = findViewById<TextView>(R.id.priceTextView)
        priceTextView.text = NumberFormat.getCurrencyInstance().format(number)
    }

    fun increaseQuantity(view: View) {
        numberOfCoffee++
        displayQuantity(numberOfCoffee)
    }

    fun decreaseQuantity(view: View) {
        if (numberOfCoffee == 0) return
        numberOfCoffee--
        displayQuantity(numberOfCoffee)
    }
}