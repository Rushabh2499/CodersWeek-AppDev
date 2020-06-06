package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        signUp.setOnClickListener {


        }
    }

    private fun signUp(){
        if(sUserMail.text.toString().isEmpty()){
            sUserMail.error="Please Enter Email"
            sUserMail.requestFocus()
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(sUserMail.text.toString()).matches()){
            sUserMail.error="Please Enter Valid Email"
            sUserMail.requestFocus()
            return
        }
        if(sUserPass.text.toString().isEmpty()){
            sUserPass.error="Please Enter Password"
            sUserPass.requestFocus()
            return
        }

        auth.createUserWithEmailAndPassword(sUserMail.text.toString(), sUserPass.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    startActivity(Intent(this,MainActivity::class.java))
                    finish()
                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(baseContext, "Authentication failed. Try again later.",
                        Toast.LENGTH_SHORT).show()

                }

                // ...
            }
    }

}