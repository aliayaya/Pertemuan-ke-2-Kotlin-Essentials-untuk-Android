package com.example.pb02_kotlinessentials

import android.graphics.Typeface
import android.os.Bundle
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textView = TextView(this).apply {
            text = getFormattedStudentData()
            typeface = Typeface.MONOSPACE
            textSize = 14f
            setPadding(32, 48, 32, 48)
        }

        val scrollView = ScrollView(this).apply {
            addView(textView)
        }

        setContentView(scrollView)
    }
}
