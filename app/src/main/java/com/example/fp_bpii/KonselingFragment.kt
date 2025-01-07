package com.example.fp_bpii

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class KonselingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_konseling, container, false)

        val btnKonseling: Button = view.findViewById(R.id.buttonClickHere1)
        btnKonseling.setOnClickListener {
            val intent = Intent(requireContext(), KonsultasiActivity::class.java)
            startActivity(intent)
        }
        return  view
    }
}