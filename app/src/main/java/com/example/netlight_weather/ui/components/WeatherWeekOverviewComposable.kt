package com.example.netlight_weather.ui.components

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.netlight_weather.R


@Composable
fun WeatherWeekOverviewComposable(weatherDayOverviewInputs: List<WeatherDayOverviewInput>) {
    LazyRow{
        items(weatherDayOverviewInputs) { item ->
            WeatherDayOverviewComposable(weatherDayOverviewInput = item)
        }
    }
}

@Preview
@Composable
fun PreviewWeatherWeekOverviewComposable() {
    WeatherWeekOverviewComposable(weatherDayOverviewInputs = previewData)
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

