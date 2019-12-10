package me.tcpackfrequency.warehouse

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.gson.Gson
import me.tcpackfrequency.warehouse.model.Box
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditBox : AppCompatActivity(){

    val API = me.tcpackfrequency.warehouse.util.API()
    var token = ""
    var gson = Gson()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editbox)

        token = intent.getStringExtra("token")
        val sector = intent.getIntExtra("sector", 0)

        val applybtn = findViewById<Button>(R.id.apply)
        val delbutton = findViewById<Button>(R.id.delete)

        val box = gson.fromJson(intent.getStringExtra("box"), Box::class.java)
        val positionClicked = intent.getIntExtra("position", 0)


        var position = findViewById<TextView>(R.id.position)
        position.text = "Position: $positionClicked"


        val backbtn = findViewById<ImageButton>(R.id.backbtn)
        backbtn.setOnClickListener { onBackPressed() }

        val contentSpinner = findViewById<Spinner>(R.id.spinner)

        val quantitySpinner = findViewById<Spinner>(R.id.spinner1)

        val prSpinner = findViewById<Spinner>(R.id.spinner2)

        // set to default values if its clicked on an empty position.
        if(box == null){
            contentSpinner.setSelection(0)
            quantitySpinner.setSelection(0)
            prSpinner.setSelection(1)
        }

        // set all the values otherwise.
        when(box?.content) {
            "B" -> contentSpinner.setSelection(1)
            "C" -> contentSpinner.setSelection(2)
            "DC" -> contentSpinner.setSelection(3)
            "S" -> contentSpinner.setSelection(4)
            "M1" -> contentSpinner.setSelection(5)
            "M2" -> contentSpinner.setSelection(6)
            "RTG" -> contentSpinner.setSelection(7)
            else -> contentSpinner.setSelection(0)
        }


        when (box?.quantity) {
            "1" -> quantitySpinner.setSelection(1)
            "1/2" -> quantitySpinner.setSelection(2)
            "1/4" -> quantitySpinner.setSelection(3)
            else -> quantitySpinner.setSelection(0)
        }

        when(box?.pr) {
            true -> prSpinner.setSelection(0)
            false -> prSpinner.setSelection(1)
        }

        applybtn.setOnClickListener {
            if(contentSpinner.selectedItemId.toInt() == 0 || quantitySpinner.selectedItemId.toInt() == 0) {
                Toast.makeText(this, "Please fill all the fields.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val box1 = Box(contentSpinner.selectedItem.toString(), quantitySpinner.selectedItem.toString(), prSpinner.selectedItem.toString().toBoolean(), sector, positionClicked)
            MainActivity.userClient.newBox(token, box1).enqueue(object : Callback<ResponseBody>{
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    val applyIntent = Intent()
                    applyIntent.putExtra("position", positionClicked)
                    setResult(Activity.RESULT_OK, applyIntent)
                    Toast.makeText(this@EditBox, "Successfully saved.", Toast.LENGTH_SHORT).show()
                    finish()
                }
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }



            })
        }

        delbutton.setOnClickListener {
            val box1 = Box(contentSpinner.selectedItem.toString(), quantitySpinner.selectedItem.toString(), prSpinner.selectedItem.toString().toBoolean(), sector, positionClicked)
            MainActivity.userClient.deleteBox(token, box1).enqueue(object: Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if (response.isSuccessful) {
                        val backintent = Intent()
                        backintent.putExtra("position", positionClicked)
                        setResult(Activity.RESULT_FIRST_USER, backintent)
                        Toast.makeText(this@EditBox, "Successfully deleted.", Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        Toast.makeText(this@EditBox, "No such box could be found in the database.", Toast.LENGTH_SHORT).show()
                        return
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Toast.makeText(this@EditBox, "No such box could be found in the database.", Toast.LENGTH_SHORT).show()
                    return
                }

            })
        }


    }
}
