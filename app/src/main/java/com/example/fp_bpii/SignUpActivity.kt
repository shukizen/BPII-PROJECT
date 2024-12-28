package com.example.fp_bpii

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSignIn: TextView = findViewById(R.id.button5) // Inisialisasi TextView untuk sign-in

        // Listener untuk kembali ke halaman sign-in
        btnSignIn.setOnClickListener {
            val intentSignIn = Intent(this, LoginActivity::class.java)
            startActivity(intentSignIn)
            finish() // Optional: Menutup SignUpActivity agar tidak menumpuk di back stack
        }
    }
}