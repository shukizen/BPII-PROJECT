package com.example.fp_bpii

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fp_bpii.response.users.Penyakit
import com.squareup.picasso.Picasso

class AdapterPenyakit(
    private val context: Context,
    private val listPenyakit: List<Penyakit>,
    private val onItemClick: (Penyakit) -> Unit
) : RecyclerView.Adapter<AdapterPenyakit.PenyakitViewHolder>() {

    inner class PenyakitViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val gambarPenyakit: ImageView = view.findViewById(R.id.gambarpenyakit)
        val namapenyakit: TextView = view.findViewById(R.id.namapenyakit)

        fun bind(penyakit: Penyakit) {
            namapenyakit.text = penyakit.jenis_penyakit


            // Log URL gambar untuk debugging


            val imageUrl = "http://10.200.137.42/rest_apibp2/penyakit/${penyakit.gambar}"

            Log.d("AdapterTips", "Loading image from URL: $imageUrl ")

            Picasso.get()
                .load(imageUrl)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_report_image)
                .into(gambarPenyakit)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PenyakitViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_card2, parent, false)
        return PenyakitViewHolder(view)
    }

    override fun onBindViewHolder(holder: PenyakitViewHolder, position: Int) {
        holder.bind(listPenyakit[position])
        holder.itemView.setOnClickListener { onItemClick(listPenyakit[position]) }
    }

    override fun getItemCount(): Int = listPenyakit.size
}
