package com.odsstudio.contactsbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val extras = intent.extras
        val textView = findViewById<TextView>(R.id.intentData).also {
            if (extras != null) {
                it.text = extras.get("myName").toString()
            }
        }


    }


}