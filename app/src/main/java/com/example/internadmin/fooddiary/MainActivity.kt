package com.example.internadmin.fooddiary

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_tut_activity = findViewById<Button>(R.id.btnTutorial);
        btn_tut_activity.setOnClickListener{
            val intent = Intent(this, IntroActivity::class.java)
            startActivity(intent);
        }

        var btn_PieSliderDialog = findViewById<Button>(R.id.btnPieSliderDialog);
        btn_PieSliderDialog.setOnClickListener{
            var cdd = PieSliderDialog(this);
            cdd.show();
        }


    }
}