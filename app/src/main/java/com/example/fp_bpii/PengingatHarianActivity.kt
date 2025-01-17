package com.example.fp_bpii

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PengingatHarianActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pengingat_harian)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val btnnew: Button = findViewById(R.id.button)
        btnnew.setOnClickListener {
            val intent = Intent(this, TambahKegiatanActivity::class.java)
            startActivity(intent)
        }

        val btnharian: Button = findViewById(R.id.button12)
        btnharian.setOnClickListener {
            val intent = Intent(this, KegiatanHarianActivity::class.java)
            startActivity(intent)
        }


        val btnback: ImageButton = findViewById(R.id.back_button)
        btnback.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}