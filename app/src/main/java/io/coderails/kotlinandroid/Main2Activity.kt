package io.coderails.kotlinandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

class Main2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val bh = ButtonHandler()
        findViewById<View>(R.id.button1).setOnClickListener(bh)
        findViewById<View>(R.id.button2).setOnClickListener(bh)
        findViewById<View>(R.id.button3).setOnClickListener(bh)
    }

    private inner class ButtonHandler : View.OnClickListener {
        override fun onClick(view: View) {
            when (view.id) {
                R.id.button1 -> show("Button One")
                R.id.button2 -> show("Button Two")
                R.id.button3 -> show("Button 3")
                else -> show("This should not happen")
            }
        }
    }

    internal fun show(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        Log.i(javaClass.name, message)
    }
}