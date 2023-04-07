package com.example.moxy_retrofit.ui.graph

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.moxy_retrofit.R
import com.example.moxy_retrofit.R.layout
import com.example.moxy_retrofit.data.model.Stars
import com.example.moxy_retrofit.ui.base.BaseActivity
import com.example.moxy_retrofit.ui.main.MainActivity
import moxy.ktx.moxyPresenter
import java.text.SimpleDateFormat
import java.util.*
import com.example.moxy_retrofit.R.id.*

class GraphActivity :  BaseActivity(), GraphView {

    private val presenterGraph by moxyPresenter { GraphPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_graph)
        setupUI()
        buttonUI()
     }

    private fun buttonUI() {
        val buttonBack = findViewById<Button>(button_back)
        buttonBack.setOnClickListener {
            val intent = Intent(this@GraphActivity, MainActivity::class.java )
            startActivity(intent)
        }
    }

    private fun setupUI() {
        val intent = intent
        val repoName = intent.getStringExtra("repoName")
        val tvView = findViewById<TextView>(textViewSendData)
        tvView.text = "Yoy select: $repoName"
        val userName = intent.getStringExtra("uname")
        presenterGraph.requestRepoAndUserPresenter(userName.toString(), repoName.toString()) //передаем данные сразу о пользователе и репозитории
    }


    override fun showGraph(result: List<Stars>) {
       val rGraph = RepositoryGraph(result, findViewById(R.id.bar_chart))
        val buttonDate = findViewById<Button>(bGetDate)
        val buttonYear = findViewById<Button>(bGetYear)
        val buttonMonth = findViewById<Button>(bGetMonth)

        buttonDate.setOnClickListener {
            rGraph.getNuberStarsbyDate()
        }
        buttonYear.setOnClickListener {
            rGraph.getNuberStarsbyYear()
        }
        buttonMonth.setOnClickListener {
            rGraph.getNuberStarsbyMonth()
        }
    }

    override fun showErrorGraph(massage: Int, massageType:String) {
           Toast.makeText(this, massage , Toast.LENGTH_SHORT).show()
           Toast.makeText(this, massageType , Toast.LENGTH_SHORT).show()
    }

    fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }

}



