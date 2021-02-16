package com.example.weatherapp;

import android.app.Activity;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;

/**
 * This class does the main part of the assignment (not the stretch challenge).
 */
public class forecastGetter {

    private String string;
    private Activity activity;
    String TIME;
    float TEMP;
    String CON;
    float WS;

    public forecastGetter(String string, Activity activity) {
        this.string = string;
        this.activity = activity;
    }


    /**
     * Gets and displays the current conditions and forecast for a given city.
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void singleCityForecast() throws IOException {
        WeatherDataLoader loader = new WeatherDataLoader();

        String city = string;

        WeatherConditions conditions = loader.getWeather(city);

        System.out.println("Weather for " + city);
        System.out.println();
        WeatherForecast forecast = loader.getForecast(city);
        printForecast(forecast);


    }

    public void printForecast(WeatherForecast forecast) {
        System.out.println("Forecast information:");

        for (WeatherForecastItem item : forecast.getForecastItems()) {
            String time = item.getDateText();
            float temp = item.getMeasurements().get("temp");
            TEMP = temp;
            String conditions = "";
            if (item.getDescriptions().size() > 0) {
                conditions = item.getDescriptions().get(0).getDescription();
            }
            CON = conditions;
            float wind = item.getWind().get("speed");
            WS = wind;
            TIME = time;
            System.out.println(String.format("Time: %s, Temp: %sF, Conditions: %s, Wind Speed: %smph",
                    time, temp, conditions, wind));
            break;
        }
    }

    public String returnTime() {
        return TIME;
    }
    public float returnTemp() {
        return TEMP;
    }
    public String returnCon() {
        return CON;
    }
    public float returnWS() {
        return WS;
    }
}


