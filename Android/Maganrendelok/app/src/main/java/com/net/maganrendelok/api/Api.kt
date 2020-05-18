package com.net.maganrendelok.api

import com.net.maganrendelok.models.Patient
import retrofit2.Call
import retrofit2.http.*
import com.net.maganrendelok.models.PatientDto
import com.net.maganrendelok.models.PatientLogin
import com.net.maganrendelok.models.Surgery

interface LOGINAPI {
    @POST("/patientlogin")
    fun GetLogin(patient : PatientLogin) : Call<PatientLogin>
}

interface REGISTERAPI {
    @POST("/registration")
    fun PostRegistration(@Body patient: Patient) : Call<Void>
}

interface SURGERYAPI {
    @GET("/admin/surgeries")
    fun GetSurgeries() : Call<Array<Surgery>>
}

interface PATIENTSYAPI {
    @GET("admin/patients")
    fun GetPatients() : Call<Array<Patient>>
}