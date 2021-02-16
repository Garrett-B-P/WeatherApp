package com.example.weatherapp;

import android.app.Activity;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;

/**
 * This class does the main part of the assignment (not the stretch challenge).
 */
public class tempGetter {

    private String string;
    private Activity activity;
    Float TEMP;

    public tempGetter(String string, Activity activity) {
        this.string = string;
        this.activity = activity;
    }


    /**
     * Gets and displays the current conditions and forecast for a given city.
     * @return
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

        for (WeatherForecastItem item : forecast.getForecastItems()) {
            String time = item.getDateText();
            float temp = item.getMeasurements().get("temp");
            TEMP = temp;
            String conditions = "";
            if (item.getDescriptions().size() > 0) {
                conditions = item.getDescriptions().get(0).getDescription();
            }

            float wind = item.getWind().get("speed");

            System.out.println(String.format("The temp is: %sF", temp));
            break;

        }

    }
    public Float returnTemp() {
        System.out.println(TEMP);
        return TEMP;
    }

}
