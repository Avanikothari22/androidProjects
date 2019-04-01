package com.example.avani.sampleapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.avani.sampleapp.R;
import com.example.avani.sampleapp.adapter.CoffeeAdapter;
import com.example.avani.sampleapp.pojo.Coffee;

import java.util.ArrayList;

public class Coffees extends AppCompatActivity {

    RecyclerView coffessListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coffee);
        Intent intent = getIntent();
        ArrayList<Coffee> myCoffees = intent.getParcelableArrayListExtra("coffee");
        coffessListView = findViewById(R.id.coffee_recyler);

        setUpRecyclerView(myCoffees);
    }

    private void setUpRecyclerView(ArrayList<Coffee> myCoffees) {

        CoffeeAdapter coffeeAdapter = new CoffeeAdapter(myCoffees, this);

        coffessListView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        coffessListView.setLayoutManager(layoutManager);

        coffessListView.setAdapter(coffeeAdapter);
    }
}
