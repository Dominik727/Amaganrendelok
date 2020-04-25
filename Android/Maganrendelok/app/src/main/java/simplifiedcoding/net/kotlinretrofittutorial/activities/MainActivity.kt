package simplifiedcoding.net.kotlinretrofittutorial.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import simplifiedcoding.net.kotlinretrofittutorial.R
import simplifiedcoding.net.kotlinretrofittutorial.api.LOGINAPI
import simplifiedcoding.net.kotlinretrofittutorial.api.REGISTERAPI
import simplifiedcoding.net.kotlinretrofittutorial.models.PatientDto


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewLogin.setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        }

        val retrofit = Retrofit.Builder()
                .baseUrl("https://maganrendelo.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val currencAPI = retrofit.create(REGISTERAPI::class.java)


        buttonSignUp.setOnClickListener {

            val lastname = editLastname.text.toString().trim()
            val firstname = editFirstname.text.toString().trim()
            val email = editTextEmail.text.toString().trim()
            val tel = editTextTel.text.toString().trim()
            val taj = editTextTaj.text.toString().trim()
            val pass = editTextPassword.text.toString().trim()


            if (email.isEmpty()) {
                editTextEmail.error = "Email required"
                editTextEmail.requestFocus()
                return@setOnClickListener
            }

            if (taj.isEmpty()) {
                editTextEmail.error = "Email required"
                editTextEmail.requestFocus()
                return@setOnClickListener
            }

            if (tel.isEmpty()) {
                editTextTel.error = "Email required"
                editTextTel.requestFocus()
                return@setOnClickListener
            }


            if (pass.isEmpty()) {
                editTextPassword.error = "Password required"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }

            if (firstname.isEmpty()) {
                editFirstname.error = "Name required"
                editFirstname.requestFocus()
                return@setOnClickListener
            }

            if (lastname.isEmpty()) {
                editLastname.error = "Name required"
                editLastname.requestFocus()
                return@setOnClickListener
            }

            if (taj.isEmpty()) {
                editTextTaj.error = "School required"
                editTextTaj.requestFocus()
                return@setOnClickListener
            }

            val user = PatientDto(
                    editLastname.text.toString(),
                    editFirstname.text.toString(),
                    editTextEmail.text.toString(),
                    editTextTel.text.toString(),
                    editTextTaj.text.toString(),
                    editTextPassword.text.toString()
            )

            val registercall = currencAPI.PostRegistration(user)
            
            registercall.enqueue(object : Callback<PatientDto>{


                override fun onFailure(call: Call<PatientDto>, t: Throwable) {
                    Toast.makeText(applicationContext, "passz", Toast.LENGTH_SHORT)
                }

                override fun onResponse(call: Call<PatientDto>, response: Response<PatientDto>) {
                    Toast.makeText(applicationContext, "passz", Toast.LENGTH_SHORT)
                }

            })
            
            Toast.makeText(applicationContext, "passz", Toast.LENGTH_SHORT)

        }
    }

}


