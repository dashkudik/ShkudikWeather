package com.example.shkudikweatherapp.presentation_layer.main_activity.views

import androidx.core.content.ContextCompat
import com.example.shkudikweatherapp.R
import com.example.shkudikweatherapp.data_layer.enums.MainDescription
import com.example.shkudikweatherapp.presentation_layer.main_activity.activity.MainActivity
import com.example.shkudikweatherapp.data_layer.providers.WeatherProvider.isSelectedCityExists
import com.example.shkudikweatherapp.data_layer.providers.WeatherProvider.mainDesc
import com.example.shkudikweatherapp.presentation_layer.common_protocols.TimeMode
import kotlinx.android.synthetic.main.activity_main.*

class TimeModeImpl(val activity: MainActivity) : TimeMode {

    override fun setDayMode() { with(activity) {

            if (isSelectedCityExists)
                iconMoreInfoImpl.show(true)

            btn_apply_city.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.apply_city))

            btn_geo.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.location))

            btn_change_city.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.replace))

            btn_settings.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.settings))

            input_city.background = ContextCompat.getDrawable(activity, R.drawable.back_city_input)

            ContextCompat.getColor(activity, R.color.black).also {

                tvDescriptionIcon.setTextColor(it)
                input_city.setTextColor(it)
                tvTemp.setTextColor(it)
                tvHumidity.setTextColor(it)
                tvWind.setTextColor(it)
                text_humidity.setTextColor(it)
                text_wind.setTextColor(it)
                text_temp.setTextColor(it)

            }

        }
    }

    override fun setNightMode() { with(activity) {

            if (isSelectedCityExists)
                iconMoreInfoImpl.show(false)

            btn_change_city.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.replace_night))

            btn_geo.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.location_night))

            btn_settings.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.settings_night))

            btn_apply_city.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.apply_city_night))

            tvDescriptionIcon.setTextColor(ContextCompat.getColor(activity, R.color.bright_white))

            tempIcon.background = ContextCompat.getDrawable(activity, R.drawable.back_icons_night)

            windIcon.background = ContextCompat.getDrawable(activity, R.drawable.back_icons_night)

            humidityIcon.background = ContextCompat.getDrawable(activity, R.drawable.back_icons_night)

            input_city.background = ContextCompat.getDrawable(activity, R.drawable.back_city_input_night)

            ContextCompat.getColor(activity, R.color.white).also {

                input_city.setTextColor(it)
                tvTemp.setTextColor(it)
                tvHumidity.setTextColor(it)
                tvWind.setTextColor(it)
                text_humidity.setTextColor(it)
                text_wind.setTextColor(it)
                text_temp.setTextColor(it)

            }

        }

    }

    override fun setTimeMode(isNight: Boolean) =

        if (isNight || mainDesc == MainDescription.THUNDERSTORM) setNightMode() else setDayMode()


}