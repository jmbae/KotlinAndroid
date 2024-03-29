package io.coderails.kotlinandroid

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_o05_receive_data.*
import java.util.logging.Logger

class O05ReceiveDataActivity : AppCompatActivity() {
    val Log = Logger.getLogger(O05ReceiveDataActivity::class.java.name)
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_o05_receive_data)

        val bundle = intent.getBundleExtra("my_data")
        val height = bundle.getFloat("height", 0f)/100f
        val weight = bundle.getFloat("weight", 0f)

        txt_intentdata.text = "키: ${height}m | 몸무게: ${weight}kg"

        btn_calculate.setOnClickListener {
            val intent = Intent()
            val bmi = (weight / (height * height))
            Log.info(weight.toString())
            Log.info(height.toString())
            Log.info(bmi.toString())
            intent.putExtra("return_data", bmi)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
