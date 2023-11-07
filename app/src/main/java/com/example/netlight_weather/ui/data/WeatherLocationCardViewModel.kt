package com.example.netlight_weather.ui.data

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.netlight_weather.R
import com.example.netlight_weather.ui.components.WeatherDayOverviewInput
import com.example.netlight_weather.ui.components.WeatherLocationCardInput

class WeatherLocationCardViewModel: ViewModel() {

    var weatherData: WeatherLocationCardInput? by mutableStateOf(null)
    var cityName: String? = null
        set(value) {
            field = value
            weatherData = value?.let { getWeatherDataForLocation(it) }
        }

    private fun getWeatherDataForLocation(cityName: String): WeatherLocationCardInput? {
        when (cityName) {
            "Munich" -> {
                return WeatherLocationCardInput(
                    icon = R.drawable.ic_heavysnow,
                    currentTemperature = 20.0,
                    maxTemperature = 23.0,
                    minTemperature = 10.0,
                    wind = 3.5,
                    rain = 1.8,
                    weatherDayOverviewInputs = listOf<WeatherDayOverviewInput>(
                        WeatherDayOverviewInput("Monday", 10.0, 12.0, R.drawable.ic_cloudy),
                        WeatherDayOverviewInput("Tuesday", 11.0, 13.0, R.drawable.ic_snowy),
                        WeatherDayOverviewInput("Wednesday", 12.0, 14.0, R.drawable.ic_rainshower),
                        WeatherDayOverviewInput("Thursday", 13.0, 15.0, R.drawable.ic_thunder),
                        WeatherDayOverviewInput("Friday", 14.0, 16.0, R.drawable.ic_heavysnow),
                        WeatherDayOverviewInput("Saturday", 15.0, 17.0, R.drawable.ic_verycloudy),
                        WeatherDayOverviewInput("Sunday", 16.0, 18.0, R.drawable.ic_rainshower),
                    )
                )
            }
            "Stockholm" -> {
                return WeatherLocationCardInput(
                    icon = R.drawable.ic_heavysnow,
                    currentTemperature = 20.0,
                    maxTemperature = 23.0,
                    minTemperature = 10.0,
                    wind = 3.5,
                    rain = 1.8,
                    weatherDayOverviewInputs = listOf<WeatherDayOverviewInput>(
                        WeatherDayOverviewInput("Monday", 10.0, 12.0, R.drawable.ic_sunny),
                        WeatherDayOverviewInput("Tuesday", 11.0, 13.0, R.drawable.ic_sunny),
                        WeatherDayOverviewInput("Wednesday", 12.0, 14.0, R.drawable.ic_sunny),
                        WeatherDayOverviewInput("Thursday", 13.0, 15.0, R.drawable.ic_sunny),
                        WeatherDayOverviewInput("Friday", 14.0, 16.0, R.drawable.ic_sunny),
                        WeatherDayOverviewInput("Saturday", 15.0, 17.0, R.drawable.ic_verycloudy),
                        WeatherDayOverviewInput("Sunday", 16.0, 18.0, R.drawable.ic_rainshower),
                    )
                )
            }
            else -> {
                return null
            }
        }

    }
}

data class WeatherLocationState(
    val error:String?,
    val weatherLocationCardInput: WeatherLocationCardInput,
    val isLoading: Boolean
)