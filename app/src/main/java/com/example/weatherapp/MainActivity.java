package com.example.weatherapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tempClick(View view) {
        EditText city = (EditText) findViewById(R.id.city);
        String cityName = city.getText().toString();

        new Thread(new GetTemp(cityName, this)).start();
    }

    public void forecastClick(View view) {
        EditText city = (EditText) findViewById(R.id.city);
        String cityName = city.getText().toString();

        new Thread(new GetForecast(cityName, this)).start();
    }

}
