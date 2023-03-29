package com.example.moxy_retrofit.ui.graph

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils.indexOf
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
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import moxy.ktx.moxyPresenter
import java.text.SimpleDateFormat
import java.util.*


class GraphActivity :  BaseActivity(), GraphView {

    var repoDataList: List<Stars> = ArrayList()
    private val presenterGraph by moxyPresenter { GraphPresenter() }
    lateinit var barChart: BarChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_graph)
        setupUI()
        buttonReturn()

     }

    private fun graph(mapData: Map<Float, Float>) {
        barChart=findViewById(R.id.bar_chart)

        val list: ArrayList<BarEntry> = mapData.map{ (t,u) -> BarEntry(t,u)} as ArrayList<BarEntry>

       val barDataSet= BarDataSet(list,"List")
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS,255)
        barDataSet.valueTextColor= Color.BLACK
        val barData= BarData(barDataSet)
        barChart.setFitBars(true)
        barChart.data= barData
        barChart.description.text= "Bar Chart"
        barChart.animateY(2000)
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
        val tvView3 = findViewById<TextView>(R.id.textView)
        val tvTextNumberofElement = findViewById<TextView>(R.id.textView2)

        //____сортируем данные______имя:   janishar   проект:  android-kotlin-mvp-architecture
        val dataFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())  //2011-07-04T13:25:41Z
        val arr = repoDataList.map{dataFormatter.parse(it.starred_at)}  //здесь получили данные
        val formatter = arr.map { dataFormatter.format(it)}

        tvView3.setText(formatter.toString())

        val formatedData = formatter.groupingBy { it }.eachCount().filter { it.value>1 }

        val mapDataList =formatedData.toList()  // имеем 2017-12-24, 6
        //val mapDataListIndex = mapDataList.
            //listOf(formatedData.mapValues { it.value })
        //.indexOf(formatedData.mapValues{it.value})
         //   formatedData.mapValues{it.value.toFloat()}
       // val mapData1 = mapData.mapKeys { it.key.toFloat()}
       //list.indexOf(element)
      //  graph(mapData1)


/*        fun main(args: Array<String>) {
            val mutableList: MutableList<Int> = mutableListOf(1, 4, 9, 16, 25)
            println("List before replacing : " + mutableList)
            mutableList.set(3, 0)
            println("List after  replacing : " + mutableList)*/

        tvTextNumberofElement.setText(mapDataList.toString())


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

