package me.tcpackfrequency.warehouse

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_sections.*
import me.tcpackfrequency.warehouse.MainActivity.Companion.userClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sections)
        val buttontest = findViewById<Button>(R.id.button1)
        val buttontest2 = findViewById<Button>(R.id.button2)
        val buttontest3 = findViewById<Button>(R.id.button3)

        buttontest.setOnClickListener {
            val token = intent.getStringExtra("token")
            val info = userClient.getSector(token.toString(), 1)

            info.enqueue(object: Callback<ResponseBody> {

                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if(response.isSuccessful){
                        Toast.makeText(this@SectionActivity, response.body()?.string(), Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this@SectionActivity, "login is not correct :(", Toast.LENGTH_LONG).show()
                    }
                }
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Toast.makeText(this@SectionActivity, "error :(", Toast.LENGTH_LONG).show()

                }

            })
        }

        buttontest2.setOnClickListener {
            val token = intent.getStringExtra("token")
            val info = userClient.getSector(token.toString(), 2)

            info.enqueue(object: Callback<ResponseBody> {

                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if(response.isSuccessful){
                        Toast.makeText(this@SectionActivity, response.body()?.string(), Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this@SectionActivity, "login is not correct :(", Toast.LENGTH_LONG).show()
                    }
                }
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Toast.makeText(this@SectionActivity, "error :(", Toast.LENGTH_LONG).show()

                }

            })
        }

        buttontest3.setOnClickListener {
            val token = intent.getStringExtra("token")
            val info = userClient.getSector(token.toString(), 3)

            info.enqueue(object: Callback<ResponseBody> {

                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if(response.isSuccessful){
                        Toast.makeText(this@SectionActivity, response.body()?.string(), Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this@SectionActivity, "login is not correct :(", Toast.LENGTH_LONG).show()
                    }
                }
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Toast.makeText(this@SectionActivity, "error :(", Toast.LENGTH_LONG).show()

                }

            })
        }

    }


}
