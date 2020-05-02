package maganrendelo.api

import retrofit2.Call
import retrofit2.http.*
import maganrendelo.models.PatientDto
import maganrendelo.models.PatientLogin
import maganrendelo.models.Surgery

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