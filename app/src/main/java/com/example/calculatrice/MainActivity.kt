package com.example.calculatrice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun chiffre(view: View) {
        var edit = findViewById(R.id.letexte) as EditText
        var letext = edit.text.toString() + (view as Button).text
        // Do something in response to button click
        edit.setText(letext)
    }

}