package com.exmin.myapplication.time_and_datepicker

import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.exmin.myapplication.R
import java.util.Calendar

class datepicker : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.datepicker)

        val datePicker = findViewById<DatePicker>(R.id.date)
        val dateText = findViewById<TextView>(R.id.date_text)

        // Current date
        val calendar = Calendar.getInstance()

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // Initially selected date show karo
        dateText.text = "$day/${month + 1}/$year"

        // Date change listener
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            datePicker.setOnDateChangedListener { _, selectedYear, selectedMonth, selectedDay ->

                dateText.text =
                    "$selectedDay/${selectedMonth + 1}/$selectedYear"
            }
        }
    }
}