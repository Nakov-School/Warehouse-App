package me.tcpackfrequency.warehouse

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import me.tcpackfrequency.warehouse.model.Login
import me.tcpackfrequency.warehouse.model.User
import me.tcpackfrequency.warehouse.service.UserClient
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://postgrewithspring.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val userClient = retrofit.create(UserClient::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var et_user_name = findViewById<EditText>(R.id.et_user_name)
        var et_password = findViewById<EditText>(R.id.et_password)
        var btn_reset = findViewById<Button>(R.id.btn_reset)
        var btn_submit = findViewById<Button>(R.id.btn_submit)

        btn_reset.setOnClickListener {
            // clearing user_name and password edit text views on reset button click
            et_user_name.setText("")
            et_password.setText("")
        }

        // set on-click listener
        btn_submit.setOnClickListener {
            val user_name = et_user_name.text
            val password = et_password.text



            val login = userClient.login(Login(user_name.toString(), password.toString()))



            login.enqueue( object: Callback<User> {

                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if(response.isSuccessful){
                        Toast.makeText(this@MainActivity, response.body()?.token, Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this@MainActivity, "login is not correct :(", Toast.LENGTH_LONG).show()
                    }
                }
                override fun onFailure(call: Call<User>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "error :(", Toast.LENGTH_LONG).show()

                }

            })

        }
    }
}
