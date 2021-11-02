package com.example.what_is_my_weight

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val LOG_TAG = "myLogs"
    val mars = 0.38
    val POUND_TO_KG = 0.45359237
    val VENUS = 0.91
    val JUPITER = 2.34


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView_Result.text = savedInstanceState?.getString("result")

        cb_Jupiter.setOnClickListener(this)
        cb_Mars.setOnClickListener(this)
        cb_Venus.setOnClickListener(this)


        /*
        calculate_weight.setOnClickListener {


               Log.e(LOG_TAG, "I shouldn't be here");
               Log.e("Serhat", "Why are u there ")

               var userWeightPound = kgToPound(userWeight.toString().toDouble())
               var weightMarsPound = userWeightPound * mars

               var weightMarsKg = poundToKg(weightMarsPound)
               textView_Result.text = weightMarsKg.format(howManyNumber = 2).toString()

           }
           */


    }


    fun kgToPound(kg: Double): Double {

        return kg * 2.5

    }


    fun poundToKg(pound: Double): Double {

        return pound * POUND_TO_KG

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putString("sonuc", textView_Result.text.toString())
    }


    override fun onClick(v: View?) {

        v as CheckBox
        var isChecked: Boolean = v.isChecked


        if (!TextUtils.isEmpty(editText_Weight.text.toString())) {
            var userWeightKg = editText_Weight.text.toString().toDouble()
            var userWeightPound = kgToPound(userWeightKg)

            when (v.id) {

                R.id.cb_Mars -> if (isChecked) {
                    cb_Venus.isChecked = false
                    cb_Jupiter.isChecked = false
                    calculateWeightPound(userWeightPound, v)

                }
                R.id.cb_Venus -> if (isChecked) {
                    cb_Mars.isChecked = false
                    cb_Jupiter.isChecked = false
                    calculateWeightPound(userWeightPound, v)

                }
                R.id.cb_Jupiter -> if (isChecked) {
                    cb_Venus.isChecked = false
                    cb_Mars.isChecked = false
                    calculateWeightPound(userWeightPound, v)

                }
            }


        }


    }

    fun calculateWeightPound(pound: Double, checkBox: CheckBox) {


        var result: Double = 0.0

        when (checkBox.id) {


            R.id.cb_Mars -> result = pound * mars
            R.id.cb_Jupiter -> result = pound * JUPITER
            R.id.cb_Venus -> result = pound * VENUS
            else -> result = 0.0

        }

        var resultToKg = poundToKg(result)
        textView_Result.text = resultToKg.format(2)


    }


    fun Double.format(howManyNumber: Int) = java.lang.String.format("%.${howManyNumber}f", this)


}