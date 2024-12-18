package com.example.fp_bpii

import android.content.Intent
import android.net.DnsResolver
import android.net.DnsResolver.Callback
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fp_bpii.client.RetrofitClient
import com.example.fp_bpii.response.users.LoginResponse
import okhttp3.Response
import retrofit2.Call


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val txtUsername : EditText = findViewById(R.id.editTextText)
        val txtPassword : EditText = findViewById(R.id.editTextText2)
        val btnLogin : Button = findViewById(R.id.button4)

        btnLogin.setOnClickListener {
            var user = txtUsername.text.toString().trim()
            var pwd = txtPassword.text.toString().trim()

        if(user.isEmpty()){
            txtUsername.error = "Email required"
            txtPassword.requestFocus()
            return@setOnClickListener
        }
        if(pwd.isEmpty()) {
            txtPassword.error = "Password required"
            txtPassword.requestFocus()
            return@setOnClickListener
        }

         RetrofitClient.instance.postLogin(user, pwd).enqueue(
             object  : Callback<LoginResponse>{
                 override fun onResponse(
                     cal : Call<LoginResponse>,
                     response: Response<LoginResponse>
                 ) {
                     val account = response.body()
                     if (account?.success == true){
                         Toast.makeText(this@LoginActivity,
                             account?.message.toString(), Toast.LENGTH_SHORT).show()
                         val intentLogin = Intent(this@LoginActivity,
                            HomeActivity::class.java)
                         startActivity(intentLogin)
                     } else {
                         Toast.makeText(this@LoginActivity,
                             account?.message.toString(), Toast.LENGTH_SHORT).show()
                     }
                 }

                 override fun onFailure(call : Call<LoginResponse>, t : Throwable) {
                     Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                 }
             }
         )
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

}
