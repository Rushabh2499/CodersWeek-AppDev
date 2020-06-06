package com.example.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_signup.*


class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        btnSignUp.setOnClickListener {
            var intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }

        login.setOnClickListener {
            doLogin()
        }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    fun doLogin(){
        if(userMail.text.toString().isEmpty()){
            userMail.error="Please Enter Email"
            userMail.requestFocus()
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(userMail.text.toString()).matches()){
            userMail.error="Please Enter Valid Email"
            userMail.requestFocus()
            return
        }
        if(userPass.text.toString().isEmpty()){
            userPass.error="Please Enter Password"
            userPass.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(userMail.text.toString(), userPass.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.

                    updateUI(null)
                    // ...
                }

                // ...
            }
    }

    fun updateUI(currentUser: FirebaseUser?) {
        if(currentUser!=null){
            startActivity(Intent(this,DashActivity::class.java))
        }else{
            Toast.makeText(baseContext, "Log in failed.",Toast.LENGTH_SHORT).show()
        }
    }
}
