package com.net.maganrendelok.activities

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.net.maganrendelok.api.SURGERYAPI
import com.net.maganrendelok.models.Surgery
import com.net.maganrendelok.R
import com.net.maganrendelok.data.SurgeryAdapter

class ListSurgeries : AppCompatActivity() {

    private lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listsurgeries)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://maganrendelo.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val currencAPI = retrofit.create(SURGERYAPI::class.java)

        val registercall = currencAPI.GetSurgeries()

        registercall.enqueue(object : Callback<Array<Surgery>>{
            override fun onFailure(call: Call<Array<Surgery>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<Array<Surgery>>, response: Response<Array<Surgery>>) {
                if (response.isSuccessful) {
                    var surgeryList = ArrayList<Surgery>()

                    for (item in response.body()!!) {
                        surgeryList.add(item)
                    }
                    listView = findViewById<ListView>(R.id.surgery_list_view)
                    val surgerylist = surgeryList.toMutableList()

                    val listItems = ArrayList<Surgery>()
// 3
                    for (i in 0 until surgerylist.size) {
                        listItems.add(surgerylist[i])
                    }
                    val adapter = SurgeryAdapter(this@ListSurgeries, listItems)
                    listView.adapter = adapter

                    val context : Context = this@ListSurgeries
                    listView.setOnItemClickListener { _, _, position, _ ->
                        // 1
                        val selectedSurgery = surgerylist[position]

                        // 2
                        val detailIntent = SurgeryDetail.newIntent(context, selectedSurgery)

                        // 3
                        startActivity(detailIntent)
                    }
                }


            }




        })


    }


}