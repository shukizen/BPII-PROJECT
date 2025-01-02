package com.example.fp_bpii

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val btnTips: LinearLayout = findViewById(R.id.Tips)

        btnTips.setOnClickListener {
            val intent = Intent(this, TipsActivity::class.java)
            startActivity(intent)

    }

        val btnMental: LinearLayout = findViewById(R.id.Mental)

        btnMental.setOnClickListener {
            val intent = Intent(this, MentalActivity::class.java)
            startActivity(intent)

        }
    }
}