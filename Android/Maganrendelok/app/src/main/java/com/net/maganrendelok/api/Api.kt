package com.net.maganrendelok.api

import retrofit2.Call
import retrofit2.http.*
import com.net.maganrendelok.models.PatientDto
import com.net.maganrendelok.models.PatientLogin
import com.net.maganrendelok.models.Surgery

interface LOGINAPI {
    @POST("/login")
    fun GetLogin(patient : PatientLogin) : Call<PatientLogin>
}

interface REGISTERAPI {
    @POST("/registration")
    fun PostRegistration(@Body patient: PatientDto) : Call<PatientDto>
}

interface SURGERYAPI {
    @GET("/admin/surgeries")
    fun GetSurgeries() : Call<Array<Surgery>>
}