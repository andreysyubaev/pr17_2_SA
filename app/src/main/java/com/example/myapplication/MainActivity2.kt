package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    private var count = 0
    private lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.countTextView)

        pref = getSharedPreferences("counter", Context.MODE_PRIVATE)

        count = pref.getInt("count", 0)

        count++

        if (count % 2 == 0){
            text.text = "Количество запусков: $count"
        }
        else{
            text.text = "Количество запусков: 0"

        }

        saveData(count)
    }

    fun onClickTap(view: View) {
        count++
        val text = findViewById<TextView>(R.id.countTextView)
        if (count % 2 == 0){
            text.text = "Количество запусков: $count"
        }
        else{
            text.text = "Количество запусков: 0"

        }
        saveData(count)
    }

    fun onClickClear(view: View) {
        count = 0
        val text = findViewById<TextView>(R.id.countTextView)
        if (count % 2 == 0){
            text.text = "Количество запусков: $count"
        }
        else{
            text.text = "Количество запусков: 0"

        }
        saveData(count)
    }

    fun deleteAll(){
        val editor = pref?.edit()
        editor?.clear()
        editor?.apply()

    }

    private fun saveData(res: Int) {
        val editor = pref.edit()
        editor.putInt("count", res)
        editor.apply()
    }


}