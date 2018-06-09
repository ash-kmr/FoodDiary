package com.example.internadmin.fooddiary;


import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

public class Summary extends Fragment {
    ScrollView sv;
    CardView barcard;
    BarChart chart;
    NonScrollListView breakfastlist;
    NonScrollListView lunchlist;
    NonScrollListView dinnerlist;
    public Summary() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null)
            return;


        //setContentView(sv);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        sv = new ScrollView(getContext());
        LinearLayout ll = new LinearLayout(getContext());
        ll.setOrientation(LinearLayout.VERTICAL);
        sv.addView(ll);
        // get display size of phone
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int[][] vals = new int[2][7];
        vals[0] = new int[]{1, 2, 3, 4, 5, 6, 7};
        vals[1] = new int[]{1, 2, 3, 4, 5, 6, 7};
        CardView barcard = createChart(vals);
        ll.addView(barcard);
        CardView breakfastcard = createBreakfast();
        CardView lunchcard = createLunch();
        CardView dinnercard = createDinner();
        ll.addView(breakfastcard);
        //breakfastcard.setVisibility(View.INVISIBLE);
        //barcard.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein));
        ll.addView(lunchcard);
        ll.addView(dinnercard);
        return sv;
    }

    public CardView createChart(int[][] vals){
        // get system width
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        barcard = new CardView(getContext());
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
        chart = new BarChart(getContext());
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
        CardView breakfastcard = new CardView(getContext());
        LinearLayout breakfastlayout = new LinearLayout(getContext());
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
        TextView breakfasthead = new TextView(getContext());
        breakfasthead.setText("Breakfast");
        breakfastlayout.addView(breakfasthead);
        breakfastlist = new NonScrollListView(getContext());
        ArrayList<FoodItem> foodlist = new ArrayList<>();
        foodlist.add(new FoodItem("thosai", "yummy"));
        foodlist.add(new FoodItem("thosai", "yummy"));
        foodlist.add(new FoodItem("aloo paratha", "not so good"));
        FoodItemAdapter adapter = new FoodItemAdapter(getContext(), R.layout.food_item, foodlist);
        breakfastlist.setAdapter(adapter);
        //setListViewHeightBasedOnChildren(breakfastlist);
        breakfastlayout.addView(breakfastlist);
        return breakfastcard;
    }
    public CardView createLunch(){
        // creating card for breakfast
        CardView lunchcard = new CardView(getContext());
        LinearLayout lunchlayout = new LinearLayout(getContext());
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
        TextView breakfasthead = new TextView(getContext());
        breakfasthead.setText("Lunch");
        lunchlayout.addView(breakfasthead);
        lunchlist = new NonScrollListView(getContext());
        ArrayList<FoodItem> foodlist = new ArrayList<>();
        foodlist.add(new FoodItem("thosai", "yummy"));
        foodlist.add(new FoodItem("thosai", "yummy"));
        foodlist.add(new FoodItem("aloo paratha", "not so good"));
        FoodItemAdapter adapter = new FoodItemAdapter(getContext(), R.layout.food_item, foodlist);
        lunchlist.setAdapter(adapter);
        //setListViewHeightBasedOnChildren(breakfastlist);
        lunchlayout.addView(lunchlist);
        return lunchcard;
    }
    public CardView createDinner(){
        // creating card for breakfast
        CardView dinnercard = new CardView(getContext());
        LinearLayout dinnerlayout = new LinearLayout(getContext());
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
        TextView breakfasthead = new TextView(getContext());
        breakfasthead.setText("Dinner");
        dinnerlayout.addView(breakfasthead);
        dinnerlist = new NonScrollListView(getContext());
        ArrayList<FoodItem> foodlist = new ArrayList<>();
        foodlist.add(new FoodItem("thosai", "yummy"));
        foodlist.add(new FoodItem("thosai", "yummy"));
        foodlist.add(new FoodItem("aloo paratha", "not so good"));
        FoodItemAdapter adapter = new FoodItemAdapter(getContext(), R.layout.food_item, foodlist);
        dinnerlist.setAdapter(adapter);
        //setListViewHeightBasedOnChildren(breakfastlist);
        dinnerlayout.addView(dinnerlist);
        return dinnercard;
    }

}
