package com.example.fp_bpii
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.fp_bpii.client.RetrofitClient
import com.example.fp_bpii.response.users.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var sharedPreferencesManager: SharedPreferencesUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferencesManager = SharedPreferencesUser(this)

        val txtUsername: EditText = findViewById(R.id.editTextText)
        val txtPassword: EditText = findViewById(R.id.editTextText2)
        val btnLogin: Button = findViewById(R.id.button4)
        val btnSignup: TextView = findViewById(R.id.button3)
        val btnreset: TextView = findViewById(R.id.forgotPassword)

        btnLogin.setOnClickListener {
            val user = txtUsername.text.toString().trim()
            val pwd = txtPassword.text.toString().trim()

            if (user.isEmpty()) {
                txtUsername.error = "Username required"
                txtUsername.requestFocus()
                return@setOnClickListener
            }

            if (pwd.isEmpty()) {
                txtPassword.error = "Password required"
                txtPassword.requestFocus()
                return@setOnClickListener
            }

            RetrofitClient.instance.login(user, pwd).enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    Log.d("LoginActivity", "Response code: ${response.code()}")
                    val account = response.body()

                    if (response.isSuccessful && account?.success == true) {
                        val email = account.data?.email // Ambil email dari respons
                        if (email != null) {
                            sharedPreferencesManager.saveUser(user, true)
                            sharedPreferencesManager.savePwd(pwd, true)
                            sharedPreferencesManager.saveEmail(email, true) // Simpan email ke SharedPreferences
                        }

                        Toast.makeText(this@LoginActivity, account.message.toString(), Toast.LENGTH_SHORT).show()
                        val intentLogin = Intent(this@LoginActivity, HomeActivity::class.java)
                        startActivity(intentLogin)
                    } else {
                        Toast.makeText(this@LoginActivity, account?.message ?: "Login failed", Toast.LENGTH_SHORT).show()
                    }
                }


                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.e("LoginActivity", "API call failed", t)
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                }
            })
        }

        btnreset.setOnClickListener {
            val reset = Intent(this,ResetPasswordActivity::class.java)
            startActivity(reset)
        }



        btnSignup.setOnClickListener {
            val intentSignup = Intent(this, SignUpActivity::class.java)
            startActivity(intentSignup)
        }



    }
}