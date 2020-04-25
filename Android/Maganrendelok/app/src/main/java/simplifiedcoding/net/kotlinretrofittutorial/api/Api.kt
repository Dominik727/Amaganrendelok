package simplifiedcoding.net.kotlinretrofittutorial.api

import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.*
import simplifiedcoding.net.kotlinretrofittutorial.models.*

interface LOGINAPI {
    @POST("/admin/login")
    fun GetLogin(email : String, password : String)
}

interface REGISTERAPI {
    @POST("/registration")
    fun PostRegistration(@Body patient: PatientDto) : Call<PatientDto>
}

interface SURGERYApi {
    @GET("/surgeries")
    fun GetSurgeries() : Callback<Array<Surgery>>
}