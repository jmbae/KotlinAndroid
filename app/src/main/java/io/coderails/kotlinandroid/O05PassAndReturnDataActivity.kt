package io.coderails.kotlinandroid

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_o05_pass_and_return_data.*

class O05PassAndReturnDataActivity : AppCompatActivity() {
    val RECEIVE_DATA_ACTIVITY = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_o05_pass_and_return_data)

        input_weight.setHint("weight (kg)")
        input_height.setHint("height (cm)")

        btn_send_data.setOnClickListener {

            val intent = Intent(this@O05PassAndReturnDataActivity, O05ReceiveDataActivity::class.java)
            val bundle = Bundle()

            bundle.putFloat("weight", input_weight.text.toString().toFloat())
            bundle.putFloat("height", input_height.text.toString().toFloat())
            intent.putExtra("my_data", bundle)

            startActivityForResult(intent, RECEIVE_DATA_ACTIVITY)
        }
    }

    override fun onResume() {
        super.onResume()
        clearInputs()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if((requestCode == RECEIVE_DATA_ACTIVITY) and (resultCode == Activity.RESULT_OK))  {
            val bmi = data!!.getFloatExtra("return_data", 1.0F)
            val bmiString = "%.2f".format(bmi)
            input_height.setText("")
            input_weight.setText("")
            txt_bmi.setText("BMI : $bmiString ${getBMIDescription(bmi)}")
        }
    }

    private fun getBMIDescription(bmi: Float) : String {
        return when (bmi) {
            in 1.0..18.5 -> "저체중"
            in 18.6..24.9 -> "보통"
            in 25.0..29.9 -> "과체중"
            else -> "비만"
        }
    }

    private fun clearInputs() {
        input_weight.setText("")
        input_height.setText("")
    }

}
