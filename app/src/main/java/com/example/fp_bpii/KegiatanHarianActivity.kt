package com.example.fp_bpii

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class KegiatanHarianActivity : AppCompatActivity() {
    private lateinit var sharedPreferencesUser: SharedPreferencesUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kegiatan_harian)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sharedPreferencesUser = SharedPreferencesUser(this)
        // Dapatkan nama pengguna dari SharedPreferences
        val userName = sharedPreferencesUser.getUserName()
        val txtWelcome: TextView = findViewById(R.id.textViewNamen)
        txtWelcome.text = "Hallo, $userName"


    }
}