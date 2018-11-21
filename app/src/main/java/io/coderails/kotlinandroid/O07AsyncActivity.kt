package io.coderails.kotlinandroid

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_o07_async.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.logging.Logger

class O07AsyncActivity : AppCompatActivity(), View.OnClickListener {

    private var Log = Logger.getLogger(O07AsyncActivity::class.java.name)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_o07_async)

        button.setOnClickListener(this)
        button2.setOnClickListener { Log.info("Clicked") }
    }

    override fun onClick(v: View) {
//         이건 안되는 코드
//        var i = 0
//        while (i < 15) {
//            try {
//                Thread.sleep(2000)
//                textView.text = String.format("Value of i = %d", i)
//                Log.info( String.format("value of i = %d", i++) )
//            } catch (e: InterruptedException) {
//                e.printStackTrace()
//            }
//        }

//         옛날 코드
//        val worker = Worker()
//        worker.execute(textView)

        GlobalScope.launch {
            var i = 0
            while (i++ < 15) {
                Thread.sleep(2000)
                delay(2000)
                runOnUiThread {
                    textView.text = "Value of i = $i"
                }
            }
        }
    }

    class Worker : AsyncTask<TextView, String, Boolean>() {
        lateinit var tv: TextView

        override fun doInBackground(vararg textViews: TextView): Boolean? {
            tv = textViews[0]

            var i = 0
            while (i++ < 15) {
                try {
                    Thread.sleep(2000)
                    publishProgress(String.format("Value of i = %d", i))
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

            }
            return true
        }

        override fun onProgressUpdate(vararg values: String) {
            tv.text = values[0]
        }
    }
}


