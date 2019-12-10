package me.tcpackfrequency.warehouse

import android.R.attr
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import me.tcpackfrequency.warehouse.model.Box
import me.tcpackfrequency.warehouse.util.BoxCallback
import me.tcpackfrequency.warehouse.util.BoxesCallback


class Positions : AppCompatActivity(), View.OnClickListener {

    val API = me.tcpackfrequency.warehouse.util.API()
    var token = ""
    var sector = 0
    val gson = Gson()
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var btn9: Button


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_positions)

        sector = intent.getIntExtra("sector", 0)
        token = intent.getStringExtra("token")
        val text = findViewById<TextView>(R.id.sector)

        btn2 = findViewById(R.id.buttonpos2)
        btn3 = findViewById(R.id.buttonpos3)
        btn4 = findViewById(R.id.buttonpos4)
        btn5 = findViewById(R.id.buttonpos5)
        btn6 = findViewById(R.id.buttonpos6)
        btn7 = findViewById(R.id.buttonpos7)
        btn8 = findViewById(R.id.buttonpos8)
        btn9 = findViewById(R.id.buttonpos9)
        btn1 = findViewById(R.id.buttonpos1)

        text.text = "Sector $sector"

        val backbtn = findViewById<ImageButton>(R.id.backbtn)
        backbtn.setOnClickListener { onBackPressed() }



        // dont touch this, i dont know why it works
        // also dont delete this callback. once you enter callback land its hell.
        API.getSectorDetailsRaw(this@Positions, sector, token, object: BoxesCallback {
            override fun onSuccess(boxes: MutableList<Box>) {
                for (box in boxes) {
                    when(box.position){
                        1 -> {btn1.text = "Contents: ${box.content} \n Quantity: ${box.quantity} \n PR: ${box.pr}"
                                btn1.setBackgroundColor(determineColor(box.content))}
                        2 -> {btn2.text = "Contents: ${box.content} \n Quantity: ${box.quantity} \n PR: ${box.pr}"
                            btn2.setBackgroundColor(determineColor(box.content))}
                        3 -> {btn3.text = "Contents: ${box.content} \n Quantity: ${box.quantity} \n PR: ${box.pr}"
                            btn3.setBackgroundColor(determineColor(box.content))}
                        4 -> {btn4.text = "Contents: ${box.content} \n Quantity: ${box.quantity} \n PR: ${box.pr}"
                            btn4.setBackgroundColor(determineColor(box.content))}
                        5 -> {btn5.text = "Contents: ${box.content} \n Quantity: ${box.quantity} \n PR: ${box.pr}"
                            btn5.setBackgroundColor(determineColor(box.content))}
                        6 -> {btn6.text = "Contents: ${box.content} \n Quantity: ${box.quantity} \n PR: ${box.pr}"
                            btn6.setBackgroundColor(determineColor(box.content))}
                        7 -> {btn7.text = "Contents: ${box.content} \n Quantity: ${box.quantity} \n PR: ${box.pr}"
                            btn7.setBackgroundColor(determineColor(box.content))}
                        8 -> {btn8.text = "Contents: ${box.content} \n Quantity: ${box.quantity} \n PR: ${box.pr}"
                            btn8.setBackgroundColor(determineColor(box.content))}
                        9 -> {btn9.text = "Contents: ${box.content} \n Quantity: ${box.quantity} \n PR: ${box.pr}"
                            btn9.setBackgroundColor(determineColor(box.content))}
                    }
                }
            }

            override fun onError(throwable: Throwable) {
                Log.d("ERROR" , throwable.stackTrace.toString())
            }
        })

        }

    override fun onClick(v: View?) {
        when(v?.id){

            R.id.buttonpos1 -> API.getBoxDetails(this@Positions, token, sector, 1, BoxCallback {
                val intent = Intent(this@Positions, EditBox::class.java)
                intent.putExtra("token", token)
                intent.putExtra("sector", sector)
                intent.putExtra("position", 1)
                intent.putExtra("box", gson.toJson(it))
                startActivityForResult(intent, 1)
            })

            R.id.buttonpos2 -> API.getBoxDetails(this@Positions, token, sector, 2, BoxCallback {
                val intent = Intent(this@Positions, EditBox::class.java)
                intent.putExtra("token", token)
                intent.putExtra("sector", sector)
                intent.putExtra("position", 2)
                intent.putExtra("box", gson.toJson(it))
                startActivityForResult(intent, 1)
            })

            R.id.buttonpos3 -> API.getBoxDetails(this@Positions, token, sector, 3, BoxCallback {
                val intent = Intent(this@Positions, EditBox::class.java)
                intent.putExtra("token", token)
                intent.putExtra("sector", sector)
                intent.putExtra("position", 3)
                intent.putExtra("box", gson.toJson(it))
                startActivityForResult(intent, 1)
            })

            R.id.buttonpos4 -> API.getBoxDetails(this@Positions, token, sector, 4, BoxCallback {
                val intent = Intent(this@Positions, EditBox::class.java)
                intent.putExtra("token", token)
                intent.putExtra("sector", sector)
                intent.putExtra("position", 4)
                intent.putExtra("box", gson.toJson(it))
                startActivityForResult(intent, 1)
            })
            R.id.buttonpos5 -> API.getBoxDetails(this@Positions, token, sector, 5, BoxCallback {
                val intent = Intent(this@Positions, EditBox::class.java)
                intent.putExtra("token", token)
                intent.putExtra("sector", sector)
                intent.putExtra("position", 5)
                intent.putExtra("box", gson.toJson(it))
                startActivityForResult(intent, 1)
            })
            R.id.buttonpos6 -> API.getBoxDetails(this@Positions, token, sector, 6, BoxCallback {
                val intent = Intent(this@Positions, EditBox::class.java)
                intent.putExtra("token", token)
                intent.putExtra("sector", sector)
                intent.putExtra("position", 6)
                intent.putExtra("box", gson.toJson(it))
                startActivityForResult(intent, 1)
            })
            R.id.buttonpos7 -> API.getBoxDetails(this@Positions, token, sector, 7, BoxCallback {
                val intent = Intent(this@Positions, EditBox::class.java)
                intent.putExtra("token", token)
                intent.putExtra("sector", sector)
                intent.putExtra("position", 7)
                intent.putExtra("box", gson.toJson(it))
                startActivityForResult(intent, 1)
            })
            R.id.buttonpos8 -> API.getBoxDetails(this@Positions, token, sector, 8, BoxCallback {
                val intent = Intent(this@Positions, EditBox::class.java)
                intent.putExtra("token", token)
                intent.putExtra("sector", sector)
                intent.putExtra("position", 8)
                intent.putExtra("box", gson.toJson(it))
                startActivityForResult(intent, 1)
            })
            R.id.buttonpos9 -> API.getBoxDetails(this@Positions, token, sector, 9, BoxCallback {
                val intent = Intent(this@Positions, EditBox::class.java)
                intent.putExtra("token", token)
                intent.putExtra("sector", sector)
                intent.putExtra("position", 9)
                intent.putExtra("box", gson.toJson(it))
                startActivityForResult(intent, 1)
            })
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_FIRST_USER) {
                val boxpos = data?.getIntExtra("position", 0)
                API.getSectorDetailsRaw(this@Positions, sector, token, object: BoxesCallback {
                    override fun onSuccess(boxes: MutableList<Box>) {
                            when(boxpos){
                                1 -> btn1.text = ""
                                2 -> btn2.text = ""
                                3 -> btn3.text = ""
                                4 -> btn4.text = ""
                                5 -> btn5.text = ""
                                6 -> btn6.text = ""
                                7 -> btn7.text = ""
                                8 -> btn8.text = ""
                                9 -> btn9.text = ""
                            }
                    }

                    override fun onError(throwable: Throwable) {
                        Log.d("ERROR" , throwable.stackTrace.toString())
                    }
                })
            } else if(resultCode == Activity.RESULT_OK) {
                val boxpos: Int = data?.getIntExtra("position", 0)!!
                API.getBoxDetails(this, token, sector, boxpos, BoxCallback {
                    when (boxpos) {
                        1 -> {btn1.text = "Contents: ${it.content} \n Quantity: ${it.quantity} \n PR: ${it.pr}"
                                btn1.setBackgroundColor(determineColor(it.content))}
                        2 -> {btn2.text = "Contents: ${it.content} \n Quantity: ${it.quantity} \n PR: ${it.pr}"
                                btn2.setBackgroundColor(determineColor(it.content))}
                        3 -> {btn3.text = "Contents: ${it.content} \n Quantity: ${it.quantity} \n PR: ${it.pr}"
                                btn3.setBackgroundColor(determineColor(it.content))}
                        4 -> {btn4.text = "Contents: ${it.content} \n Quantity: ${it.quantity} \n PR: ${it.pr}"
                                btn4.setBackgroundColor(determineColor(it.content))}
                        5 -> {btn5.text = "Contents: ${it.content} \n Quantity: ${it.quantity} \n PR: ${it.pr}"
                                btn5.setBackgroundColor(determineColor(it.content))}
                        6 -> {btn6.text = "Contents: ${it.content} \n Quantity: ${it.quantity} \n PR: ${it.pr}"
                                btn6.setBackgroundColor(determineColor(it.content))}
                        7 -> {btn7.text = "Contents: ${it.content} \n Quantity: ${it.quantity} \n PR: ${it.pr}"
                                btn7.setBackgroundColor(determineColor(it.content))}
                        8 -> {btn8.text = "Contents: ${it.content} \n Quantity: ${it.quantity} \n PR: ${it.pr}"
                                btn8.setBackgroundColor(determineColor(it.content))}
                        9 -> {btn9.text = "Contents: ${it.content} \n Quantity: ${it.quantity} \n PR: ${it.pr}"
                                btn9.setBackgroundColor(determineColor(it.content))}
                    }
                })
            }
        }
    }



    fun determineColor(content: String): Int {
        when (content) {
            "C" -> return Color.BLUE
            "DC" -> return Color.GREEN
            "M1" -> return Color.RED
            "M2" -> return Color.rgb(255, 165, 0)
            "B" -> return Color.rgb(150, 75, 0)
            "S" -> return Color.YELLOW
        }
        return 0
    }

}
