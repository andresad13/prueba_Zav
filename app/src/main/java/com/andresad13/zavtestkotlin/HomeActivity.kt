package com.andresad13.zavtestkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser
        var signOut = findViewById<Button>(R.id.signOut)
        var nameUser = findViewById<TextView>(R.id.nameUser)


            nameUser.text = user?.email



        signOut.setOnClickListener {

            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}
