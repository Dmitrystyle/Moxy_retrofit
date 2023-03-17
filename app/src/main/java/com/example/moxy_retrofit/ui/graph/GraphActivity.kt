package com.example.moxy_retrofit.ui.graph

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.moxy_retrofit.R
import com.example.moxy_retrofit.R.id.button_back
import com.example.moxy_retrofit.R.id.textViewSendData
import com.example.moxy_retrofit.R.layout
import com.example.moxy_retrofit.data.model.Stars
import com.example.moxy_retrofit.ui.base.BaseActivity
import com.example.moxy_retrofit.ui.main.MainActivity
import moxy.ktx.moxyPresenter
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

    private fun  join (arrYEAR: List<Int>, arrMONTH: List<Int>, arrDAY: List<Int>): List<Int> {
            return arrYEAR + arrMONTH + arrDAY
       }

    override fun showGraph(result: List<Stars>) {
        repoDataList=result
        val tvView3 = findViewById<TextView>(R.id.textViewSendData3)

        val calendar = Calendar.getInstance()
        val dataFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())  //2011-07-04T13:25:41Z
        val arr = repoDataList.map{dataFormatter.parse(it.starred_at)}
        val arr1 = arr.forEach{ date -> calendar.time = date}
        val arrYEAR = arr1.toString().map{calendar.get(Calendar.YEAR)}
        val arrMONTH = arr1.toString().map{calendar.get(Calendar.MONTH)+1}
        val arrDAY = arr1.toString().map{calendar.get(Calendar.DAY_OF_MONTH)}
        val resultArray = join(arrYEAR, arrMONTH, arrDAY)
        Log.d("MyLog", "$resultArray")

        tvView3.setText(resultArray.toString())

 /*      tvView3.setText(arrYEAR[0].toString()+"-"+arrMONTH[0].toString()+"-"+arrDAY[0].toString() +"\n"
        +arrYEAR[1].toString()+"-"+arrMONTH[1].toString()+"-"+arrDAY[1].toString()+"\n"
        +arrYEAR[2].toString()+"-"+arrMONTH[2].toString()+"-"+arrDAY[2].toString()+"\n"
        +arrYEAR[8].toString()+"-"+arrMONTH[8].toString()+"-"+arrDAY[8].toString()+"\n" )*/
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

/* for (i in arrYEAR.indices) {
            var resultArray = arrYEAR[i]+arrMONTH[i]+arrDAY[i]
            Log.d("MyLog", "$resultArray" )
        }*/

/*        for (let i = 0, i < Math.max(arrYEAR); i++) {
            if (arrYEAR[i] != null) {
                c.push(a[i])
            }
            if (b[i] != null) {
                c.push(b[i])
            }
        }*/