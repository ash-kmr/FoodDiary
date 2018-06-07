package com.example.internadmin.fooddiary;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
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
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // main scrollview for MainActivity
        ScrollView sv = new ScrollView(MainActivity.this);
        LinearLayout ll = new LinearLayout(MainActivity.this);
        ll.setOrientation(LinearLayout.VERTICAL);
        sv.addView(ll);
        // get display size of phone
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int[][] vals = new int[2][7];
        vals[0] = new int[]{1, 2, 3, 4, 5, 6, 7};
        vals[1] = new int[]{1, 2, 3, 4, 5, 6, 7};
        CardView barcard = createChart(vals);
        ll.addView(barcard);

        //CardView breakfastcard = createBreakfast();
        setContentView(sv);

    }
    public CardView createChart(int[][] vals){
        // get system width
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        CardView barcard = new CardView(MainActivity.this);
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
        BarChart chart = new BarChart(MainActivity.this);
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
        chart.setMinimumWidth(size.x);
        barcard.addView(chart);
        return barcard;
    }

    public ListView createBreakfast(){
        ListView breakfast = new ListView(MainActivity.this);
        String[] elem = new String[] {"android", "php"};
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, R.layout., elem);
        return breakfast;
    }
}