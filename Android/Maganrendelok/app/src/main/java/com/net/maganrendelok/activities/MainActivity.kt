package com.net.maganrendelok.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.*
import com.net.maganrendelok.R
import com.net.maganrendelok.api.REGISTERAPI
import com.net.maganrendelok.data.PasswordStrength
import com.net.maganrendelok.models.PatientDto
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity(), TextWatcher {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pass = findViewById<EditText>(R.id.editTextPassword) as EditText
        pass.addTextChangedListener(this)

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

            if(!"^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})\$".toRegex().matches(email)) {
                editTextEmail.error = "Kérem érvényes email címet adjon meg!"
                editTextEmail.requestFocus()
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

            if (!findViewById<CheckBox>(R.id.editcheckBox).isChecked) {
                editcheckBox.error = "Kötelező elfogadni!"
                editcheckBox.requestFocus()
                return@setOnClickListener
            }

            waiting.visibility = View.VISIBLE
            disableAllEditText(false)

            val user = PatientDto(
                    editLastname.text.toString(),
                    editFirstname.text.toString(),
                    editTextEmail.text.toString(),
                    editTextTel.text.toString(),
                    editTextTaj.text.toString(),
                    editTextPassword.text.toString()
            )

            var attempt = 0

            val registercall = currencAPI.PostRegistration(user)

                registercall.enqueue(object : Callback<PatientDto>{

                    override fun onFailure(call: Call<PatientDto>, t: Throwable) {
                        if (attempt > 3) {
                            Thread.sleep(1_000)
                            Toast.makeText(applicationContext, "Hiba történt, próbája újra!", Toast.LENGTH_SHORT).show()
                            disableAllEditText(true)
                            waiting.visibility = View.INVISIBLE
                        }
                        attempt += 1
                        registercall.clone().enqueue(this)
                    }

                    override fun onResponse(call: Call<PatientDto>, response: Response<PatientDto>) {
                        Thread.sleep(1_000)
                        Toast.makeText(applicationContext, "A fiók regisztráció sikeres volt", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                        disableAllEditText(true)
                        waiting.visibility = View.INVISIBLE
                    }

                })
            


        }
    }

    override fun afterTextChanged(s: Editable) {}

    override fun beforeTextChanged(
            s: CharSequence, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        updatePasswordStrengthView(s.toString())
    }

    private fun updatePasswordStrengthView(pass: String) {

        val progressBar = findViewById<ProgressBar>(R.id.progressBar) as ProgressBar
        val strengthView = findViewById<ProgressBar>(R.id.password_strength) as TextView
        if (TextView.VISIBLE != strengthView.visibility)
            return

        if (TextUtils.isEmpty(pass)) {
            strengthView.text = ""
            progressBar.progress = 0
            return
        }

        val str = PasswordStrength.calculateStrength(pass)
        strengthView.text = str.getText(this)
        strengthView.setTextColor(str.color)

        progressBar.progressDrawable.setColorFilter(str.color, android.graphics.PorterDuff.Mode.SRC_IN)
        if (str.getText(this) == "Weak") {
            progressBar.progress = 25
        } else if (str.getText(this) == "Medium") {
            progressBar.progress = 50
        } else if (str.getText(this) == "Strong") {
            progressBar.progress = 75
        } else {
            progressBar.progress = 100
        }
    }

    private fun disableAllEditText(status: Boolean) {

        buttonSignUp.isEnabled = status
        val edit = findViewById<View>(R.id.registration) as RelativeLayout
        for (view in edit.touchables) {
            if (view is EditText || view is CheckBox) {
                val editText = view
                editText.isEnabled = status
                editText.isFocusable = status
                editText.isFocusableInTouchMode = status
            }
        }
    }
}


