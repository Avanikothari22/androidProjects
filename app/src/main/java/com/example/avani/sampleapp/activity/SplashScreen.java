package com.example.avani.sampleapp.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.avani.sampleapp.ApiCall;
import com.example.avani.sampleapp.listener.DataListener;
import com.example.avani.sampleapp.R;
import com.example.avani.sampleapp.pojo.Coffee;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SplashScreen extends AppCompatActivity implements DataListener {

    private int SPLASH_TIME_OUT = 5000;
    String myUrl = "https://api.github.com/users";
    ArrayList<Coffee> myStaticCoffees;
    String result;
    ApiCall getRequest = new ApiCall();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getRequest.setDataListener(this);
        getRequest.execute(myUrl);

        setContentView(R.layout.activity_splash_screen);
        //makeCoffees();
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

    @Override
    public void onDataReceieved(String s) {
               Log.d("myTag====", s);
        try {
            myStaticCoffees = new ArrayList<>();
            JSONArray jsonArray = new JSONArray(s);
            for(int i = 0; i<= jsonArray.length(); i++){
                JSONObject  currentJSONObject = jsonArray.getJSONObject(i);
                int id = currentJSONObject.getInt("id");
                String name = currentJSONObject.getString("login");
                String desc = currentJSONObject.getString("node_id");
                Coffee coffee = new Coffee(id, name, 250,desc);
                myStaticCoffees.add(coffee);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // do ui stuff here with datas
    }
}
