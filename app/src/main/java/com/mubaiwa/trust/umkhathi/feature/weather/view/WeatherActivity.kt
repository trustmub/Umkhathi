package com.mubaiwa.trust.umkhathi.feature.weather.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mubaiwa.trust.umkhathi.databinding.ActivityWeatherBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WeatherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}