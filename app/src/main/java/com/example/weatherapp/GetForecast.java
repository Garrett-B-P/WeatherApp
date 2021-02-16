package com.example.weatherapp;

import android.app.Activity;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.io.IOException;

public class GetForecast implements Runnable {

    private String string;
    private Activity activity;


    public GetForecast(String string, Activity activity) {
        this.string = string;
        this.activity = activity;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void run() {
        System.out.println("Getting forecast for " + string);
        forecastGetter getF = new forecastGetter(string, activity);
        try {
            getF.singleCityForecast();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String cityTime = getF.returnTime();
        float cityTemp = getF.returnTemp();
        String cityCon = getF.returnCon();
        float cityWS = getF.returnWS();

        activity.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                // This is the code that will run on the UI thread.
                Toast toast = Toast.makeText(activity, "The forecast for " + string + " is:\nTime: " + cityTime + "\nTemp: " + cityTemp + "\nConditions: " + cityCon
                        + "\nWind Speed: " + cityWS, Toast.LENGTH_LONG);
                toast.show();
            }
        });


    }
}
