package me.tcpackfrequency.warehouse.service

import me.tcpackfrequency.warehouse.model.Login
import me.tcpackfrequency.warehouse.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface UserClient {

    @POST("authenticate")
    fun login(@Body login: Login): Call<User>


    @GET("/")
    fun helloWorld(@Header("Authorization") auth: String)
}