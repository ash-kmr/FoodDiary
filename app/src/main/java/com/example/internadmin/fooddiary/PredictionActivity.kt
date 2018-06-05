package com.example.internadmin.fooddiary

import android.app.PendingIntent.getActivity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class PredictionActivity : AppCompatActivity() {

    private var listpredictions = ArrayList<Prediction>()
    private lateinit var  predictionlistview: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prediction)

        listpredictions.add(Prediction("Briyani", 1))
        listpredictions.add(Prediction("Prata", 1))
        listpredictions.add(Prediction("Yam", 1))
        listpredictions.add(Prediction("Rice", 1))


        val predictAdapter = PredictListViewAdapter(this, listpredictions)
        predictionlistview = findViewById(R.id.predictionlistview)
        predictionlistview.adapter = predictAdapter
        predictionlistview.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                Toast.makeText(this, "Found as " + position.toString(), Toast.LENGTH_LONG).show()
            }
        }

}
