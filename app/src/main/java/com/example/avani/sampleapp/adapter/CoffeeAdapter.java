package com.example.avani.sampleapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.avani.sampleapp.R;
import com.example.avani.sampleapp.activity.CoffeeView;
import com.example.avani.sampleapp.pojo.Coffee;

import java.util.ArrayList;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder> {

    private ArrayList<Coffee> myCoffees;

    private Context mContext;

    public CoffeeAdapter(ArrayList myCoffees, Context mContext) {
        this.mContext = mContext;
        this.myCoffees = myCoffees;
    }

    @NonNull
    @Override
    public CoffeeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =  LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.coffee_item, viewGroup, false);
        return new CoffeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeViewHolder coffeeViewHolder, int i) {
        Coffee cofeeItem = myCoffees.get(i);
        coffeeViewHolder.cofeePrice.setText(cofeeItem.getPrice()+"");
        coffeeViewHolder.coffeeName.setText(cofeeItem.getName());
    }

    @Override
    public int getItemCount() {
        return myCoffees.size();
    }

    public class CoffeeViewHolder extends RecyclerView.ViewHolder {

        private TextView coffeeName, cofeePrice;
        private LinearLayout item;

        public CoffeeViewHolder(@NonNull View itemView) {
            super(itemView);
            coffeeName = itemView.findViewById(R.id.coffee_name);
            cofeePrice = itemView.findViewById(R.id.coffee_price);
            item = itemView.findViewById(R.id.coffeeItemView);

            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, CoffeeView.class);
                    intent.putExtra("Coffee", myCoffees.get(getAdapterPosition()));
                    mContext.startActivity(intent);
                }
            });
        }

    }
}
