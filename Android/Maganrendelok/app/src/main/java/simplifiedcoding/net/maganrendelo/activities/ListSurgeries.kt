package simplifiedcoding.net.maganrendelo.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import simplifiedcoding.net.maganrendelo.api.SURGERYAPI
import simplifiedcoding.net.maganrendelo.models.Surgery
import simplifiedcoding.net.kotlinretrofittutorial.R

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
                    listView = findViewById<ListView>(R.id.recipe_list_view)
                    val recipeList = surgeryList.toMutableList()

                    val listItems = arrayOfNulls<String>(recipeList.size)
// 3
                    for (i in 0 until recipeList.size) {
                        val recipe = recipeList[i]
                        listItems[i] = recipe.name
                    }
// 4
                    val adapter = ArrayAdapter(this@ListSurgeries, android.R.layout.simple_list_item_1, listItems)
                    listView.adapter = adapter


                }
            }

        })


    }
}