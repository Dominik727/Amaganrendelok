package simplifiedcoding.net.maganrendelo.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import simplifiedcoding.net.kotlinretrofittutorial.R
import simplifiedcoding.net.maganrendelo.api.REGISTERAPI
import simplifiedcoding.net.maganrendelo.models.PatientDto
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {

    private val PASSWORD_PATTERN: Pattern = Pattern.compile(
            "^" +  //"(?=.*[0-9])" +         //at least 1 digit
            //"(?=.*[a-z])" +         //at least 1 lower case letter
            //"(?=.*[A-Z])" +         //at least 1 upper case letter
            "(?=\\S+$)" +  //no white spaces
            ".{4,}" +  //at least 4 characters
            "$")

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
                editTextEmail.error = "Email megadása kötelező"
                editTextEmail.requestFocus()
                return@setOnClickListener
            }

            if (taj.isEmpty()) {
                editTextEmail.error = "Tajszám megadása kötelező"
                editTextEmail.requestFocus()
                return@setOnClickListener
            }

            if (tel.isEmpty()) {
                editTextTel.error = "Telefonszám megadása kötelező"
                editTextTel.requestFocus()
                return@setOnClickListener
            }


            if (pass.isEmpty()) {
                editTextPassword.error = "Jelszó megadása kötelező"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }

            if (!"[a-zA-ZşŞÇçÖöüÜıIiİĞğ]+".toRegex().containsMatchIn(pass)) {  //any letter
                editTextPassword.error = "Tartalmaznia kell betűt"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }

            if (!"[^0-9]".toRegex().containsMatchIn(pass)) {  //any letter
                editTextPassword.error = "Tartalmaznia kell számot is"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }

            if (!"[!@#\$%^&*(),.?\":{}|<>]".toRegex().containsMatchIn(pass)) {  //at least 1 special character
                editTextPassword.error = "Speciális karaktert kell tartalmaznia! pl. @ , !"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }

            if ("[-\\s]".toRegex().containsMatchIn(pass)) {  //no white spaces
                editTextPassword.error = "Nem tartalmazhat szóközt"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }

            if (pass.length < 6 || pass.length > 12) {  //letter number
                editTextPassword.error = "Legalább 6, de legfeljebb 12 karakterből kell állnia"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }

            if (firstname.isEmpty()) {
                editFirstname.error = "Keresztnév megadása kötelező"
                editFirstname.requestFocus()
                return@setOnClickListener
            }

            if (lastname.isEmpty()) {
                editLastname.error = "Vezetéknév megadása kötelező"
                editLastname.requestFocus()
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
                    Toast.makeText(applicationContext, "Hiba történt, próbája újra!", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<PatientDto>, response: Response<PatientDto>) {
                    Toast.makeText(applicationContext, "A fiók regisztráció sikeres volt", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                }

            })

        }
    }

}


