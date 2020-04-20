package AMaganrendelok.api

import AMaganrendelok.models.DefaultResponse
import AMaganrendelok.models.LoginResponse
import com.example.AMaganrendelok.models.Surgery
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @POST("registration")
    fun createUser(
            @Field("firstname") firstname:String,
            @Field("lastname") lastname:String,
            @Field("tel") tel:String,
            @Field("email") email:String,
            @Field("password") password:String,
            @Field("TAJ") TAJ:String
    ):Call<DefaultResponse>

    @FormUrlEncoded
    @POST("userlogin")
     fun userLogin(
            @Field("email") email:String,
            @Field("password") password: String
    ):Call<LoginResponse>

    @GET("admin/surgeries")
    fun getSurgery(): Call<List<Surgery>>
}