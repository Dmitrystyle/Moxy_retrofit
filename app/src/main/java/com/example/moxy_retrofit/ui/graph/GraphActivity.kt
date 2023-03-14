package com.example.moxy_retrofit.ui.graph

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.moxy_retrofit.R
import com.example.moxy_retrofit.R.*
import com.example.moxy_retrofit.R.id.button_back
import com.example.moxy_retrofit.R.id.textViewSendData
import com.example.moxy_retrofit.data.model.Stars
import com.example.moxy_retrofit.ui.base.BaseActivity
import com.example.moxy_retrofit.ui.main.MainActivity
import moxy.ktx.moxyPresenter
import java.lang.String.format
import java.text.SimpleDateFormat
import java.util.*


class GraphActivity :  BaseActivity(), GraphView {

    var repoDataList: List<Stars> = ArrayList()
    private val presenterGraph by moxyPresenter { GraphPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_graph)
        setupUI()
        buttonReturn()

    }

    private fun buttonReturn() {
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
        val tvView1 = findViewById<TextView>(R.id.textViewSendData2)
        tvView.text = "Yoy select: $repoName"
        val userName = intent.getStringExtra("uname")
        tvView1.text = "Yoy select: $userName"
        presenterGraph.requestRepoAndUserPresenter(userName.toString(), repoName.toString()) //передаем данные сразу о пользователе и репозитории
    }

    override fun showGraph(result: List<Stars>) {
        repoDataList=result
        val tvView3 = findViewById<TextView>(R.id.textViewSendData3)

        val calendar = Calendar.getInstance()
        val dataFormatter = SimpleDateFormat("yyyy-MM-dd")  //2011-07-04T13:25:41Z
        val arr = repoDataList.map{dataFormatter.parse(it.starred_at)}
        val arr1 = arr.forEach{ date -> calendar.set(date.year, date.month, date.day)}.toString()
        val arr2 = arr1.map{calendar.get(Calendar.YEAR)}
        tvView3.text = arr2.toString()
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

