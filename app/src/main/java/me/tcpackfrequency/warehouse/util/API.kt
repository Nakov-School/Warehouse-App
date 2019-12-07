package me.tcpackfrequency.warehouse.util

import android.app.Activity
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


    fun getBoxDetails(info: Call<ResponseBody>, activity: Activity) {
    info.enqueue(object: Callback<ResponseBody> {

        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
            if(response.isSuccessful){
                Toast.makeText(activity, response.body()?.string(), Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(activity, "login is not correct :(", Toast.LENGTH_LONG).show()
            }
        }
        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            Toast.makeText(activity, "error :(", Toast.LENGTH_LONG).show()

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
                    Toast.makeText(activity, "login is not correct :(", Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(activity, "error :(", Toast.LENGTH_LONG).show()

            }
        })
         return emptyList()
    }

    fun getSectorDetails(activity: Activity, sector: Int, token: String){
        MainActivity.userClient.getSector(token, sector).enqueue(object: Callback<ResponseBody> {

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if(response.isSuccessful){
                    val type: Type = object : TypeToken<List<Box?>?>() {}.type
                    val records: List<Box> = Gson().fromJson(response.body()?.string(), type)
                    var show = ""
                    records.forEach { record -> show += "$record " }
                    Toast.makeText(activity, show, Toast.LENGTH_SHORT).show()
                    val intent = Intent(activity, Positions::class.java)
                    intent.putExtra("sector", sector)
                    intent.putExtra("token", token)
                    activity.startActivity(intent)
                } else {
                    Toast.makeText(activity, "login is not correct :(", Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(activity, "error :(", Toast.LENGTH_LONG).show()

            }

        })
    }


}