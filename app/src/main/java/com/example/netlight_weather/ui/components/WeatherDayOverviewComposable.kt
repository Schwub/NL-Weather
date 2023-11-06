package com.example.netlight_weather.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.netlight_weather.R


@Composable
fun WeatherDayOverviewComposable(
    day: String,
    minTemperature: Double,
    maxTemperature: Double,
    @DrawableRes icon: Int,
) {
    Column (
        modifier = Modifier
            .padding(4.dp)
            .width(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = day, style = MaterialTheme.typography.labelLarge)
        Spacer(modifier = Modifier.height(4.dp))
        Image(
            painter = painterResource(id = icon),
            contentDescription = "Weather Icon",
            Modifier.height(40.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "$maxTemperature °", style = MaterialTheme.typography.labelMedium)
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = "$minTemperature °", style = MaterialTheme.typography.labelMedium)
    }
}

@Composable
fun WeatherDayOverviewComposable(
    weatherDayOverviewInput: WeatherDayOverviewInput
) {
    WeatherDayOverviewComposable(
        day = weatherDayOverviewInput.day,
        minTemperature = weatherDayOverviewInput.minTemperature,
        maxTemperature = weatherDayOverviewInput.maxTemperature,
        icon = weatherDayOverviewInput.icon
    )
}

@Preview
@Composable
fun PreviewWeatherDayOverviewComposable() {
    WeatherDayOverviewComposable(
        WeatherDayOverviewInput(
            day = "Monday",
            icon = R.drawable.ic_cloudy,
            maxTemperature = 15.0,
            minTemperature = 2.0
        )
    )
}

data class WeatherDayOverviewInput (
    val day: String,
    val minTemperature: Double,
    val maxTemperature: Double,
    @DrawableRes
    val icon: Int
)

