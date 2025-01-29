package ru.fefu.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class LoginActivity: AppCompatActivity(R.layout.login) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        val backBtn = findViewById<ImageButton>(R.id.backBtn)
        backBtn.setOnClickListener {
            val intent = Intent(this, WelcomeScreenActivity::class.java)
            startActivity(intent)
        }
    }
}