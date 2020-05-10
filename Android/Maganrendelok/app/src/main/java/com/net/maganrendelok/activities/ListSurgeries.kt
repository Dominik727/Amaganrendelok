package com.net.maganrendelok.activities

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.net.maganrendelok.R
import com.net.maganrendelok.api.SURGERYAPI
import com.net.maganrendelok.data.SurgeryAdapter
import com.net.maganrendelok.models.Surgery
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ListSurgeries : Fragment() {

    private lateinit var listView: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView: View = inflater.inflate(R.layout.activity_listsurgeries, container, false)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://maganrendelo.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val currencAPI = retrofit.create(SURGERYAPI::class.java)

        val registercall = currencAPI.GetSurgeries()

        registercall.enqueue(object : Callback<Array<Surgery>> {
            override fun onFailure(call: Call<Array<Surgery>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<Array<Surgery>>, response: Response<Array<Surgery>>) {
                if (response.isSuccessful) {
                    var surgeryList = ArrayList<Surgery>()

                    for (item in response.body()!!) {
                        surgeryList.add(item)
                    }
                    listView = (rootView.findViewById(R.id.surgery_list_view) as ListView)!!
                    var surgerylist = surgeryList.toMutableList()

                    var listItems = ArrayList<Surgery>()

                    for (i in 0 until surgerylist.size) {
                        listItems.add(surgerylist[i])
                    }
                    var adapter = SurgeryAdapter(this@ListSurgeries.context!!, listItems)
                    listView.adapter = adapter

                    var context: Context = this@ListSurgeries.context!!
                    listView.setOnItemClickListener { _, _, position, _ ->
                        // 1
                        var selectedSurgery = surgerylist[position]

                        // 2
                        var detailIntent = SurgeryDetail.newIntent(context, selectedSurgery)

                        // 3
                        startActivity(detailIntent)
                    }
                }
            }
        })
        return rootView;
    }
}