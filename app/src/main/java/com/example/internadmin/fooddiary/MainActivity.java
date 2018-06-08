package com.example.internadmin.fooddiary;

import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    /*
    CardView barcard;
    BarChart chart;
    NonScrollListView breakfastlist;
    NonScrollListView lunchlist;
    NonScrollListView dinnerlist;*/
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // main scrollview for MainActivity
        setContentView(R.layout.activity_main);
        Summary summary = new Summary();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragment2, summary).commit();
    }/*
    public CardView createChart(int[][] vals){
        // get system width
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        barcard = new CardView(MainActivity.this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        int margin = 8;
        params.setMargins(margin, margin, margin, margin);
        barcard.setLayoutParams(params);
        barcard.setRadius(9);
        // uncomment below line for padding
        //barcard.setContentPadding(50, 50, 50, 50);
        barcard.setCardBackgroundColor(Color.parseColor("#FFC6D6C3"));
        barcard.setMaxCardElevation(15);
        barcard.setCardElevation(9);
        chart = new BarChart(MainActivity.this);
        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        ArrayList<BarEntry> yVals = new ArrayList<BarEntry>();
        for(int i = 0; i < 7; i++){
            yVals.add(new BarEntry(vals[0][i], vals[1][i]));
        }
        BarDataSet set1 = new BarDataSet(yVals, "label");
        set1.setColor(R.color.grey);
        dataSets.add(set1);
        BarData data = new BarData(dataSets);
        chart.setData(data);
        chart.setMinimumHeight(500);
        chart.animateY(1000);
        // changing settings to remove everything in chart except bars
        chart.getXAxis().setEnabled(false);
        chart.getAxisRight().setDrawGridLines(false);
        chart.getAxisLeft().setDrawGridLines(false);
        chart.getLegend().setEnabled(false);
        Description description = new Description();
        description.setText("");
        chart.setDescription(description);
        YAxis leftAxis = chart.getAxisLeft();
        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setEnabled(false);
        leftAxis.setEnabled(false);
        chart.setDrawBorders(false);
        chart.setTouchEnabled(false);
        chart.setMinimumWidth(size.x);
        barcard.addView(chart);
        return barcard;
    }

    public CardView createBreakfast(){
        // creating card for breakfast
        CardView breakfastcard = new CardView(MainActivity.this);
        LinearLayout breakfastlayout = new LinearLayout(MainActivity.this);
        breakfastlayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        int margin = 8;
        params.setMargins(margin, margin, margin, margin);
        breakfastcard.setLayoutParams(params);
        breakfastcard.setRadius(9);
        breakfastcard.setCardBackgroundColor(Color.parseColor("#FFC6D6C3"));
        breakfastcard.setMaxCardElevation(15);
        breakfastcard.setCardElevation(9);
        breakfastcard.addView(breakfastlayout);
        // creating heading for breakfastcard
        TextView breakfasthead = new TextView(MainActivity.this);
        breakfasthead.setText("Breakfast");
        breakfastlayout.addView(breakfasthead);
        breakfastlist = new NonScrollListView(MainActivity.this);
        ArrayList<FoodItem> foodlist = new ArrayList<>();
        foodlist.add(new FoodItem("thosai", "yummy"));
        foodlist.add(new FoodItem("thosai", "yummy"));
        foodlist.add(new FoodItem("aloo paratha", "not so good"));
        FoodItemAdapter adapter = new FoodItemAdapter(MainActivity.this, R.layout.food_item, foodlist);
        breakfastlist.setAdapter(adapter);
        //setListViewHeightBasedOnChildren(breakfastlist);
        breakfastlayout.addView(breakfastlist);
        return breakfastcard;
    }
    public CardView createLunch(){
        // creating card for breakfast
        CardView lunchcard = new CardView(MainActivity.this);
        LinearLayout lunchlayout = new LinearLayout(MainActivity.this);
        lunchlayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        int margin = 8;
        params.setMargins(margin, margin, margin, margin);
        lunchcard.setLayoutParams(params);
        lunchcard.setRadius(9);
        lunchcard.setCardBackgroundColor(Color.parseColor("#FFC6D6C3"));
        lunchcard.setMaxCardElevation(15);
        lunchcard.setCardElevation(9);
        lunchcard.addView(lunchlayout);
        // creating heading for breakfastcard
        TextView breakfasthead = new TextView(MainActivity.this);
        breakfasthead.setText("Lunch");
        lunchlayout.addView(breakfasthead);
        lunchlist = new NonScrollListView(MainActivity.this);
        ArrayList<FoodItem> foodlist = new ArrayList<>();
        foodlist.add(new FoodItem("thosai", "yummy"));
        foodlist.add(new FoodItem("thosai", "yummy"));
        foodlist.add(new FoodItem("aloo paratha", "not so good"));
        FoodItemAdapter adapter = new FoodItemAdapter(MainActivity.this, R.layout.food_item, foodlist);
        lunchlist.setAdapter(adapter);
        //setListViewHeightBasedOnChildren(breakfastlist);
        lunchlayout.addView(lunchlist);
        return lunchcard;
    }
    public CardView createDinner(){
        // creating card for breakfast
        CardView dinnercard = new CardView(MainActivity.this);
        LinearLayout dinnerlayout = new LinearLayout(MainActivity.this);
        dinnerlayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        int margin = 8;
        params.setMargins(margin, margin, margin, margin);
        dinnercard.setLayoutParams(params);
        dinnercard.setRadius(9);
        dinnercard.setCardBackgroundColor(Color.parseColor("#FFC6D6C3"));
        dinnercard.setMaxCardElevation(15);
        dinnercard.setCardElevation(9);
        dinnercard.addView(dinnerlayout);
        // creating heading for breakfastcard
        TextView breakfasthead = new TextView(MainActivity.this);
        breakfasthead.setText("Dinner");
        dinnerlayout.addView(breakfasthead);
        dinnerlist = new NonScrollListView(MainActivity.this);
        ArrayList<FoodItem> foodlist = new ArrayList<>();
        foodlist.add(new FoodItem("thosai", "yummy"));
        foodlist.add(new FoodItem("thosai", "yummy"));
        foodlist.add(new FoodItem("aloo paratha", "not so good"));
        FoodItemAdapter adapter = new FoodItemAdapter(MainActivity.this, R.layout.food_item, foodlist);
        dinnerlist.setAdapter(adapter);
        //setListViewHeightBasedOnChildren(breakfastlist);
        dinnerlayout.addView(dinnerlist);
        return dinnercard;
    }*/
}