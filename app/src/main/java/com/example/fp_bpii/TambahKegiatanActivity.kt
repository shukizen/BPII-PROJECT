package com.example.fp_bpii;

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fp_bpii.databinding.ActivityTambahKegiatanBinding
import java.util.*

class TambahKegiatanActivity : AppCompatActivity() {

    // Binding untuk menghubungkan XML dengan kode
    private lateinit var binding: ActivityTambahKegiatanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahKegiatanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tombol kembali
        binding.ivBack.setOnClickListener {
            finish() // Menutup aktivitas dan kembali ke halaman sebelumnya
        }

        // Mengisi data untuk spinner (Jenis Kegiatan)
        val jenisKegiatan = arrayOf("Kerja", "Belajar", "Olahraga", "Lainnya")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, jenisKegiatan)
        binding.spJenisKegiatan.adapter = adapter

        // Event klik untuk memilih tanggal
        binding.etTanggal.setOnClickListener {
            val calendar = Calendar.getInstance()
            DatePickerDialog(this, { _, year, month, dayOfMonth ->
                val tanggal = String.format("%02d-%02d-%04d", dayOfMonth, month + 1, year)
                binding.etTanggal.setText(tanggal)
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        // Event klik untuk memilih waktu
        binding.etWaktu.setOnClickListener {
            val calendar = Calendar.getInstance()
            TimePickerDialog(this, { _, hourOfDay, minute ->
                val waktu = String.format("%02d:%02d", hourOfDay, minute)
                binding.etWaktu.setText(waktu)
            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show()
        }

        // Event klik untuk menambahkan pengingat waktu
        binding.etPengingat.setOnClickListener {
            val calendar = Calendar.getInstance()
            TimePickerDialog(this, { _, hourOfDay, minute ->
                val pengingat = String.format("%02d:%02d", hourOfDay, minute)
                binding.etPengingat.setText(pengingat)
            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show()
        }

        // Tombol untuk menyelesaikan input kegiatan
        binding.btnSelesai.setOnClickListener {
            val namaKegiatan = binding.etNamaKegiatan.text.toString()
            val jenisKegiatan = binding.spJenisKegiatan.selectedItem.toString()
            val tanggal = binding.etTanggal.text.toString()
            val waktu = binding.etWaktu.text.toString()
            val pengingat = binding.etPengingat.text.toString()

            if (namaKegiatan.isEmpty()) {
                Toast.makeText(this, "Nama kegiatan tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            } else if (tanggal.isEmpty() || waktu.isEmpty()) {
                Toast.makeText(this, "Tanggal dan waktu harus diisi!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Kegiatan berhasil disimpan!", Toast.LENGTH_SHORT).show()
                // Anda bisa menyimpan data ke database atau intent
                finish()
            }
        }
    }
}
