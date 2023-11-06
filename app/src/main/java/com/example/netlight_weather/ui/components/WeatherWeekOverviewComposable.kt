package com.example.netlight_weather.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


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