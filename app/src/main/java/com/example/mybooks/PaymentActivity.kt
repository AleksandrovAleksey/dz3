package com.example.mybooks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.mybooks.ui.theme.MyBooksTheme
import com.example.mybooks.ui.theme.screens.PayScreen

class PaymentActivity:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyBooksTheme {
                PayScreen()
            }
        }
    }
}