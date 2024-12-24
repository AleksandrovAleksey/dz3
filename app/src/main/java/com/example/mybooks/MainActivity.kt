package com.example.mybooks

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mybooks.ui.theme.MyBooksTheme

class MainActivity : ComponentActivity() {
    val addresses = listOf(
        "Москва, улица Пушкина, д.57А, кв.303",
        "Пушкино, улица 40 лет Победы, д.3, кв.15",
        "Москва, улица Измайловский проспект, д.55, кв.51",
        "Ижевск, улица М.Т.Калашникова, д.66, кв.7",
        "Мытищи, улица Академика Кургина, д.6, кв.17"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyBooksTheme {
                MainScreen()
            }
        }
    }

    @Composable
    fun MainScreen() {
        val addresses = listOf(
            "Москва, улица Пушкина, д.57А, кв.303",
            "Пушкино, улица 40 лет Победы, д.3, кв.15",
            "Москва, улица Измайловский проспект, д.55, кв.51",
            "Ижевск, улица М.Т.Калашникова, д.66, кв.7",
            "Мытищи, улица Академика Кургина, д.6, кв.17"
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(
                text = stringResource(id = R.string.delivery_method),
                color = Color.Black
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = true,
                    onClick = {}
                )
                Text(
                    text = stringResource(id = R.string.courier),
                    color = Color.Black
                )


                RadioButton(
                    selected = false,
                    onClick = {}
                )
                Text(
                    text = stringResource(id = R.string.self),
                    color = Color.Black
                )
            }

            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .padding(16.dp)
            )
            Text(
                text = stringResource(id = R.string.choose_adress),
                color = Color.Black,
            )

            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(addresses) { address ->
                        AddressItem(address)
                    }
                }

                Button(
                    onClick = {
                        val intent = Intent(this@MainActivity, MapActivity::class.java)
                        startActivity(intent)
                    }, modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(16.dp)
                        .height(56.dp)
                ) {
                    Text(text = stringResource(id = R.string.add_adress))
                }
            }

            Spacer(
                modifier = Modifier
                    .height(56.dp)
                    .padding(16.dp)
            )
            Button(
                onClick = {val intent = Intent(this@MainActivity, PaymentActivity::class.java)
                    startActivity(intent)}, modifier = Modifier
                    .padding(bottom = 16.dp)
            )
            {
                Text(text = stringResource(id = R.string.next))
            }
        }
    }

    @Composable
    fun AddressItem(address: String) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable {
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = false,
                onClick = {}
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = address,
                color = Color.Black,
            )
        }
    }
}

