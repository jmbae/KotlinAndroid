package io.coderails.kotlinandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.coderails.kotlinandroid.O06.BookDescription
import io.coderails.kotlinandroid.O06.Coordinator
import kotlinx.android.synthetic.main.activity_o06_book.*

class O06BookActivity : AppCompatActivity(), Coordinator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_o06_book)
    }

    override fun onBookChanged(index:Int) {
        val frag = fragmentbookdescription
        if (frag is BookDescription) {
            frag.changeDescription(index)
        }
    }
}
