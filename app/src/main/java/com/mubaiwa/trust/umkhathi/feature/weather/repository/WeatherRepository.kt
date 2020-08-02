package com.mubaiwa.trust.umkhathi.feature.weather.repository

import com.mubaiwa.trust.umkhathi.feature.weather.models.WeatherResponseEntity
import com.mubaiwa.trust.umkhathi.feature.weather.util.CurrentMapper
import com.mubaiwa.trust.umkhathi.feature.weather.util.DataState
import com.mubaiwa.trust.umkhathi.feature.weather.util.DayMapper
import com.mubaiwa.trust.umkhathi.feature.weather.util.HourMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception


class WeatherRepository constructor(
        val service: IWeather,
        val currentMapper: CurrentMapper,
        val dailyMapper: DayMapper,
        val hourlyMapper: HourMapper) : IWeather {

    override fun fetchWeather(): WeatherResponseEntity? {
        return try {
            service.fetchWeather()
        } catch (e: Exception) {
            throw e
        }
    }

    fun getWeather(): Flow<DataState<WeatherResponseEntity>> = flow {
        emit(DataState.Loading)
        try {
            val result = fetchWeather()
            if (result != null) {
                currentMapper.setTimeZone(result.timezone)
                val currentWeather = currentMapper.mapFromEntity(result.currently)
                val dailyWeather = dailyMapper.mapEntityList(result)
                val hourlyWeather = hourlyMapper.mapEntityList(result)
            }
        } catch (e: Exception) {
            emit(DataState.NetworkError(e))
        }
    }

//    private const val TAG = MainActivity::class.java.simpleName
//
//    private fun getForecast(latitude: Double, longitude: Double) {
//        val apkKey = "3872aff4b3988622b10adb56abbbbeeb"
//        val forecustUrl = "https://api.forecast.io/forecast/$apkKey/$latitude,$longitude"
//        if (isNetworkAvailable()) {
//            taggleRefresh()
//            val client = OkHttpClient()
//            val request: Request = Builder()
//                    .url(forecustUrl)
//                    .build()
//            val call: Call = client.newCall(request)
//            call.enqueue(object : Callback() {
//                fun onFailure(request: Request?, e: IOException?) {
//                    runOnUiThread(Runnable { taggleRefresh() })
//                    alertUserAboutError()
//                }
//
//                @Throws(IOException::class)
//                fun onResponse(response: Response) {
//                    runOnUiThread(Runnable { taggleRefresh() })
//                    try {
//                        val jsonData: String = response.body().string()
//                        Log.v(TAG, jsonData)
//                        if (response.isSuccessful()) {
//                            mForecast = parseForecastDetails(jsonData)
//                            runOnUiThread(Runnable { updateDisplay() })
//                        } else {
//                            alertUserAboutError()
//                        }
//                    } catch (e: IOException) {
//                        Log.e(TAG, "Exception Caught", e)
//                    } catch (e: JSONException) {
//                        Log.e(TAG, "Exception Caught", e)
//                    }
//                }
//            })
//        } else {
//            Toast.makeText(this, "Network is Not-Available", Toast.LENGTH_LONG).show()
//        }
//    }
}