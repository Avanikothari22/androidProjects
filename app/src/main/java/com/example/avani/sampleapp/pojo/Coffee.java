package com.example.avani.sampleapp.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Coffee implements Parcelable {
    private int id;
    private String name;
    private double price;
    private String description;

    public Coffee(int id) {
        this.id = id;
    }

    public Coffee(int id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Coffee) {
            return ((Coffee)obj).id == this.id;
        }
        return false;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeDouble(this.price);
        dest.writeString(this.description);
    }

    protected Coffee(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.price = in.readDouble();
        this.description = in.readString();
    }

    public static final Parcelable.Creator<Coffee> CREATOR = new Parcelable.Creator<Coffee>() {
        @Override
        public Coffee createFromParcel(Parcel source) {
            return new Coffee(source);
        }

        @Override
        public Coffee[] newArray(int size) {
            return new Coffee[size];
        }
    };
}
