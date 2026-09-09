package com.exmin.myapplication.Snackbar

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.exmin.myapplication.R
import com.google.android.material.snackbar.Snackbar


class Snackbar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.snackbar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val Saved =findViewById<Button>(R.id.saved)
        Saved.setOnClickListener {
            Snackbar.make(it, "Data saved success fully", Snackbar.LENGTH_SHORT).show()
        }
    }
    }
