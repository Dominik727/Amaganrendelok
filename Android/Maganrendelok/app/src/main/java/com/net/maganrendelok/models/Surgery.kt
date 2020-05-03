package com.net.maganrendelok.models

data class Surgery (
        var id: String,
        var name: String,
        var address: String,
        var opening: String,
        var email: String,
        var tel: String,
        var info: String,
        var map: String,
        var doctrors: List<String>
)