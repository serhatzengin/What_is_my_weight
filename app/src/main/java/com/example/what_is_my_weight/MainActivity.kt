package com.example.what_is_my_weight

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val LOG_TAG = "myLogs"
    val mars = 0.38
    val POUND_TO_KG = 0.45359237

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var userWeight = editText_Weight.text
        calculate_weight.setOnClickListener {


            Log.e(LOG_TAG, "I shouldn't be here");
            Log.e("Serhat", "Why are u there ")

            var userWeightPound = kgToPound(userWeight.toString().toDouble())
            var weightMarsPound = userWeightPound * mars

            var weightMarsKg = poundToKg(weightMarsPound)
            textView_Result.text = weightMarsKg.format(howManyNumber = 2).toString()

        }
    }


    fun kgToPound(kg: Double): Double {

        return kg * 2.5

    }


    fun poundToKg(pound: Double): Double {

        return pound * POUND_TO_KG

    }

    fun Double.format(howManyNumber: Int) = java.lang.String.format("%.${howManyNumber}f", this)

}