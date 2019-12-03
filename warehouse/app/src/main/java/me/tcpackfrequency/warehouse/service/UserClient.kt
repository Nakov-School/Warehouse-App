package me.tcpackfrequency.warehouse.service

import me.tcpackfrequency.warehouse.model.Login
import me.tcpackfrequency.warehouse.model.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.*

interface UserClient {

    @POST("authenticate")
    fun login(@Body login: Login): Call<User>


    @GET("/users/1")
    fun helloWorld(@Header("Authorization") auth: String): Call<ResponseBody>
}