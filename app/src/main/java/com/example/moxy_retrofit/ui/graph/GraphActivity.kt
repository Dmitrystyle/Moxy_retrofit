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
import java.text.SimpleDateFormat
import java.util.regex.Pattern


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
        val dataFormatter = SimpleDateFormat("dd-MM-yyyy")
        val arr = repoDataList.forEach{dataFormatter.parse(it.starred_at)}

        /* for (index in repoDataList) {
            arr.add("$index $" )  //arrayData.toString().slice(17..26).toList()
        }*/

         tvView3.text = arr.toString()                 // repoDataList[0].toString().slice(17..26)    +"\n"+ repoDataList[1].toString().slice(17..26)

    }
    override fun showErrorGraph(massage: Int, massageType:String) {
           Toast.makeText(this, massage , Toast.LENGTH_SHORT).show()
           Toast.makeText(this, massageType , Toast.LENGTH_SHORT).show()
    }
}

/*
groupBy группирует значения по некоторому критерию. Например, мы хотим разбить список котов по возрасту.
val cats = listOf(Cat("Barsik", 5),
        Cat("Murzik", 9), Cat("Ryzhik", 5))
println(cats.groupBy { it.age })
// Результат
{5=[Cat(name=Barsik, age=5), Cat(name=Ryzhik, age=5)],
 9=[Cat(name=Murzik, age=9)]}

*/
