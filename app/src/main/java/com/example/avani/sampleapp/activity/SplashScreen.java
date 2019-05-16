package com.example.avani.sampleapp.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.avani.sampleapp.ApiCall;
import com.example.avani.sampleapp.R;
import com.example.avani.sampleapp.pojo.Coffee;

import java.util.ArrayList;

public class SplashScreen extends AppCompatActivity {

    private int SPLASH_TIME_OUT = 5000;
    String myUrl = "https://api.github.com/users/Avanikothari22";
    ArrayList<Coffee> myStaticCoffees;
    String result;
    AsyncTask getRequest = new ApiCall();
    getRequest.execute()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        makeCoffees();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, Coffees.class);
                i.putParcelableArrayListExtra("coffee", myStaticCoffees);
                startActivity(i);
            }
        }, SPLASH_TIME_OUT);
    }

    private void makeCoffees() {
        myStaticCoffees = new ArrayList<>();
        myStaticCoffees.add(new Coffee(1, "Latte", 250.0, "Latte Coffee very nice."));
        myStaticCoffees.add(new Coffee(2, "Nescafe", 10, "Indian Coffee"));
        myStaticCoffees.add(new Coffee(3, "Bru", 50.0, "American Coffee"));
        myStaticCoffees.add(new Coffee(4, "Jacobs", 2000, "British Coffee"));
        myStaticCoffees.add(new Coffee(5, "Folgers", 400, "Fulgar Coffee"));
    }
}
