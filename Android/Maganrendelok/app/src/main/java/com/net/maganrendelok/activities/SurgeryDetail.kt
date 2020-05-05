package com.net.maganrendelok.activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.net.maganrendelok.R
import com.net.maganrendelok.models.Surgery

class SurgeryDetail : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE = "name"


    fun newIntent(context: Context, surgery: Surgery): Intent {
            val detailIntent = Intent(context, SurgeryDetail::class.java)

            detailIntent.putExtra(EXTRA_TITLE, surgery.name)

            return detailIntent
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surgerydetail)
        


    }




}
