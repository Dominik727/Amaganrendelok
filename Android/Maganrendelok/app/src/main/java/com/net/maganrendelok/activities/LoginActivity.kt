package com.net.maganrendelok.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.net.maganrendelok.R
import kotlinx.android.synthetic.main.activity_login.editTextEmail
import kotlinx.android.synthetic.main.activity_login.editTextPassword
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        textViewRegister.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        toolbar2.setNavigationOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        val retrofit = Retrofit.Builder()
                .baseUrl("https://maganrendelo.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        buttonLogin.setOnClickListener {

            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            if(email.isEmpty()){
                editTextEmail.error = "Email megadása kötelező"
                editTextEmail.requestFocus()
                return@setOnClickListener
            }


            if(password.isEmpty()){
                editTextPassword.error = "Jelszó megadása kötelező"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }

            if(!"^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})\$".toRegex().matches(email)) {
                editTextEmail.error = "Kérem érvényes email címet adjon meg!"
                editTextEmail.requestFocus()
                return@setOnClickListener
            }


            startActivity(Intent(this@LoginActivity, Logged_screen::class.java))

            /*val user = PatientLogin(email, password)

            val currencAPI = retrofit.create(LOGINAPI::class.java)

            val registercall = currencAPI.GetLogin(user)

            registercall.enqueue(object : Callback<PatientLogin> {
                override fun onFailure(call: Call<PatientLogin>, t: Throwable) {
                    Toast.makeText(applicationContext, "passz", Toast.LENGTH_SHORT)
                }

                override fun onResponse(call: Call<PatientLogin>, response: Response<PatientLogin>) {
                    Toast.makeText(applicationContext, "passz", Toast.LENGTH_SHORT)
                }

            })*/

        }
    }

}
