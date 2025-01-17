package com.example.fp_bpii

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fp_bpii.client.RetrofitClient
import com.example.fp_bpii.response.Tips
import com.squareup.picasso.Picasso

class AdapterTips(
    private val context: Context,
    private val listTips: List<Tips>,
    private val onItemClick: (Tips) -> Unit // Listener untuk klik item
) : RecyclerView.Adapter<AdapterTips.TipsViewHolder>() {

    inner class TipsViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val gambarTips: ImageView = v.findViewById(R.id.gambarmental)
        val namaTips: TextView = v.findViewById(R.id.namatips)


        fun bind(tip: Tips) {
            namaTips.text = tip.nama_tips

            // Perbaikan URL gambar
            val imageUrl = "http://10.200.137.42/rest_apibp2/gambar/${tip.gambar}"

            // Log URL gambar untuk debugging
            Log.d("AdapterTips", "Loading image from URL: $imageUrl ")


            Picasso.get()
                .load(imageUrl)
                .placeholder(android.R.drawable.ic_menu_gallery)  // Placeholder while loading
                .error(android.R.drawable.ic_menu_report_image)  // Error image if loading fails
                .into(gambarTips)  // Pastikan gambar di load ke ImageView yang benar

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false)
        return TipsViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipsViewHolder, position: Int) {
        // Bind data ke view holder
        holder.bind(listTips[position])

        // Handle item click
        holder.itemView.setOnClickListener {
            onItemClick(listTips[position]) // Trigger listener saat item di klik
        }
    }

    override fun getItemCount(): Int = listTips.size
}