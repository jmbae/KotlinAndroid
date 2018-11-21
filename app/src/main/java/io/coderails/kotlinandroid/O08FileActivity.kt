package io.coderails.kotlinandroid

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_o08_file.*
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

class O08FileActivity : AppCompatActivity() {
    private val filename = "myfile.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_o08_file)


    }

    fun saveData(v: View) {
        val str = edittext.getText().toString()

        var out: FileOutputStream? = null
        try {
            out = openFileOutput(filename, Context.MODE_PRIVATE)
            out!!.write(str.toByteArray())
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            // You should do more logging here
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            if (out != null) {
                try {
                    out!!.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }
        }

    }

    fun loadData(v: View) {
        var fileInputStream: FileInputStream? = null
        val sb = StringBuilder()

        try {
            fileInputStream = openFileInput(filename)
            do {
                var read = fileInputStream.read()
                sb.append(read.toChar())
            } while (read >= 0)
            textview.setText(sb.toString())
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream!!.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }
        }
    }


}
