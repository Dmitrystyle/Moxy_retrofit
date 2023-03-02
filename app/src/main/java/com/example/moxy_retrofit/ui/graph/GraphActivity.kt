package com.example.moxy_retrofit.ui.graph


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.moxy_retrofit.R.*
import com.example.moxy_retrofit.R.id.button_back
import com.example.moxy_retrofit.R.id.textViewSendData
import com.example.moxy_retrofit.data.repository.Repository
import com.example.moxy_retrofit.ui.base.BaseActivity
import com.example.moxy_retrofit.ui.main.MainActivity
import com.example.moxy_retrofit.ui.main.MainView

class GraphActivity :  BaseActivity(), GraphView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_graph)

        val intent = intent                                 //_______прием данных___________
        val lName = intent.getStringExtra("lname")
        val tvView = findViewById<TextView>(textViewSendData)
        tvView.text = "Yoy select: $lName"

        val buttonBack = findViewById<Button>(button_back) //_____тестовая кнопка возврата_______
        buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java )
            startActivity(intent)
        }

        setupUI()
    }

    private fun setupUI() {
        //______ввод данных - принимает от первого активити____
    }

    override fun showGraph(massageSTARSdata: String) {
            //______вывод парсинга______
    }

    override fun showError(massage: Int, massageType:String) {
            Toast.makeText(this, massage , Toast.LENGTH_SHORT).show()
            Toast.makeText(this, massageType , Toast.LENGTH_SHORT).show()

    }
}