package com.example.fp_bpii

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fp_bpii.client.RetrofitClient
import com.example.fp_bpii.response.users.Penyakit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PenyakitActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterPenyakit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penyakit)

        // Tombol kembali
        val btnBack: ImageButton = findViewById(R.id.btn_back)
        btnBack.setOnClickListener { finish() }

        // Inisialisasi RecyclerView
        recyclerView = findViewById(R.id.penyakit)
        recyclerView.layoutManager = GridLayoutManager(this, 3) // 3 kolom
        recyclerView.setHasFixedSize(true) // Opsional untuk meningkatkan performa

        // Muat data penyakit dari server
        loadPenyakitData()
    }

    private fun loadPenyakitData() {
        RetrofitClient.instance.getPenyakit().enqueue(object : Callback<List<Penyakit>> {
            override fun onResponse(call: Call<List<Penyakit>>, response: Response<List<Penyakit>>) {
                if (response.isSuccessful && response.body() != null) {
                    val penyakitList = response.body()!!

                    if (penyakitList.isNotEmpty()) {
                        adapter = AdapterPenyakit(
                            context = this@PenyakitActivity,
                            listPenyakit = penyakitList,
                            onItemClick = { penyakit ->
                                val intent = Intent(this@PenyakitActivity, PenjelasanPenyakitActivity::class.java)
                                intent.putExtra("jenis_penyakit", penyakit.jenis_penyakit)
                                intent.putExtra("gambar", penyakit.gambar)
                                intent.putExtra("pengertian", penyakit.pengertian)
                                intent.putExtra("gejala", penyakit.gejala)
                                intent.putExtra("pengobatan", penyakit.pengobatan)
                                startActivity(intent)

                                Toast.makeText(this@PenyakitActivity, "Clicked: ${penyakit.jenis_penyakit}", Toast.LENGTH_SHORT).show()
                            }
                        )
                        recyclerView.adapter = adapter
                    }
                }
            }

            override fun onFailure(call: Call<List<Penyakit>>, t: Throwable) {
                Toast.makeText(this@PenyakitActivity, "Gagal memuat data", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
