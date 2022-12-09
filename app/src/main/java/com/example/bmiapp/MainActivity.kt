package com.example.bmiapp

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import java.util.concurrent.ThreadLocalRandom.current
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        idを取得
        var et_Height_Text: EditText = findViewById(R.id.et_Height_Text)
        var et_Weight_Text: EditText = findViewById(R.id.et_Weight_Text)
        var bmi_Btn: Button = findViewById(R.id.bmi_Btn)
        var clear_Btn: Button = findViewById(R.id.clear_Btn)
        var current_Bmi_Text: TextView = findViewById(R.id.current_Bmi_Text)
        var standard_Weight: TextView = findViewById(R.id.standard_Weight)



//        計算クリック処理
        bmi_Btn.setOnClickListener {
            if(et_Height_Text.text.toString().equals("") && et_Weight_Text.text.toString().equals("")) {
                AlertDialog.Builder(this)
                    .setTitle("Error!")
                    .setMessage("数字を入力してください。")
                    .setPositiveButton("OK", null)
                    .show()
            }else if(et_Height_Text.text.toString().equals("")) {
                AlertDialog.Builder(this)
                    .setTitle("Error!")
                    .setMessage("身長を入力してください。")
                    .setPositiveButton("OK", null)
                    .show()
            }else if(et_Weight_Text.text.toString().equals("")) {
                AlertDialog.Builder(this)
                    .setTitle("Error!")
                    .setMessage("体重を入力してください。")
                    .setPositiveButton("OK", null)
                    .show()
            }else {
                var bmi: Double =
                    ((et_Weight_Text.text.trim().toString().toDouble() / (et_Height_Text.text.trim()
                        .toString().toDouble() / 100) /
                            (et_Height_Text.text.trim().toString()
                                .toDouble() / 100)) * 100.0).roundToInt() / 100.0
                current_Bmi_Text.text = bmi.toString()

                if(bmi < 16)
                {
                    val toast = Toast.makeText(applicationContext, "痩せすぎ" , Toast.LENGTH_LONG)
                    toast.show()
                }else if(bmi>=16 && bmi<17)
                {
                    val toast = Toast.makeText(applicationContext, "痩せ" , Toast.LENGTH_LONG)
                    toast.show()
                }else if(bmi>=17 && bmi<18.50)
                {
                    val toast = Toast.makeText(applicationContext, "痩せ気味" , Toast.LENGTH_LONG)
                    toast.show()
                }else if(bmi>=18.50 && bmi<25)
                {
                    val toast = Toast.makeText(applicationContext, "普通体重" , Toast.LENGTH_LONG)
                    toast.show()
                }else if(bmi>=25 && bmi<30)
                {
                    val toast = Toast.makeText(applicationContext, "前肥満" , Toast.LENGTH_LONG)
                    toast.show()
                }else if(bmi>=30 && bmi<35)
                {
                    val toast = Toast.makeText(applicationContext, "肥満(1度)" , Toast.LENGTH_LONG)
                    toast.show()
                }else if(bmi>=35 && bmi<40)
                {
                    val toast = Toast.makeText(applicationContext, "肥満(2度)" , Toast.LENGTH_LONG)
                    toast.show()
                }else if(bmi>=40)
                {
                    val toast = Toast.makeText(applicationContext, "肥満(3度)" , Toast.LENGTH_LONG)
                    toast.show()
                }

                var stan_Weight =
                    (et_Height_Text.text.trim().toString()
                        .toDouble() / 100) * (et_Height_Text.text.trim().toString()
                        .toDouble() / 100).roundToInt() * 22
                standard_Weight.text = stan_Weight.toString()
            }
        }
        clear_Btn.setOnClickListener {
            et_Height_Text.text.clear()
            et_Weight_Text.text.clear()
            current_Bmi_Text.text = "_______"
            standard_Weight.text = "_______"
        }
    }
}
