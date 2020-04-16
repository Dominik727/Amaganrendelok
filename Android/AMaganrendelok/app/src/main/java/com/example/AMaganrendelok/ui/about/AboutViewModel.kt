package com.example.AMaganrendelok.ui.surgery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Rólunk"
    }
    val text: LiveData<String> = _text
}