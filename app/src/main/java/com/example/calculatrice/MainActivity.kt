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
    var nb1 : Double? = null

    fun chiffre(view: View) {
        var edit = findViewById(R.id.letexte) as EditText
        var letext = edit.text.toString() + (view as Button).text
        // Do something in response to button click
        edit.setText(letext)
    }
    var operation = ""
    var result = 0.0
    fun operation(view : View){

        var edit = findViewById(R.id.letexte) as EditText
        if(nb1==null){
            nb1 = edit.text.toString().toDouble()
            operation = (view as Button).text.toString()
            edit.setText("")

        }else{
            if(operation=="+"){result = nb1!! + edit.text.toString().toDouble()}
            else if(operation=="-"){result = nb1!! - edit.text.toString().toDouble()}
            else if(operation=="*"){result = nb1!! * edit.text.toString().toDouble()}
            else if(operation=="/"){result = nb1!! / edit.text.toString().toDouble()}
            edit.setText(result.toString())

        }




    }

}