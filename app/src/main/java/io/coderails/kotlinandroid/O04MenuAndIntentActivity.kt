package io.coderails.kotlinandroid

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_o04_menu_and_intent.*
import java.util.logging.Logger

// 액티비티 라이프 사이클
// 로거 사용법
// 인텐트 소개, 전달 방식 이해
// 메뉴 옵션 선택 ( AppCompat )
//
class O04MenuAndIntentActivity : AppCompatActivity() {

    private val Log = Logger.getLogger(O04MenuAndIntentActivity::class.java.name)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_o04_menu_and_intent)

        Log.info("onCreate")

        button.setOnClickListener {
            val intent = Intent(this@O04MenuAndIntentActivity, O02ClickEventActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onPause() {
        super.onPause()
        Log.info("onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.info("onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.info("onResume")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add("Web")
        menu?.add("Map")
        menu?.add("Phone number")
        menu?.add("Go to ClickEventActivity")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var uri: Uri
        var intent: Intent = Intent()

        when (item?.toString()) {
            "Web" -> {
                uri = Uri.parse("https://www.apress.com")
//        intent = Intent(Intent.ACTION_VIEW, uri)
                intent = Intent()
                intent.setData(uri)
                intent.setAction(Intent.ACTION_VIEW)
            }
            "Map" -> {
                uri = Uri.parse("geo:40.7113399,-74.0263469")

//        This would have worked as well
//        uri = Uri.parse("https://maps.google.com/maps?q=40.7113399,-74.0263469")
                intent = Intent(Intent.ACTION_VIEW, uri)

            }
            "Phone number" -> {
                uri = Uri.parse("tel:639285083333")
                intent = Intent(Intent.ACTION_DIAL, uri)
            }
            "Go to ClickEventActivity" -> {
                val intent = Intent(this, O02ClickEventActivity::class.java)
                startActivity(intent)
            }
        }
        startActivity(intent)
        return true
    }

}
