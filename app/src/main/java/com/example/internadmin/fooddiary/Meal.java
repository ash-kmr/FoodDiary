package com.example.internadmin.fooddiary;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class Meal {

    private DishID MyDishID;
    private Date TimeConsumed;
    private float ServingAmt;
    private File FoodImg;
    private long RowID;
    private DBHandler mydbhandler;

    public Meal(String FoodName, int ver, Date TimeConsumed, float ServingAmt, Bitmap FoodImg, Context ctx){

        MyDishID = new DishID(FoodName, ver, ctx);
        this.TimeConsumed = TimeConsumed;
        this.ServingAmt = ServingAmt;

        try{
            this.FoodImg = File.createTempFile("tempfoodimg", "jpg", ctx.getCacheDir());
            this.FoodImg.deleteOnExit();
            FileOutputStream outStream = new FileOutputStream(this.FoodImg);
            FoodImg.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
            outStream.close();
        } catch (IOException e){
            Log.e("Meal Caching", "Cannot create Cached Image: " + e.getMessage());
        }


    }

    public boolean saveToDatabase(Context ctx){

        mydbhandler = new DBHandler(ctx);
        Bitmap mybitmap = BitmapFactory.decodeFile(FoodImg.getAbsolutePath());

        return mydbhandler.insertMealEntry(MyDishID.getFoodName(), TimeConsumed, ServingAmt, mybitmap);
    }

    public void populateFromDatabase(long MealID, Context ctx){
        mydbhandler = new DBHandler(ctx);

        Bundle b = mydbhandler.getMeal(MealID);
        MyDishID = new DishID(b.getString("FoodName"), -1, ctx);
        this.TimeConsumed = (Date) b.getSerializable("TimeConsumed");
        this.FoodImg = (File) b.getSerializable("FoodImg");
        this.ServingAmt = b.getFloat("ServingAmt");
        this.RowID = MealID;

    }

    public boolean updateInDatabase(Context ctx){
        Bitmap mybitmap = BitmapFactory.decodeFile(FoodImg.getAbsolutePath());

        return mydbhandler.updateHistoryEntry(MyDishID.getFoodName(), TimeConsumed, ServingAmt, mybitmap, RowID);
    }

    public Date getTimeConsumed(){
        return TimeConsumed;
    }

    public Bitmap getFoodImg(){
        if (FoodImg == null){
            return MyDishID.getFoodImg();
        }else{
            return BitmapFactory.decodeFile(FoodImg.getAbsolutePath());
        }
    }

    public float getServingAmt(){
        return ServingAmt;
    }

    public DishID getDishID(){
        return MyDishID;
    }


}
