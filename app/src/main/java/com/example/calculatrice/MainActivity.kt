package com.example.calculatrice


import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import com.faendir.rhino_android.RhinoAndroidHelper
import org.mozilla.javascript.Context
import java.lang.Exception
import org.mozilla.javascript.Scriptable





class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var layout : LinearLayout = findViewById(R.id.mainLayout)
        var animationDrawable : AnimationDrawable = layout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2000)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()

    }
    var calcul = ""

    fun operation(view : View){
        var edit = findViewById(R.id.letexte) as EditText
        var bouton = (view as Button)
        if(bouton.text!="=") {
            calcul = calcul + bouton.text
            edit.setText(calcul)
        }else{
            try {
                edit.setText(calculer(calcul))
            } catch (e: Exception) {
                edit.setText("Erreur")
            }

        }
        }

    fun reset(view : View){
        calcul = ""
        (findViewById(R.id.letexte) as EditText).setText("")
    }
    fun effacer(view : View){
        var edit = findViewById(R.id.letexte) as EditText
        calcul = calcul.dropLast(1)
        edit.setText(calcul)
    }


}

fun calculer(calcul:String):String{
    var context = RhinoAndroidHelper().enterContext()
    Context.checkOptimizationLevel(-1)
    var scriptable : Scriptable = context.initStandardObjects()
    return context.evaluateString(scriptable, calcul, "JavaScript", 1, null).toString()
}

