package com.example.mybooks

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mybooks.ui.theme.Purple40
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView

class MapActivity: ComponentActivity() {
    lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("3120d5c7-8c7b-496c-97a6-3f36a0651b1c")
        MapKitFactory.initialize(this)

        mapView = MapView(this)

        setContent{
            MapScreenContent()
        }
    }

    @Composable
    fun MapScreenContent() {
        Column(modifier = Modifier.fillMaxSize()) {
            LaunchedEffect(Unit) {
                mapView.map.move(
                    CameraPosition(Point(55.7558, 37.6173), 10f, 0f, 0f),
                    Animation(Animation.Type.SMOOTH, 300f), null
                )
            }
            androidx.compose.ui.viewinterop.AndroidView(
                factory = { mapView },
                modifier = Modifier
                    .height(500.dp)
                    .fillMaxWidth()
                    .padding(top = 40.dp, start = 8.dp, end = 8.dp,)
                    .border(5.dp, color = Color.DarkGray)
            )

            Button(
                onClick = {  val intent = Intent(this@MapActivity, PaymentActivity::class.java)
                    startActivity(intent) },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 16.dp)
            ) {
                Text(text = stringResource(id = R.string.deliver_here))
            }
        }
    }

        override fun onStop() {
            mapView.onStop()
            super.onStop()
        }

        override fun onStart() {
            mapView.onStart()
            super.onStart()
        }
}