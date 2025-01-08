package com.example.fp_bpii

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fp_bpii.client.RetrofitClient
import com.example.fp_bpii.response.users.ResetPasswordResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResetPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etNewPassword = findViewById<EditText>(R.id.etNewPassword)
        val etConfirmPassword = findViewById<EditText>(R.id.etConfirmPassword)
        val btnSend = findViewById<Button>(R.id.btnSend)

        btnSend.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val newPassword = etNewPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()

            if (validateInput(email, newPassword, confirmPassword)) {
                resetPassword(email, newPassword, confirmPassword)
            }
        }
    }

    private fun validateInput(email: String, newPassword: String, confirmPassword: String): Boolean {
        if (email.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Semua kolom harus diisi", Toast.LENGTH_SHORT).show()
            return false
        }

        if (newPassword != confirmPassword) {
            Toast.makeText(this, "Password tidak cocok", Toast.LENGTH_SHORT).show()
            return false
        }

        if (newPassword.length < 6) {
            Toast.makeText(this, "Password harus terdiri dari minimal 6 karakter", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun resetPassword(email: String, newPassword: String, confirmPassword: String) {
        val call = RetrofitClient.instance.resetPassword(email, newPassword, confirmPassword)

        call.enqueue(object : Callback<ResetPasswordResponse> {
            override fun onResponse(call: Call<ResetPasswordResponse>, response: Response<ResetPasswordResponse>) {
                // Logging respons untuk debugging
                Log.d("ResetPasswordActivity", "Response: ${response.body()}")

                if (response.isSuccessful) {
                    val resetResponse = response.body()
                    if (resetResponse != null && resetResponse.success) {
                        // Berhasil mengubah password
                        Toast.makeText(this@ResetPasswordActivity, "Password berhasil diubah.", Toast.LENGTH_SHORT).show()
                        // Lakukan tindakan lain, seperti menuju halaman login
                    } else {
                        // Gagal mengubah password, tampilkan pesan kesalahan
                        val message = resetResponse?.message ?: "Gagal mengubah password."
                        Toast.makeText(this@ResetPasswordActivity, message, Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // Jika respons tidak berhasil, tampilkan pesan error
                    val errorBody = response.errorBody()?.string() ?: "Terjadi kesalahan saat memproses permintaan"
                    Log.e("ResetPasswordActivity", "Response Error: $errorBody")
                    Toast.makeText(this@ResetPasswordActivity, "Error: ${response.code()} - ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResetPasswordResponse>, t: Throwable) {
                // Menangani kesalahan jika permintaan gagal (misal, koneksi internet putus)
                Log.e("ResetPasswordActivity", "Failure: ${t.message}")
                Toast.makeText(this@ResetPasswordActivity, "Terjadi kesalahan: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

