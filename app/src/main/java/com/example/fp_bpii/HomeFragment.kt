package com.example.fp_bpii



import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class HomeFragment : Fragment() {
    private lateinit var sharedPreferencesUser: SharedPreferencesUser

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Inisialisasi SharedPreferencesUser
        sharedPreferencesUser = SharedPreferencesUser(requireContext())

        // Dapatkan nama pengguna dari SharedPreferences
        val userName = sharedPreferencesUser.getUserName()
        val txtWelcome: TextView = view.findViewById(R.id.textView3)
        txtWelcome.text = "Hallo, $userName"


        val popup: ImageView = view.findViewById(R.id.popupsmile)
        popup.setOnClickListener{
            val intent = Intent(requireContext(), PopupActivity::class.java)
            startActivity(intent)
        }

        val tips: LinearLayout = view.findViewById(R.id.Tips)
        tips.setOnClickListener{
            val intent = Intent(requireContext(), TipsActivity::class.java)
            startActivity(intent)
        }

        val chatbot: LinearLayout = view.findViewById(R.id.chatbot)
        chatbot.setOnClickListener{
            val intent = Intent(requireContext(), ChatActivity::class.java)
            startActivity(intent)
        }

        val pengingat: LinearLayout = view.findViewById(R.id.pengingatharian)
        pengingat.setOnClickListener{
            val intent = Intent(requireContext(), PengingatHarianActivity::class.java)
            startActivity(intent)
        }

        val mental: LinearLayout = view.findViewById(R.id.Mental)
        mental.setOnClickListener{
            val intent = Intent(requireContext(), PenyakitActivity::class.java)
            startActivity(intent)
        }


        return view
    }


}
