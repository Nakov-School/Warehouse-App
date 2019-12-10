package me.tcpackfrequency.warehouse.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.core.content.ContextCompat.startActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import me.tcpackfrequency.warehouse.MainActivity
import me.tcpackfrequency.warehouse.Positions
import me.tcpackfrequency.warehouse.SectionActivity
import me.tcpackfrequency.warehouse.model.Box
import me.tcpackfrequency.warehouse.model.User
import me.tcpackfrequency.warehouse.service.UserClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type

class API {

    fun getBoxDetails(activity: Activity, token: String, sector: Int, position: Int, @Nullable boxCallback: BoxCallback) {
        MainActivity.userClient.getSector(token, sector).enqueue(object: Callback<ResponseBody> {

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if(response.isSuccessful){
                    val type: Type = object : TypeToken<List<Box?>?>() {}.type
                    val records: List<Box> = Gson().fromJson(response.body()?.string(), type)
                    if(records.isEmpty()){
                       boxCallback.onSuccess(null)
                        return
                    }
                    var found = false
                    for(Box in records){
                        if(Box.position == position){
                            boxCallback.onSuccess(Box)
                            found = true
                        }

                    }
                    if(!found) boxCallback.onSuccess(null)
                } else {
                    Toast.makeText(activity, "Login credentials are incorrect.", Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(activity, "Connection to database is lost. Please try again.", Toast.LENGTH_LONG).show()

            }

        })}

     fun getSectorDetailsRaw(activity: Activity, sector: Int, token: String, @Nullable boxesCallback: BoxesCallback) : List<Box> {
        val boxes: ArrayList<Box> = ArrayList()
        MainActivity.userClient.getSector(token, sector).enqueue(object: Callback<ResponseBody> {

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if(response.isSuccessful){
                    val type: Type = object : TypeToken<List<Box?>?>() {}.type
                    val records: List<Box> = Gson().fromJson(response.body()?.string(), type)
                    records.forEach { record -> boxes.add(record)}

                    boxesCallback.onSuccess(boxes)
                } else {
                    Toast.makeText(activity, "Login credentials are incorrect.", Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(activity, "Connection to database is lost. Please try again.", Toast.LENGTH_LONG).show()

            }
        })
         return emptyList()
    }

    fun getSectorDetails(activity: Activity, sector: Int, token: String){
        MainActivity.userClient.getSector(token, sector).enqueue(object: Callback<ResponseBody> {

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if(response.isSuccessful){
                    val intent = Intent(activity, Positions::class.java)
                    intent.putExtra("sector", sector)
                    intent.putExtra("token", token)
                    activity.startActivity(intent)
                } else {
                    Toast.makeText(activity, "Login credentials are incorrect.", Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(activity, "Connection to database is lost. Please try again.", Toast.LENGTH_LONG).show()

            }

        })
    }
}