package com.net.maganrendelok.activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.net.maganrendelok.R
import com.net.maganrendelok.models.Doctor
import com.net.maganrendelok.models.Surgery
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_surgerydetail.*
import kotlinx.android.synthetic.main.activity_surgerydetail.view.*

class SurgeryDetail : AppCompatActivity() {

    companion object {
        var NAME : String = "Név"
        var ADDRESS : String = ""
        var OPENING : String = ""
        var EMAIL : String = ""
        var INFO : String = ""
        var TEL : String = ""
        //var DOCTORS : ArrayList<Doctor> = ArrayList<Doctor>()

    fun newIntent(context: Context, surgery: Surgery): Intent {
        val detailIntent = Intent(context, SurgeryDetail::class.java)
        NAME = surgery.name
        ADDRESS = surgery.address
        OPENING = surgery.opening
        EMAIL = surgery.email
        INFO = surgery.info
        //DOCTORS = surgery.doctrors
        TEL = surgery.tel

        return detailIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surgerydetail)

        linearLayoutsurgerydetail.SurgeryNameDetail.text = NAME
        linearLayoutsurgerydetail.SurgeryAddressDetail.text = ADDRESS
        linearLayoutsurgerydetail.SurgeryEmailDetail.text = EMAIL
        linearLayoutsurgerydetail.SurgeryInfolDetail.text = INFO
        linearLayoutsurgerydetail.SurgeryTellDetail.text = TEL

        toolbarsurgerydetail.setNavigationOnClickListener {
            startActivity(Intent(this, Logged_screen::class.java))
        }

    }




}
