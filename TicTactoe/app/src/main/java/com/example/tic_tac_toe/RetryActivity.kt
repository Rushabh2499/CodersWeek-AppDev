package com.example.tic_tac_toe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_retry.*

class RetryActivity : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retry)
        when (turns) {
            1 -> {
                result.text="You Win!!"
            }
            2 -> {
                result.text="You Lose!!"
            }
            5 -> {
                result.text="Its a Tie!!"
            }
        }

        retryBtn.setOnClickListener {
            for (i in 0..2){
                for (j in 0..2){
                    com.example.tic_tac_toe.gameSquare!![i][j]='-'
                }
            }
            turns=0
            compTurn=0
            a=null
            b=null

            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }


    }
}
