package com.example.fp_bpii
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fp_bpii.response.Tips
import com.squareup.picasso.Picasso

class AdapterPenjelasanTips(
    private val context: Context,
    private val listTips: List<Tips>
) : RecyclerView.Adapter<AdapterPenjelasanTips.PenjelasanTipsViewHolder>() {

    inner class PenjelasanTipsViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val gambarTips: ImageView = v.findViewById(R.id.gambarmental)
        val namaTips: TextView = v.findViewById(R.id.namatips)
        val deskripsiTips: TextView = v.findViewById(R.id.deskripsitips)

        fun bind(tip: Tips) {
            // Set data ke view
            namaTips.text = tip.nama_tips
            deskripsiTips.text = tip.penjelasan

            // Memuat gambar menggunakan Picasso
            val imageUrl = "http://192.168.0.108/rest_apibp2/gambar/${tip.gambar}"
            Picasso.get()
                .load(imageUrl)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_report_image)
                .into(gambarTips)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PenjelasanTipsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_penjelasantips, parent, false)
        return PenjelasanTipsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PenjelasanTipsViewHolder, position: Int) {
        holder.bind(listTips[position])
    }

    override fun getItemCount(): Int = listTips.size
}



