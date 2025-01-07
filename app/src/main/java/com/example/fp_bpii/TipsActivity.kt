package com.example.fp_bpii
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fp_bpii.client.RetrofitClient
import com.example.fp_bpii.response.Tips
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TipsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterTips

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tips)

        // Tombol kembali
        val btnBack: ImageButton = findViewById(R.id.btn_back)
        btnBack.setOnClickListener { finish() }

        // Inisialisasi RecyclerView
        recyclerView = findViewById(R.id.tips)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // Jika ingin 2 kolom
        recyclerView.setHasFixedSize(true) // Opsional jika ingin meningkatkan performa

        // Muat data tips dari server
        loadTipsData()
    }

    private fun loadTipsData() {
        RetrofitClient.instance.getTips().enqueue(object : Callback<List<Tips>> {
            override fun onResponse(call: Call<List<Tips>>, response: Response<List<Tips>>) {
                if (response.isSuccessful && response.body() != null) {
                    val tipsList = response.body()!!

                    if (tipsList.isNotEmpty()) {
                        adapter = AdapterTips(
                            context = this@TipsActivity,
                            listTips = tipsList,
                            onItemClick = { tip ->
                                val intent = Intent(this@TipsActivity, PenjelasanTipsActivity::class.java)
                                intent.putExtra("nama_tips", tip.nama_tips) // Kirim ID atau data lain yang diperlukan
                                intent.putExtra("gambar", tip.gambar)
                                intent.putExtra("penjelasan", tip.penjelasan) // Misal, jika ada URL gambar
                                startActivity(intent)

                                Toast.makeText(this@TipsActivity, "Clicked: ${tip.nama_tips}", Toast.LENGTH_SHORT).show()
                            }
                        )
                        recyclerView.adapter = adapter // Menetapkan adapter
                    }
                }
            }
            override fun onFailure(call: Call<List<Tips>>, t: Throwable) {
                // Tangani kesalahan jika gagal terhubung ke server
            }
        })
    }

}
