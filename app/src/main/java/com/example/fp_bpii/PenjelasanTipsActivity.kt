package com.example.fp_bpii
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class PenjelasanTipsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penjelasantips)

        // Mendapatkan data yang dikirimkan melalui Intent
        val namaTips = intent.getStringExtra("nama_tips") ?: "Nama Tips Tidak Ditemukan"
        val gambar = intent.getStringExtra("gambar") ?: ""
        val penjelasan = intent.getStringExtra("penjelasan") ?: "Penjelasan Tidak Tersedia"

        // Menampilkan data di UI
        val NamaTips: TextView = findViewById(R.id.nametips)
        val GambarTips: ImageView = findViewById(R.id.logotips)
        val PenjelasanTips: TextView = findViewById(R.id.deskripsitips)

        // Set data ke TextView dan ImageView
        NamaTips.text = namaTips
        PenjelasanTips.text = penjelasan

        // Memuat gambar menggunakan Picasso
        if (gambar.isNotEmpty()) {
            val imageUrl = "http://10.200.121.41/rest_apibp2/gambar/$gambar"
            Picasso.get()
                .load(imageUrl)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_report_image)
                .into(GambarTips)
        }

        // Tombol kembali
        val btnBack: ImageButton = findViewById(R.id.btn_back)
        btnBack.setOnClickListener { finish() }
    }
}



