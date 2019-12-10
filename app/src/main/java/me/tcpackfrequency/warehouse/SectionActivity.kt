package me.tcpackfrequency.warehouse

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


class SectionActivity : AppCompatActivity(), View.OnClickListener {

    val API = me.tcpackfrequency.warehouse.util.API()
    var token = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sections)

        val backbtn = findViewById<ImageButton>(R.id.backbtn)

        backbtn.setOnClickListener { onBackPressed() }


        token = intent.getStringExtra("token")

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button1 -> API.getSectorDetails(this@SectionActivity, 1, token)
            R.id.button2 -> API.getSectorDetails(this@SectionActivity, 2, token)
            R.id.button3 -> API.getSectorDetails(this@SectionActivity, 3, token)
            R.id.button4 -> API.getSectorDetails( this@SectionActivity, 4, token)
            R.id.button5 -> API.getSectorDetails( this@SectionActivity, 5, token)
            R.id.button6 -> API.getSectorDetails(this@SectionActivity, 6, token)
            R.id.button7 -> API.getSectorDetails(this@SectionActivity, 7, token)
            R.id.button8 -> API.getSectorDetails(this@SectionActivity, 8, token)
            R.id.button9 -> API.getSectorDetails(this@SectionActivity, 9, token)
            R.id.button10 -> API.getSectorDetails( this@SectionActivity, 10, token)
            R.id.button11 -> API.getSectorDetails(this@SectionActivity, 11, token)
            R.id.button12 -> API.getSectorDetails( this@SectionActivity, 12, token)
            R.id.button13 -> API.getSectorDetails( this@SectionActivity, 13, token)
            R.id.button14 -> API.getSectorDetails(this@SectionActivity, 14, token)
            R.id.button15 -> API.getSectorDetails( this@SectionActivity, 15, token)
            R.id.button16 -> API.getSectorDetails(this@SectionActivity, 17, token)
            R.id.button18 -> API.getSectorDetails(this@SectionActivity, 18, token)
            R.id.button19 -> API.getSectorDetails(this@SectionActivity, 19, token)
            R.id.button20 -> API.getSectorDetails(this@SectionActivity, 20, token)
            R.id.button21 -> API.getSectorDetails(this@SectionActivity, 21, token)
        }
    }




}
