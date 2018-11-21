package io.coderails.kotlinandroid

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_o08_second.*

class O08SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_o08_second)

        btnloaddata.setOnClickListener {

            val filename = "$packageName TESTFILE"
            val pref = getSharedPreferences(filename, Context.MODE_PRIVATE)

            val mlastname = pref.getString("lastname", "")
            val mfirstname = pref.getString("firstname", "")

            txtoutput.text = "$mfirstname $mlastname "

        }
    }

    override fun onResume() {
        super.onResume()

        txtoutput.text = "Click 'LOAD DATA'"
    }
}
