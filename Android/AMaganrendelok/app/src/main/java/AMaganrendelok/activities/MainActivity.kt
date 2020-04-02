package AMaganrendelok.activities

import AMaganrendelok.R
import AMaganrendelok.api.RetrofitClient
import AMaganrendelok.models.DefaultResponse
import AMaganrendelok.storage.SharedPrefManager
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewLogin.setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        }


        buttonSignUp.setOnClickListener {

            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()
            val firstname = editTextFirstname.text.toString().trim()
            val lastname = editTextLastname.text.toString().trim()
            val tel = editTextTel.text.toString().trim()
            val TAJ = editTextTAJ.text.toString().trim()


            if(email.isEmpty()){
                editTextEmail.error = "email megadása kötelező"
                editTextEmail.requestFocus()
                return@setOnClickListener
            }


            if(password.isEmpty()){
                editTextPassword.error = "jelszó megadása kötelező"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }

            if(firstname.isEmpty()){
                editTextFirstname.error = "Keresztnév megadása kötelező"
                editTextFirstname.requestFocus()
                return@setOnClickListener
            }

            if(tel.isEmpty()){
                editTextFirstname.error = "Keresztnév megadása kötelező"
                editTextFirstname.requestFocus()
                return@setOnClickListener
            }

            if(lastname.isEmpty()){
                editTextLastname.error = "Vezetéknév megadása kötelező"
                editTextLastname.requestFocus()
                return@setOnClickListener
            }

            if(TAJ.isEmpty()){
                editTextTAJ.error = "TAJ megadása kötelező"
                editTextTAJ.requestFocus()
                return@setOnClickListener
            }


            RetrofitClient.instance.createUser(firstname, lastname, tel,  email, password, TAJ)
                    .enqueue(object: Callback<DefaultResponse>{
                        override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                            Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                        }

                        override fun onResponse(call: Call<DefaultResponse>, response: Response<DefaultResponse>) {
                            Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()
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
