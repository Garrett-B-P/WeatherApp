package com.example.weatherapp;

import android.app.Activity;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.io.IOException;

public class GetTemp implements Runnable {

    private String string;
    private Activity activity;


    public GetTemp(String string, Activity activity) {
        this.string = string;
        this.activity = activity;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void run() {
        System.out.println("Getting temp for " + string);
        tempGetter getT = new tempGetter(string, activity);
        try {
            getT.singleCityForecast();
        } catch (IOException e) {
            e.printStackTrace();
        }
        float city_temp = getT.returnTemp();

        activity.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                // This is the code that will run on the UI thread.
                Toast toast = Toast.makeText(activity, "The temperature for " + string + " is " + city_temp, Toast.LENGTH_SHORT);
                toast.show();
            }
        });


    }
}
