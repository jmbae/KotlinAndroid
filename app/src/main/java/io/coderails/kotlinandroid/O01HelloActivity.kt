package io.coderails.kotlinandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_o01_hello.*

//  1. 원래는 XML에서 선언한 디자인 컴포넌트를 findViewById 로 불러워서 변수를 지정하거나 해야했다.
//  2. 코틀린 안드로이드 확장은 findViewById를 사용하지 않아도 자동으로 변수를 잡아줌 동적으로 매핑된 변수를 그대로 사용하면 된다.
//  3. XML에서 버튼 컴포넌트는 사용하는 액티비티의 함수를 호출 할 수 있다.
class O01HelloActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_o01_hello)

        //  findViewById<TextView>(R.id.textHello).text = "Hello Ted"
        textHello.text = "1"
        // setText() still works, but better use the getter and setter syntax
        // textHello.setText("2")
    }

    fun addNumber(v: View) {
        val currVal = textHello.text.toString().toInt()
        val nextVal = currVal + 1
        textHello.text = nextVal.toString()
    }
}
