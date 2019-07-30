package com.andresad13.zavtestkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        var emailEditLogin = findViewById<EditText>(R.id.emailEditLogin)
        var passEditLogin = findViewById<EditText>(R.id.passEditLogin)
        var registerEditLogin = findViewById<Button>(R.id.registerButtLogin)
        var toRegister = findViewById<Button>(R.id.registerLogin)


        registerEditLogin.setOnClickListener{

            auth.signInWithEmailAndPassword(emailEditLogin.text.toString(), passEditLogin.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d(null, "signInWithEmail:success")
                        val intent = Intent(this,HomeActivity::class.java)
                        startActivity(intent)
                        val user = auth.currentUser
                    } else {
                        Log.w(null, "signInWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "usuario o password errados.",
                            Toast.LENGTH_SHORT).show()
                    }

                }
        }
     toRegister.setOnClickListener {
         val intent = Intent(this,MainActivity::class.java)
         startActivity(intent)
     }

    }
}
