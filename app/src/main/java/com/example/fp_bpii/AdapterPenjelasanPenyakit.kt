package com.example.fp_bpii
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fp_bpii.R
import com.example.fp_bpii.response.users.Penyakit
import com.squareup.picasso.Picasso

class AdapterPenjelasanPenyakit(
    private val context: Context,
    private val listPenyakit: List<Penyakit>,
    private val onItemClick: (Penyakit) -> Unit
) : RecyclerView.Adapter<AdapterPenjelasanPenyakit.PenjelasanPenyakitViewHolder>() {

    inner class PenjelasanPenyakitViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val gambarPenyakit: ImageView = view.findViewById(R.id.logopenyakit)
        val jenisPenyakit: TextView = view.findViewById(R.id.jenispenyakit)

        fun bind(penyakit: Penyakit) {
            jenisPenyakit.text = penyakit.jenis_penyakit

            val imageUrl = "http://192.168.0.108/rest_apibp2/penyakit/${penyakit.gambar}"
            Picasso.get()
                .load(imageUrl)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_report_image)
                .into(gambarPenyakit)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PenjelasanPenyakitViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_penjelasanpenyakit, parent, false)
        return PenjelasanPenyakitViewHolder(view)
    }

    override fun onBindViewHolder(holder: PenjelasanPenyakitViewHolder, position: Int) {
        holder.bind(listPenyakit[position])
        holder.itemView.setOnClickListener { onItemClick(listPenyakit[position]) }
    }

    override fun getItemCount(): Int = listPenyakit.size
}
