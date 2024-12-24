package com.example.mybooks.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mybooks.R

@Composable
fun PayScreen() {
    var selectedPaymentMethod by remember { mutableStateOf("onlineCard") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top=32.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
            .background(Color.White)
    ) {
        Text(
            text = stringResource(id = R.string.pay_method),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        PaymentMethodOption(
            method = stringResource(id = R.string.card_online),
            isSelected = selectedPaymentMethod == "onlineCard"
        ) {
            selectedPaymentMethod = "onlineCard"
        }

        PaymentMethodOption(
            method = stringResource(id = R.string.offline),
            isSelected = selectedPaymentMethod == "uponReceiving"
        ) {
            selectedPaymentMethod = "uponReceiving"
        }

        PaymentMethodOption(
            method = stringResource(id = R.string.link_SFP),
            isSelected = selectedPaymentMethod == "sbp"
        ) {
            selectedPaymentMethod = "sbp"
        }

        Spacer(modifier = Modifier.weight(1f))

        OrderSummary()

        Button(
            onClick = {}, modifier = Modifier
                .padding(bottom = 16.dp)
        ) {
            Text(text = stringResource(id = R.string.make_order), color = Color.White)
        }
    }
}

@Composable
fun PaymentMethodOption(method: String, isSelected: Boolean, onClick: () -> Unit) {
    val backgroundColor = if (isSelected) Color.Yellow else Color.Transparent

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick)
            .background(backgroundColor)
            .border(1.dp, Color.Gray)
            .padding(16.dp)
    ) {
        Text(text = method)
    }
}

@Composable
fun OrderSummary() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 16.dp)) {
        Text(text = stringResource(id = R.string.one_product))
        Text(text = stringResource(id = R.string.price))
        Text(text = stringResource(id = R.string.sale))
        Text(text = stringResource(id = R.string.decrease_cost))
        Text(text = stringResource(id = R.string.delivery))
        Text(text = stringResource(id = R.string.delivery_cost))

        Divider(modifier = Modifier.padding(vertical = 8.dp))

        Text(text = stringResource(id = R.string.summary))
        Text(text = stringResource(id = R.string.finish_price))
    }
}
