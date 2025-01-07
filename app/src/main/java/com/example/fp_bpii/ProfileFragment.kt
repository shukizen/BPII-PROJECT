package com.example.fp_bpii

import FaqActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ProfileFragment : Fragment() {

    private lateinit var sharedPreferencesUser: SharedPreferencesUser

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        sharedPreferencesUser = SharedPreferencesUser(requireContext())

        val userName = sharedPreferencesUser.getUserName()
        val txtWelcome: TextView = view.findViewById(R.id.name)
        txtWelcome.text = "$userName"

        val userPassword = sharedPreferencesUser.getUserPassword()
        Log.d("ProfileFragment", "Password yang diambil: $userPassword")
        val txtpwd: TextView = view.findViewById(R.id.pwd)
        txtpwd.text = "$userPassword"

        val userEmail = sharedPreferencesUser.getUserEmail()
        val txtemail: TextView = view.findViewById(R.id.email)
        txtemail.text = "$userEmail"

        val btnLogout: Button = view.findViewById(R.id.button19)
        btnLogout.setOnClickListener {
            sharedPreferencesUser.logout()
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        return view

        }

}

