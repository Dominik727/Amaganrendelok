package com.example.amaganrendelok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_btn.setOnClickListener {
            var status = if (username_et.text.toString().equals("test")
                && passwd_et.text.toString().equals("test")
            ) "Bejelentkezés sikeres" else "Bejelentkezés sikertelen"
            Toast.makeText(this, status, Toast.LENGTH_SHORT).show()
        }
        registration_pg_btn.setOnClickListener {
            ShowRegistration()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_about) {
            showInfo()
        }
        return true
    }

    private fun showInfo(){

    }

    private fun ShowRegistration() {
        mainmenu_login.visibility= View.GONE
        registration_layout.visibility=View.VISIBLE
    }
}
