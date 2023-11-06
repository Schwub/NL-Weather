package com.example.netlight_weather.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.netlight_weather.R

@Composable
fun WeatherLocationCardComposable() {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Box(modifier = Modifier.padding(8.dp)) {
            Column {
                Text("City Name", style = MaterialTheme.typography.headlineLarge)
                Spacer(modifier = Modifier.padding(4.dp))
                Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()){
                    Text(text = "0 °", style = MaterialTheme.typography.headlineMedium)
                    Image(
                        painter = painterResource(id = R.drawable.ic_cloudy),
                        contentDescription = "Test",
                        Modifier.width(100.dp)
                    )
                }
                Row (Modifier.height(20.dp)) {
                    Image(painter = painterResource(id = R.drawable.ic_cloudy), contentDescription = "Test")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Wind")
                }
                Spacer(modifier = Modifier.height(6.dp))
                Row (Modifier.height(20.dp)){
                    Image(painter = painterResource(id = R.drawable.ic_cloudy), contentDescription = "Test")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Rain")
                }
            }
        }
    }
}
@Preview
@Composable
fun PreviewWeatherLocationCardComposable() {
    WeatherLocationCardComposable()
}