package com.example.internadmin.fooddiary;

import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.support.v7.widget.Toolbar;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class MainActivity extends AppCompatActivity{
    MaterialSearchView searchView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // main scrollview for MainActivity
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        FrameLayout main = new FrameLayout(MainActivity.this);
        // HANDLING THE TOOLBAR
        toolbar = new Toolbar(MainActivity.this);
        searchView = new MaterialSearchView(MainActivity.this);
        FrameLayout.LayoutParams toolparams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams searchparams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        searchView.setLayoutParams(searchparams);
        searchView.setId(711);
        toolbar.setLayoutParams(toolparams);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        toolbar.setTitle("FOOD!!!");
        toolbar.setVisibility(View.VISIBLE);
        toolbar.setId(710);
        setSupportActionBar(toolbar);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Do some magic
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });
        // HANDLING THE TOOLBAR
        //main.setOrientation(LinearLayout.VERTICAL);
        main.setId(94);
        main.addView(toolbar);
        main.addView(searchView);
        LinearLayout ll = new LinearLayout(MainActivity.this);
        ll.setId(95);
        ll.setOrientation(LinearLayout.VERTICAL);
        FrameLayout.LayoutParams fragparams = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        fragparams.setMargins(0, 200, 0, 0);
        fragparams.height = (int)((size.y)*0.87);
        fragparams.width = (int)(size.x*1);
        ll.setLayoutParams(fragparams);
        AHBottomNavigation bottomNavigation = new AHBottomNavigation(MainActivity.this);
        bottomNavigation.setId(96);
        FrameLayout.LayoutParams navparams = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        navparams.height = (int)((size.y)*0.1);
        bottomNavigation.setLayoutParams(navparams);
        navparams.gravity = Gravity.BOTTOM;
        main.addView(bottomNavigation);
        main.addView(ll);
        Summary summary = new Summary();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(ll.getId(), summary).commit();
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Summary", R.drawable.ic_camera_black_24dp, R.color.colorAccent);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Camera", R.drawable.ic_arrow_back_white, R.color.colorPrimary);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Query Food", R.drawable.ic_arrow_forward_white, R.color.colorPrimary);
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE);
        bottomNavigation.setCurrentItem(1);
        setContentView(main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        return true;
    }
}