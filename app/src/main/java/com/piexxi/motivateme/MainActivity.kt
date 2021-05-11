package com.piexxi.motivateme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var et_Name: EditText
    private lateinit var tv_Message: TextView
    private lateinit var bt_Update: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        initview()
        initListner()
    }

    private fun initview() {
        et_Name = findViewById(R.id.et_name)
        tv_Message = findViewById(R.id.tv_display_msg)
        bt_Update = findViewById(R.id.bt_update)
    }

    private fun initListner() {
        bt_Update.setOnClickListener { updateMessage() }
    }

    private fun updateMessage() {

        var userName = et_Name.text

        val motivationalMsg = listOf("Keep Working Hard..!","Never Give Up..!","Keep Your Head Up..!",
                                        "Difficulty is Growth", "Today is The First Day of Rest of Your Life")

        val index = (0..4).random()
        val currentMsg = motivationalMsg[index]

        if (userName.toString() == "") {
            tv_Message.text = "Please Make Sure To Provide Your Name"
        } else {
            tv_Message.text = "Hello $userName  - $currentMsg"
        }


        et_Name.setText("")

        hideKeyBoard()

    }

    private fun hideKeyBoard ()
    {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(et_Name.windowToken,0)

    }
}