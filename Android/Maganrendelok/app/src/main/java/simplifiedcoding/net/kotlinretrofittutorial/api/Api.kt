package simplifiedcoding.net.kotlinretrofittutorial.api

import retrofit2.Call
import retrofit2.http.*
import simplifiedcoding.net.kotlinretrofittutorial.models.*

interface Api {

    @FormUrlEncoded
    @POST("registration")
    fun createUser(newPatient: PatientDto): Call<PatientDto>

    @GET("admin/surgeries")
    fun getSurgeries(
            //TODO
    ): Call<Surgery>

    @FormUrlEncoded
    @POST("login")
    fun userLogin(
            @Field("email") email:String,
            @Field("password") password: String
    ):Call<LoginResponse>
}