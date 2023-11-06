package com.example.netlight_weather.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.netlight_weather.R

@Composable
fun WeatherLocationCardComposable(
    weatherDayOverviewInputs: List<WeatherDayOverviewInput>
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text("City Name", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.padding(4.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "0 °", style = MaterialTheme.typography.headlineMedium)
                Image(
                    painter = painterResource(id = R.drawable.ic_cloudy),
                    contentDescription = "Test",
                )
            }
            Row {
                Column {
                    Row(Modifier.height(20.dp)) {
                        Icon(
                            painter = painterResource(id = R.drawable.keyboard_double_arrow_up),
                            contentDescription = "Test"
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Max Temp.")
                    }
                    Spacer(modifier = Modifier.height(2.dp))
                    Row(Modifier.height(20.dp)) {
                        Icon(
                            painter = painterResource(id = R.drawable.keyboard_double_arrow_down),
                            contentDescription = "Test"
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Min Temp.")
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Row(Modifier.height(20.dp)) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_rain),
                            contentDescription = "Test"
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Wind")
                    }
                    Spacer(modifier = Modifier.height(2.dp))
                    Row(Modifier.height(20.dp)) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_wind),
                            contentDescription = "Test"
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Rain")
                    }
                }
            }
        }
        WeatherWeekOverviewComposable(weatherDayOverviewInputs = weatherDayOverviewInputs)
    }
}

    @Preview
    @Composable
    fun PreviewWeatherLocationCardComposable() {
        WeatherLocationCardComposable(previewData)
    }

    val previewData = listOf<WeatherDayOverviewInput>(
        WeatherDayOverviewInput("Monday", 10.0, 12.0, R.drawable.ic_cloudy),
        WeatherDayOverviewInput("Tuesday", 11.0, 13.0, R.drawable.ic_cloudy),
        WeatherDayOverviewInput("Wednesday", 12.0, 14.0, R.drawable.ic_cloudy),
        WeatherDayOverviewInput("Thursday", 13.0, 15.0, R.drawable.ic_cloudy),
        WeatherDayOverviewInput("Friday", 14.0, 16.0, R.drawable.ic_cloudy),
        WeatherDayOverviewInput("Saturday", 15.0, 17.0, R.drawable.ic_cloudy),
        WeatherDayOverviewInput("Sunday", 16.0, 18.0, R.drawable.ic_cloudy),
    )