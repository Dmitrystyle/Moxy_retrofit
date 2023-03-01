package com.example.moxy_retrofit.ui.graph


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.moxy_retrofit.R.*
import com.example.moxy_retrofit.R.id.button_back
import com.example.moxy_retrofit.R.id.textViewSendData
import com.example.moxy_retrofit.ui.base.BaseActivity
import com.example.moxy_retrofit.ui.main.MainActivity


class GraphActivity :  BaseActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_graph)

        //_______прием данных___________
        val intent = intent
        val lName = intent.getStringExtra("lname")
        val tvView = findViewById<TextView>(textViewSendData)
        tvView.text = "Yoy select: $lName"

        //_____тестовая кнопка возврата_______
        val buttonBack = findViewById<Button>(button_back)
        buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java )
            startActivity(intent)
        }
    }
}