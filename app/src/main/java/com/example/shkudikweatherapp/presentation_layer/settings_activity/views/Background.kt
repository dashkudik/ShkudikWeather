package com.example.shkudikweatherapp.presentation_layer.settings_activity.views

import androidx.core.content.ContextCompat
import com.example.shkudikweatherapp.R
import com.example.shkudikweatherapp.data_layer.enums.MainDescription
import com.example.shkudikweatherapp.data_layer.providers.WeatherProvider.desc
import com.example.shkudikweatherapp.data_layer.providers.WeatherProvider.mainDesc
import com.example.shkudikweatherapp.presentation_layer.common_protocols.Background
import com.example.shkudikweatherapp.presentation_layer.settings_activity.activity.SettingsActivity
import com.example.shkudikweatherapp.data_layer.enums.MainDescription.*
import kotlinx.android.synthetic.main.activity_settings.*

class BackgroundImpl(private val activity: SettingsActivity) : Background {

    override fun setBackground(description: MainDescription) { with(activity) {

        settingsBackground.setImageDrawable(

            when (mainDesc) {

                CLEAR -> ContextCompat.getDrawable(activity, R.drawable.clear)

                CLEAR_NIGHT -> ContextCompat.getDrawable(activity, R.drawable.clear_night)

                CLOUDS -> {

                    val isOvercast = desc.contains(getString(R.string.overcast_rus)) ||
                                     desc.contains(getString(R.string.overcast_eng)) ||
                                     desc.contains(getString(R.string.overcast_ger))

                    ContextCompat.getDrawable(activity,
                        if (isOvercast) R.drawable.cloud else R.drawable.low_cloud)
                }

                CLOUDS_NIGHT -> {

                    val isOvercast = desc.contains(getString(R.string.overcast_rus)) ||
                                     desc.contains(getString(R.string.overcast_eng)) ||
                                     desc.contains(getString(R.string.overcast_ger))

                    ContextCompat.getDrawable(activity,
                        if (isOvercast) R.drawable.cloud_night else R.drawable.low_cloud_night)

                }

                RAIN, DRIZZLE -> ContextCompat.getDrawable(activity, R.drawable.rain)

                RAIN_NIGHT, DRIZZLE_NIGHT -> ContextCompat.getDrawable(activity, R.drawable.rain_night)

                HAZE, MIST, DUST, FOG, SMOKE -> ContextCompat.getDrawable(activity, R.drawable.humid)

                HAZE_NIGHT, MIST_NIGHT, DUST_NIGHT, FOG_NIGHT, SMOKE_NIGHT ->
                    ContextCompat.getDrawable(activity, R.drawable.humid_night)

                SNOW -> {

                    val isLow = desc.contains(getString(R.string.low_rus)) ||
                                desc.contains(getString(R.string.low_eng)) ||
                                desc.contains(getString(R.string.low_ger))

                    ContextCompat.getDrawable(activity, if (isLow) R.drawable.low_snow else R.drawable.snow)

                }

                SNOW_NIGHT -> ContextCompat.getDrawable(activity, R.drawable.snow_night)

                TORNADO, TORNADO_NIGHT -> ContextCompat.getDrawable(activity, R.drawable.tornado)

                THUNDERSTORM, THUNDERSTORM_NIGHT -> ContextCompat.getDrawable(activity, R.drawable.thunder)

                else -> ContextCompat.getDrawable(activity, R.drawable.humid_night)

            })
        }
    }
}