package com.example.moxy_retrofit.ui.graph

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.moxy_retrofit.R.*
import com.example.moxy_retrofit.R.id.button_back
import com.example.moxy_retrofit.R.id.textViewSendData
import com.example.moxy_retrofit.ui.base.BaseActivity
import com.example.moxy_retrofit.ui.main.MainActivity
import moxy.ktx.moxyPresenter


class GraphActivity :  BaseActivity(), GraphView {

    private val presenter by moxyPresenter { GraphPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_graph)
        setupUI()
        buttonRetern()
    }

    private fun buttonRetern() {
        val buttonBack = findViewById<Button>(button_back) //на всякий случай тестовая кнопка возврата
        buttonBack.setOnClickListener {
            val intent = Intent(this@GraphActivity, MainActivity::class.java )
            startActivity(intent)
        }
    }

    private fun setupUI() {
        val intent = intent
        val repoName = intent.getStringExtra("lname")
        val tvView = findViewById<TextView>(textViewSendData)
        tvView.text = "Yoy select: $repoName"
    // презентер вызывает ошибку
    //    val userName = intent.getStringExtra("uname")
     //   presenter.requestRepoListPresenter(userName.toString(), repoName.toString())  //передаем данные сразу о пользователе и репозитории
    }

    override fun showGraph(massageSTARSdata: String) {

    }

    override fun showError(massage: Int, massageType:String) {
          //  Toast.makeText(this, massage , Toast.LENGTH_SHORT).show()
          // Toast.makeText(this, massageType , Toast.LENGTH_SHORT).show()

    }
}