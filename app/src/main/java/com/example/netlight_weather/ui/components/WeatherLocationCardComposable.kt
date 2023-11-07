package com.example.netlight_weather.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.netlight_weather.R
import com.example.netlight_weather.ui.data.WeatherLocationCardViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherLocationCardComposable(
    initialCityName: String,
) {
    val weatherLocationCardViewModel: WeatherLocationCardViewModel = viewModel()
    var cityName by remember { mutableStateOf(initialCityName) }
    weatherLocationCardViewModel.cityName = cityName
    val weatherLocationCardInput = weatherLocationCardViewModel.weatherData

    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            OutlinedTextField(
                value = cityName,
                label = {Text(text = "City")},
                onValueChange = { cityName = it },
                textStyle = MaterialTheme.typography.headlineMedium
            )
            if (weatherLocationCardInput == null) {
                Text(text = "No Data", style = MaterialTheme.typography.labelLarge)
            } else {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(
                        text = "${weatherLocationCardInput.currentTemperature} °",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Image(
                        painter = painterResource(id = weatherLocationCardInput.icon),
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
                            Text(text = "${weatherLocationCardInput.maxTemperature} °")
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Row(Modifier.height(20.dp)) {
                            Icon(
                                painter = painterResource(id = R.drawable.keyboard_double_arrow_down),
                                contentDescription = "Test"
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = "${weatherLocationCardInput.minTemperature} °")
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
                            Text(text = "${weatherLocationCardInput.rain} mm")
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Row(Modifier.height(20.dp)) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_wind),
                                contentDescription = "Test"
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = "${weatherLocationCardInput.wind} m/s")
                        }
                    }
                }
                WeatherWeekOverviewComposable(weatherDayOverviewInputs = weatherLocationCardInput.weatherDayOverviewInputs)
            }
        }
    }
}

data class WeatherLocationCardInput(
    @DrawableRes
    val icon: Int,
    val currentTemperature: Double,
    val maxTemperature: Double,
    val minTemperature: Double,
    val wind: Double,
    val rain: Double,
    val weatherDayOverviewInputs: List<WeatherDayOverviewInput>
)

@Preview
@Composable
fun PreviewWeatherLocationCardComposable() {
    WeatherLocationCardComposable(initialCityName = "Munich")
}