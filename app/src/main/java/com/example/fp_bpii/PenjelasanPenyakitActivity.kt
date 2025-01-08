package com.example.fp_bpii

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.squareup.picasso.Picasso

class PenjelasanPenyakitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penjelasanpenyakit)

        val jenisPenyakit = intent.getStringExtra("jenis_penyakit") ?: "Nama Penyakit Tidak Ditemukan"
        val gambarPenyakit = intent.getStringExtra("gambar") ?: ""
        val pengertian = intent.getStringExtra("pengertian") ?: "Penjelasan Tidak Tersedia"
        val gejala = intent.getStringExtra("gejala") ?: "Gejala Tidak Tersedia"
        val pengobatan = intent.getStringExtra("pengobatan") ?: "Pengobatan Tidak Tersedia"

        // Menampilkan data di UI
        val namaPenyakit: TextView = findViewById(R.id.jenispenyakit)
        val gambarPenyakitView: ImageView = findViewById(R.id.logopenyakit)
        val pengertianView: TextView = findViewById(R.id.pengertianpenyakit)
        val gejalaView: TextView = findViewById(R.id.gejalapenyakit)
        val pengobatanView: TextView = findViewById(R.id.pengobatanpenyakit)

        namaPenyakit.text = jenisPenyakit
        pengertianView.text = pengertian
        gejalaView.text = gejala
        pengobatanView.text = pengobatan

        if (gambarPenyakit.isNotEmpty()) {
            val imageUrl = "http://172.25.206.48/rest_apibp2/penyakit/$gambarPenyakit"
            Picasso.get()
                .load(imageUrl)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_report_image)
                .into(gambarPenyakitView)
        }

        val btnBack: ImageButton = findViewById(R.id.btn_back)
        btnBack.setOnClickListener { finish() }
    }
}