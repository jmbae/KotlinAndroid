package io.coderails.kotlinandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_xml_id.setOnClickListener { v ->
            println(v.id)
            when (v.id) {
                R.id.button_xml_id -> sayHelloXml(v)
            }
        }

        button = findViewById(R.id.button_xml_id)
        button.setOnClickListener { view ->
            when (view.id) {
                R.id.button_xml_id -> sayHello(view)
            }
        }

        println(button === button_xml_id) // true
        println(button == button_xml_id) // true
    }


    fun sayHello(v: View) {
        println("Hello $v")
    }

    fun sayHelloXml(v: View) {
        println("Hello from Xml $v")
    }
}
