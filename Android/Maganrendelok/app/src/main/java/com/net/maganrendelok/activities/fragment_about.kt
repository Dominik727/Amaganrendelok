package com.net.maganrendelok.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.net.maganrendelok.BuildConfig
import com.net.maganrendelok.R
import kotlinx.android.synthetic.main.activity_fragment_about.*


class fragment_about : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView: View = inflater.inflate(R.layout.activity_fragment_about, container, false)

        val versionCode = BuildConfig.VERSION_CODE
        val versionName = BuildConfig.VERSION_NAME

        versionid.text = versionCode.toString()
        versionidname.text = versionName

        return rootView


    }
}
