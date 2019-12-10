package me.tcpackfrequency.warehouse.service

import me.tcpackfrequency.warehouse.model.Box
import me.tcpackfrequency.warehouse.model.Login
import me.tcpackfrequency.warehouse.model.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.*

interface UserClient {

    @POST("authenticate")
    fun login(@Body login: Login): Call<User>

    @PUT("boxes")
    fun updateBox(@Header("Authorization") auth: String, @Body box: Box): Call<ResponseBody>

    @GET("/sector/{id}")
    fun getSector(@Header("Authorization") auth: String, @Path(value = "id", encoded = true) id: Int): Call<ResponseBody>

    @POST("boxes")
    fun newBox(@Header("Authorization") auth: String, @Body box: Box): Call<ResponseBody>

    @HTTP(method = "DELETE", path = "/boxes", hasBody = true)
    fun deleteBox(@Header("Authorization") auth: String, @Body box: Box): Call<ResponseBody>


}