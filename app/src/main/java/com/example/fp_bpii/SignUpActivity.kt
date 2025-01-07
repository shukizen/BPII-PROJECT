package com.example.fp_bpii

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fp_bpii.client.RetrofitClient
import com.example.fp_bpii.response.users.RegisterResponse
import com.example.fp_bpii.response.users.RegisterRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    // Tag untuk log
    private val TAG = "SignUpActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btnRegister: Button = findViewById(R.id.button7)
        val txtEmail: EditText = findViewById(R.id.editTextText3)
        val txtUsername: EditText = findViewById(R.id.editTextText4)
        val txtPassword: EditText = findViewById(R.id.editTextText5)

        val btnSignIn: TextView = findViewById(R.id.button5)
        btnSignIn.setOnClickListener {
            // Navigasi ke LoginActivity
            Log.d(TAG, "Navigasi ke LoginActivity")
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btnRegister.setOnClickListener {
            // Ambil data dari input
            val email = txtEmail.text.toString().trim()
            val username = txtUsername.text.toString().trim()
            val password = txtPassword.text.toString().trim()

            Log.d(TAG, "Data input: email=$email, username=$username, password=$password")

            // Validasi input
            if (email.isEmpty() || username.isEmpty() || password.isEmpty()) {
                Log.w(TAG, "Validasi gagal: Ada kolom yang kosong")
                Toast.makeText(this, "Semua kolom harus diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.length < 8) {
                Toast.makeText(this, "Password harus memiliki minimal 8 karakter!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // Panggil API register
            Log.d(TAG, "Memulai proses register")
            registerUser(email, username, password)
        }
    }

    private fun registerUser(email: String, username: String, password: String) {
        // Buat request body
        val request = RegisterRequest(
            email = email,
            username = username,
            password = password
        )

        Log.d(TAG, "Request body: $request")

        // Panggil API menggunakan Retrofit
        RetrofitClient.instance.registerUser(email, username, password)
            .enqueue(object : Callback<RegisterResponse> {
                override fun onResponse(
                    call: Call<RegisterResponse>,
                    response: Response<RegisterResponse>
                ) {
                    if (response.isSuccessful) {
                        val registerResponse = response.body()
                        Log.d("SignUpActivity", "Sukses: ${registerResponse?.message}")
                        Toast.makeText(
                            this@SignUpActivity,
                            "Registrasi berhasil: ${registerResponse?.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        // Log detail error
                        val errorBody = response.errorBody()?.string()
                        Log.e("SignUpActivity", "Gagal: ${response.code()} - $errorBody")
                        Toast.makeText(
                            this@SignUpActivity,
                            "Gagal registrasi: ${response.message()}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    // Gagal menghubungi server
                    Toast.makeText(this@SignUpActivity, "Gagal: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
    }
}
