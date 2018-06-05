package com.example.internadmin.fooddiary;

public class Prediction {
    private String FoodName;
    private int ver;

    Prediction(String FoodName, int ver){
        this.FoodName = FoodName;
        this.ver = ver;
    }

    public String getFoodName(){
        return FoodName;
    }

    public int getVer(){
        return ver;
    }
}
