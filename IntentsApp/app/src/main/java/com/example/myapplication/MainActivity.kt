package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var increment = 0
        btnInc.setOnClickListener{
            increment++
            increment_textview.text = increment.toString()
        }

        btnNxt.setOnClickListener {
            val count: String = increment_textview.text.toString()
            Toast.makeText(this,"Moving to next screen",Toast.LENGTH_SHORT)
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)

        }
    }
}