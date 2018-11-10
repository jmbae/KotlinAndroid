package io.coderails.kotlinandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_o02_click_event.*

class O02ClickEventActivity : AppCompatActivity() {
    lateinit var mButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_o02_click_event)
//   The following code is a verbose way of setting up
//   an anonymous inner object

        mButton = findViewById(R.id.button)

        println(button === mButton) // true
        println(button == mButton) // true

        button.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(this@O02ClickEventActivity, "Hello World", Toast.LENGTH_LONG).show()
                println("Hello click")
//                finish() 4강 나중용
            }
        })

//  Using lambdas to setup event listeners is much cleaner

//        button.setOnClickListener {
//            Toast.makeText(this, "Hello World", Toast.LENGTH_LONG).show()
//            println("Hello")
//        finish() 이건 나중에 4강에서 돌아가는 거
//        }


        button.setOnLongClickListener(object: View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {
                Snackbar.make(root_layout, "long click", Snackbar.LENGTH_LONG).show()
                return true
            }
        })

//        button.setOnLongClickListener {
//            Snackbar.make(root_layout, "Long click", Snackbar.LENGTH_INDEFINITE).show()
//            true
//        }
    }
}
