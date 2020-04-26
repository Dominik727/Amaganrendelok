package simplifiedcoding.net.kotlinretrofittutorial.api

import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.*
import simplifiedcoding.net.kotlinretrofittutorial.models.*

interface LOGINAPI {
    @POST("/login")
    fun GetLogin(patient : PatientLogin) : Call<PatientLogin>
}

interface REGISTERAPI {
    @POST("/registration")
    fun PostRegistration(@Body patient: PatientDto) : Call<PatientDto>
}

interface SURGERYAPI {
    @GET("/surgeries")
    fun GetSurgeries() : Callback<Array<Surgery>>
}