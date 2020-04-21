package simplifiedcoding.net.kotlinretrofittutorial.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.telecom.Call
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Callback
import retrofit2.Response
import simplifiedcoding.net.kotlinretrofittutorial.R
import simplifiedcoding.net.kotlinretrofittutorial.api.RetrofitClient
import simplifiedcoding.net.kotlinretrofittutorial.models.DefaultResponse
import simplifiedcoding.net.kotlinretrofittutorial.models.Patient
import simplifiedcoding.net.kotlinretrofittutorial.models.PatientDto
import simplifiedcoding.net.kotlinretrofittutorial.storage.SharedPrefManager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewLogin.setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        }


        buttonSignUp.setOnClickListener {

            val lastname = editLastname.text.toString().trim()
            val firstname = editFirstname.text.toString().trim()
            val email = editTextEmail.text.toString().trim()
            val tel = editTextTel.text.toString().trim()
            val taj = editTextTaj.text.toString().trim()
            val pass = editTextPassword.text.toString().trim()


            if(email.isEmpty()){
                editTextEmail.error = "Email required"
                editTextEmail.requestFocus()
                return@setOnClickListener
            }

            if(taj.isEmpty()){
                editTextEmail.error = "Email required"
                editTextEmail.requestFocus()
                return@setOnClickListener
            }

            if(tel.isEmpty()){
                editTextEmail.error = "Email required"
                editTextEmail.requestFocus()
                return@setOnClickListener
            }


            if(pass.isEmpty()){
                editTextPassword.error = "Password required"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }

            if(firstname.isEmpty()){
                editFirstname.error = "Name required"
                editFirstname.requestFocus()
                return@setOnClickListener
            }

            if(lastname.isEmpty()){
                editLastname.error = "Name required"
                editLastname.requestFocus()
                return@setOnClickListener
            }

            if(taj.isEmpty()){
                editTextTaj.error = "School required"
                editTextTaj.requestFocus()
                return@setOnClickListener
            }

            val user : PatientDto = PatientDto(
                    editFirstname.text.toString(),
                    editLastname.text.toString(),
                    editTextEmail.text.toString(),
                    editTextTel.text.toString(),
                    editTextTaj.text.toString(),
                    editTextPassword.text.toString()
            )

            RetrofitClient.instance.createUser(user)
                    .enqueue(object : Callback<PatientDto> {
                        override fun onFailure(call: retrofit2.Call<PatientDto>, t: Throwable) {
                            TODO("Not yet implemented")
                        }

                        override fun onResponse(call: retrofit2.Call<PatientDto>, response: Response<PatientDto>) {
                            TODO("Not yet implemented")
                        }

                    })

        }
    }

    override fun onStart() {
        super.onStart()

        if(SharedPrefManager.getInstance(this).isLoggedIn){
            val intent = Intent(applicationContext, ProfileActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
        }
    }

}

