package simplifiedcoding.net.maganrendelo.api

import retrofit2.Call
import retrofit2.http.*
import simplifiedcoding.net.maganrendelo.models.PatientDto
import simplifiedcoding.net.maganrendelo.models.PatientLogin
import simplifiedcoding.net.maganrendelo.models.Surgery

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