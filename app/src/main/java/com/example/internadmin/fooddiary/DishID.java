package com.example.internadmin.fooddiary;

import com.google.gson.annotations.SerializedName;

public class DishID {

    @SerializedName("Name")
    private String Name;

    @SerializedName("Version")
    private int ver;

    public DishID(){

    }

    public String getName(){
        return Name;
    }

    public int getVer(){
        return ver;
    }

    public void setVer(int ver){
        this.ver = ver;
    }
}
