package com.example.tic_tac_toe

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.schedule
import java.util.Timer as Timer1

class MainActivity : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun endgame(num: Int){
            btn00.isEnabled=false
            btn01.isEnabled=false
            btn02.isEnabled=false
            btn10.isEnabled=false
            btn11.isEnabled=false
            btn12.isEnabled=false
            btn20.isEnabled=false
            btn21.isEnabled=false
            btn22.isEnabled=false

            turns=num
            startActivity(Intent(this,RetryActivity::class.java))
            finish()


        }

        fun gamer(x:Int,y:Int){
            val compKt = comp(x,y);
            when(a){
                0-> when (b) {
                    0 -> {
                        btn00.text="O"
                        btn00.isEnabled=false
                    }
                    1 -> {
                        btn01.text="O"
                        btn01.isEnabled=false
                    }
                    2 -> {
                        btn02.text="O"
                        btn02.isEnabled=false
                    }
                }

                1-> when (b) {
                    0 -> {
                        btn10.text="O"
                        btn10.isEnabled=false
                    }
                    1 -> {
                        btn11.text="O"
                        btn11.isEnabled=false
                    }
                    2 -> {
                        btn12.text="O"
                        btn12.isEnabled=false
                    }
                }

                2-> when (b) {
                    0 -> {
                        btn20.text="O"
                        btn20.isEnabled=false
                    }
                    1 -> {
                        btn21.text="O"
                        btn21.isEnabled=false
                    }
                    2 -> {
                        btn22.text="O"
                        btn22.isEnabled=false
                    }
                }
                else ->{
                    turn.text="wubba lubba dub dub"
                }
            }
            when (compKt) {
                1 -> {
                    endgame(1)
                }
                2 -> {
                    endgame(2)
                }
                5 -> {
                    endgame(5)
                }
            }

        }

        btn00.setOnClickListener {
            btn00.setTextColor(Color.parseColor("#ffffff"))
            btn00.text="X"
            btn00.isEnabled=false
            gamer(0,0)
            Toast.makeText(this,"Computer has played its turn",Toast.LENGTH_SHORT).show()

        }
        btn01.setOnClickListener {
            btn01.setTextColor(Color.parseColor("#ffffff"))
            btn01.text="X"
            btn01.isEnabled=false
            gamer(0,1)
            Toast.makeText(this,"Computer has played its turn",Toast.LENGTH_SHORT).show()
        }
        btn02.setOnClickListener {
            btn02.setTextColor(Color.parseColor("#ffffff"))
            btn02.text="X"
          //  Toast.makeText(this,"Computer has played its turn",Toast.LENGTH_SHORT).show()
            btn02.isEnabled=false
            gamer(0,2)
            Toast.makeText(this,"Computer has played its turn",Toast.LENGTH_SHORT).show()
        }
        btn10.setOnClickListener {
            btn10.setTextColor(Color.parseColor("#ffffff"))
            btn10.text="X"
            //Toast.makeText(this,"Computer has played its turn",Toast.LENGTH_SHORT).show()
            btn10.isEnabled=false
            gamer(1,0)
            Toast.makeText(this,"Computer has played its turn",Toast.LENGTH_SHORT).show()
        }
        btn11.setOnClickListener {
            btn11.setTextColor(Color.parseColor("#ffffff"))
            btn11.text="X"
           // Toast.makeText(this,"ID= "+this.taskId,Toast.LENGTH_SHORT).show()
            btn11.isEnabled=false
            gamer(1,1)
            Toast.makeText(this,"Computer has played its turn",Toast.LENGTH_SHORT).show()
        }
        btn12.setOnClickListener {
            btn12.setTextColor(Color.parseColor("#ffffff"))
            btn12.text="X"
            //Toast.makeText(this,"Computer has played its turn",Toast.LENGTH_SHORT).show()
            btn12.isEnabled=false
            gamer(1,2)
            Toast.makeText(this,"Computer has played its turn",Toast.LENGTH_SHORT).show()
        }
        btn20.setOnClickListener {
            btn20.setTextColor(Color.parseColor("#ffffff"))
            btn20.text="X"
           // Toast.makeText(this,"Computer has played its turn",Toast.LENGTH_SHORT).show()
            btn20.isEnabled=false
            gamer(2,0)
            Toast.makeText(this,"Computer has played its turn",Toast.LENGTH_SHORT).show()
        }
        btn21.setOnClickListener {
            btn21.setTextColor(Color.parseColor("#ffffff"))
            btn21.text="X"
           // Toast.makeText(this,"Computer has played its turn",Toast.LENGTH_SHORT).show()
            btn21.isEnabled=false
            gamer(2,1)
            Toast.makeText(this,"Computer has played its turn",Toast.LENGTH_SHORT).show()
        }
        btn22.setOnClickListener {
            btn22.setTextColor(Color.parseColor("#ffffff"))
            btn22.text="X"
            //Toast.makeText(this,"Computer has played its turn",Toast.LENGTH_SHORT).show()
            btn22.isEnabled=false
            gamer(2,2)
            Toast.makeText(this,"Computer has played its turn",Toast.LENGTH_SHORT).show()
        }


    }
}


