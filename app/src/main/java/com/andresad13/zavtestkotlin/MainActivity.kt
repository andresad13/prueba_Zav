package com.andresad13.zavtestkotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth



    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()
        var emailEdit = findViewById<EditText>(R.id.emailEdit)
        var passEdit = findViewById<EditText>(R.id.passEdit)
        var registerEdit = findViewById<Button>(R.id.registerButt)
        var toLogin = findViewById<Button>(R.id.ingresarRegister)




        registerEdit.setOnClickListener{
            if (!TextUtils.isEmpty(emailEdit.text.toString())&&!TextUtils.isEmpty(passEdit.text.toString())) {
                auth.createUserWithEmailAndPassword(emailEdit.text.toString(), passEdit.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Log.d(null, "creado correctamente")
                            val intent = Intent(this, HomeActivity::class.java)
                            startActivity(intent)
                            val user = auth.currentUser
                        } else {
                            Toast.makeText(
                                baseContext, "Usuario ya existe",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }
            }
        }
        toLogin.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
