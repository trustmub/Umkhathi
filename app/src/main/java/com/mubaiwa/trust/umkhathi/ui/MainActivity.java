package com.mubaiwa.trust.umkhathi.ui;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.mubaiwa.trust.umkhathi.R;
import com.mubaiwa.trust.umkhathi.Weather.Day;
import com.mubaiwa.trust.umkhathi.Weather.Forecast;
import com.mubaiwa.trust.umkhathi.feature.weather.models.HourModel;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {


    public static final String TAG = MainActivity.class.getSimpleName();
    public static final String DAILY_FORECAST = "DAILY_FORECAST";

    private Forecast mForecast;


//    @Bind(R.id.timeLabel)
//    TextView mTimeLabel;
//    @Bind(R.id.temperatureLabel)
//    TextView mTemperatureLabel;
//    @Bind(R.id.humidityValue)
//    TextView mHumidityValue;
//    @Bind(R.id.precipValue)
//    TextView mPrecipValue;
//    @Bind(R.id.summarytLabel)
//    TextView mSummaryLabel;
//    @Bind(R.id.iconImageView)
//    ImageView mIconImageView;
//    @Bind(R.id.refreshImageView)
//    ImageView mRefreshImageView;
//    @Bind(R.id.progressBar)
    ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        mProgressBar.setVisibility(View.INVISIBLE);

        final double latitude = -17.8333;
        final double longitude = 31.0500;
        //final 20.1700, 28.5800
        // Bulawayo -17.8333,31.0500

//        mRefreshImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getForecast(latitude, longitude);
//            }
//        });

//        getForecast(latitude, longitude);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Running Weather Update ...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
//                getForecast(latitude, longitude);
            }
        });
    }

//    private void getForecast(double latitude, double longitude) {
//        String apkKey = "3872aff4b3988622b10adb56abbbbeeb";
//        String forecustUrl = "https://api.forecast.io/forecast/" + apkKey + "/" + latitude + "," + longitude;
//
//        if (isNetworkAvailable()) {
//
//            taggleRefresh();
//
//            OkHttpClient client = new OkHttpClient();
//            Request request = new Request.Builder()
//                    .url(forecustUrl)
//                    .build();
//            Call call = client.newCall(request);
//            call.enqueue(new Callback() {
//                @Override
//                public void onFailure(Request request, IOException e) {
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            taggleRefresh();
//                        }
//                    });
//
//                    alertUserAboutError();
//                }
//
//                @Override
//                public void onResponse(Response response) throws IOException {
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            taggleRefresh();
//                        }
//                    });
//                    try {
//                        String jsonData = response.body().string();
//
//                        Log.v(TAG, jsonData);
//                        if (response.isSuccessful()) {
//                            mForecast = parseForecastDetails(jsonData);
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    updateDisplay();
//                                }
//                            });
//
//
//                        } else {
//                            alertUserAboutError();
//                        }
//                    } catch (IOException | JSONException e) {
//                        Log.e(TAG, "Exception Caught", e);
//                    }
//
//                }
//            });
//        } else {
//            Toast.makeText(this, "Network is Not-Available", Toast.LENGTH_LONG).show();
//        }
//    }

//    private void taggleRefresh() {
//        if (mProgressBar.getVisibility() == View.INVISIBLE) {
//            mProgressBar.setVisibility(View.VISIBLE);
//            mRefreshImageView.setVisibility(View.INVISIBLE);
//        } else {
//            mProgressBar.setVisibility(View.INVISIBLE);
//            mRefreshImageView.setVisibility(View.VISIBLE);
//        }
//
//    }


//    private void updateDisplay() {
//        Current current = mForecast.getCurrent();
//
//        mTemperatureLabel.setText(current.getTemperature() + "");
//        mTimeLabel.setText("At " + current.getFormattedTime() + " it will be");
//        mHumidityValue.setText(current.getHumidity() + "");
//        mPrecipValue.setText(current.getPrecipitation() + "%");
//        mSummaryLabel.setText(current.getSummary());
//
//        Drawable drawable = getResources().getDrawable(current.getIconId());
//        mIconImageView.setImageDrawable(drawable);
//
//
//    }

    private Forecast parseForecastDetails(String jsonData) throws JSONException {
        Forecast forecast = new Forecast();

        forecast.setCurrent(getCurrentDetails(jsonData));
//        forecast.setHourlForecast(getHourlyForecast(jsonData));
        forecast.setDailyForecast(getDailyForecast(jsonData));

        return forecast;

    }

    private Day[] getDailyForecast(String jsonData) throws JSONException {
        JSONObject forecast = new JSONObject(jsonData);
        String timezone = forecast.getString("timezone");
        JSONObject daily = forecast.getJSONObject("daily");
        JSONArray data = daily.getJSONArray("data");

        Day[] days = new Day[data.length()];

        for (int i = 0; i < data.length(); i++) {
            JSONObject jsonDay = data.getJSONObject(i);
            Day day = new Day();

            day.setSummary(jsonDay.getString("summary"));
            day.setIcon(jsonDay.getString("icon"));
            day.setTemperatureMax(jsonDay.getDouble("temperatureMax"));
            day.setTime(jsonDay.getLong("time"));
            day.setTimezone(timezone);

            days[i] = day;
        }

        return days;

    }

    private HourModel[] getHourlyForecast(String jsonData) throws JSONException {
        JSONObject forecast = new JSONObject(jsonData);
        String timezone = forecast.getString("timezone");
        JSONObject hourly = forecast.getJSONObject("hourly");
        JSONArray data = hourly.getJSONArray("data");
        //Log.i(TAG, "From JSON: " + hourly);

        HourModel[] hours = new HourModel[data.length()];

        for (int i = 0; i < data.length(); i++) {
            JSONObject jsonHour = data.getJSONObject(i);
            HourModel hour = new HourModel();

            hour.setSummary(jsonHour.getString("summary"));
            hour.setTemperature(jsonHour.getDouble("temperature"));
            hour.setIcon(jsonHour.getString("icon"));
            hour.setTime(jsonHour.getLong("time"));
            hour.setTimezone(timezone);

            hours[i] = hour;
        }

        return hours;
    }

    private Current getCurrentDetails(String jsonData) throws JSONException {
        JSONObject forecast = new JSONObject(jsonData);
        String timezone = forecast.getString("timezone");
        Log.i(TAG, "From JSON: " + timezone);

        JSONObject currently = forecast.getJSONObject("currently");

        Current current = new Current();
        current.setHumidity(currently.getDouble("humidity"));
        current.setTime(currently.getLong("time"));
        current.setIcon(currently.getString("icon"));
        current.setPrecipitation(currently.getDouble("precipProbability"));
        current.setSummary(currently.getString("summary"));
        current.setTemperature(currently.getDouble("temperature"));
        current.setTimeZone(timezone);

        //Log.d(TAG, current.getFormattedTime());

        return current;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfor = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfor != null && networkInfor.isConnected()) {
            isAvailable = true;
        }

        return isAvailable;
    }

    private void alertUserAboutError() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(), "error response");
    }

}
