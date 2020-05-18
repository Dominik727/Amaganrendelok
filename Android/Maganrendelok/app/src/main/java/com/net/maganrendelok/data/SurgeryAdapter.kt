package com.net.maganrendelok.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.net.maganrendelok.R
import com.net.maganrendelok.models.Surgery

class SurgeryAdapter (private val context: Context,
                      private val dataSource: ArrayList<Surgery>) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //1
    override fun getCount(): Int {
        return dataSource.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val rowView = inflater.inflate(R.layout.list_item_surgery, parent, false)

        val titleTextView = rowView.findViewById(R.id.recipe_list_title) as TextView

        val subtitleTextView = rowView.findViewById(R.id.recipe_list_subtitle) as TextView

        //val detailTextView = rowView.findViewById(R.id.recipe_list_detail) as TextView

        val thumbnailImageView = rowView.findViewById(R.id.recipe_list_thumbnail) as ImageView

        val recipe = getItem(position) as Surgery

        titleTextView.text = recipe.name
        subtitleTextView.text = recipe.address
        //detailTextView.text = recipe.info
        thumbnailImageView.setImageResource(R.drawable.ic_launcher_foreground)

        return rowView
    }
}