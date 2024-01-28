package com.demo.facemeai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {

    private lateinit var apiService: ApiService
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        apiService = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        emailEditText = findViewById(R.id.etEmail)
        passwordEditText = findViewById(R.id.etPw)

        val loginButton: Button = findViewById(R.id.btnLogin)
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            login(email, password)
        }

//        val email = "eve.holt@reqres.in"
//        val password = "cityslicka"
//        login(email, password)




    }
    private fun login(email: String, password: String) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = apiService.login(LoginRequest(email, password))
                withContext(Dispatchers.Main) {
                    handleLoginResponse(response)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@LoginActivity, "Login failed: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun handleLoginResponse(response: Response<LoginResponse>) {
        if (response.isSuccessful) {
            val token = response.body()?.token
            Toast.makeText(this, "Login successful: $token", Toast.LENGTH_SHORT).show()
            // Start the next activity
        } else {
            Toast.makeText(this, "Login failed: ${response.code()}", Toast.LENGTH_SHORT).show()
        }
    }

}