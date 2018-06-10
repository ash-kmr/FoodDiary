package com.example.internadmin.fooddiary;

import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.LinearLayout;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // main scrollview for MainActivity
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        LinearLayout main = new LinearLayout(MainActivity.this);
        main.setOrientation(LinearLayout.VERTICAL);
        main.setId(94);
        LinearLayout ll = new LinearLayout(MainActivity.this);
        ll.setId(95);
        ll.setOrientation(LinearLayout.VERTICAL);
        int androidnavheight = 0;
        Resources resources = getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            androidnavheight = resources.getDimensionPixelSize(resourceId);
        }
        LinearLayout.LayoutParams fragparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        fragparams.height = (int)((size.y)*0.87);
        fragparams.width = (int)(size.x*1);
        ll.setLayoutParams(fragparams);
        AHBottomNavigation bottomNavigation = new AHBottomNavigation(MainActivity.this);
        bottomNavigation.setId(96);
        LinearLayout.LayoutParams navparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        navparams.height = (int)((size.y)*0.1);
        bottomNavigation.setLayoutParams(navparams);
        main.addView(ll);
        main.addView(bottomNavigation);
        Summary summary = new Summary();
        Search searchfrag = new Search();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(ll.getId(), searchfrag).commit();
        //AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Summary", R.drawable.ic_camera_black_24dp, R.color.colorAccent);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Camera", R.drawable.ic_arrow_back_white, R.color.colorPrimary);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Query Food", R.drawable.ic_arrow_forward_white, R.color.colorPrimary);
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        //bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));
        //bottomNavigation.setBehaviorTranslationEnabled(false);
        bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));
        //bottomNavigation.setForceTint(true);
        //bottomNavigation.setTranslucentNavigationEnabled(true);
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE);
        bottomNavigation.setCurrentItem(1);
        //bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        //bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_HIDE);
        //bottomNavigation.setColored(true);
        //bottomNavigation.setNotificationBackgroundColor(Color.parseColor("#F63D2B"));
        setContentView(main);
    }
}