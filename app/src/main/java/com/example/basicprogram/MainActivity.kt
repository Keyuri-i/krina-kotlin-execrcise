package com.example.basicprogram

import android.graphics.Color
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView:TextView=findViewById(R.id.txtCondition)
        val html = ("<font color=" + Color.GRAY.toString() + ">I agree with </font><font color=" + Color.BLUE.toString() + "> " +
                "Terms </font><font color="+ Color.GRAY.toString() + ">and </font><font color=" + Color.BLUE.toString() + "> Privacy</font>")
        textView.text = Html.fromHtml(html)

    }
}

