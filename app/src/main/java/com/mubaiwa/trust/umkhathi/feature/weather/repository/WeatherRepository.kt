package com.mubaiwa.trust.umkhathi.feature.weather.repository


class WeatherRepository {

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