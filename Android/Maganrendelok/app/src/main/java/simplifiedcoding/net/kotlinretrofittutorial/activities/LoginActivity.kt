package simplifiedcoding.net.kotlinretrofittutorial.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import simplifiedcoding.net.kotlinretrofittutorial.R
import simplifiedcoding.net.kotlinretrofittutorial.api.LOGINAPI
import simplifiedcoding.net.kotlinretrofittutorial.api.REGISTERAPI
import simplifiedcoding.net.kotlinretrofittutorial.models.PatientLogin

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://maganrendelo.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()




        buttonLogin.setOnClickListener {

            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            if(email.isEmpty()){
                editTextEmail.error = "Email required"
                editTextEmail.requestFocus()
                return@setOnClickListener
            }


            if(password.isEmpty()){
                editTextPassword.error = "Password required"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }


            startActivity(Intent(this@LoginActivity, ProfileActivity::class.java))

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
