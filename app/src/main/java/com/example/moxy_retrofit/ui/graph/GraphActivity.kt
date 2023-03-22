package com.example.moxy_retrofit.ui.graph

import android.content.Intent
import android.graphics.Color
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
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import moxy.ktx.moxyPresenter
import java.text.SimpleDateFormat
import java.util.*
import java.util.stream.Collectors.counting
import java.util.stream.Collectors.groupingBy

import java.util.function.Function
import java.util.stream.Collectors.*


class GraphActivity :  BaseActivity(), GraphView {

    var repoDataList: List<Stars> = ArrayList()
    private val presenterGraph by moxyPresenter { GraphPresenter() }
    lateinit var barChart: BarChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_graph)
        setupUI()
        buttonReturn()
        graph()
     }

    private fun graph() {
        barChart=findViewById(R.id.bar_chart)
        val list: ArrayList<BarEntry> = ArrayList()

        list.add(BarEntry(100f,400f))
        list.add(BarEntry(101f,200f))
        list.add(BarEntry(102f,300f))
        list.add(BarEntry(103f,400f))
        list.add(BarEntry(104f,500f))

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


        val dataFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())  //2011-07-04T13:25:41Z
        val arr = repoDataList.map{dataFormatter.parse(it.starred_at)}  //здесь получили данные
        val formatter = arr.map { dataFormatter.format(it)}
        tvView3.setText(formatter.toString())

        tvTextNumberofElement.setText(formatter.groupingBy { it }.eachCount().filter { it.value>1 }.toString())


        //println(list.groupingBy { it }.eachCount().filter { it.value > 1 })
       // val dataStatistics = formatter.collect(groupingBy(Function.identity(),counting()))
           /* SimpleDateFormat("yyyy-MM-dd");
        val formattedDate = formatter.format(arr);  //мы форматируем данные
        val arr1 = arr.forEach{ date -> calendar.time = date}
        val arrYEAR = arr1.toString().map{calendar.get(Calendar.YEAR)}
        val arrMONTH = arr1.toString().map{calendar.get(Calendar.MONTH)+1}
        val arrDAY = arr1.toString().map{calendar.get(Calendar.DAY_OF_MONTH)}
        val resultArray = join(arrYEAR, arrMONTH, arrDAY)
        Log.d("MyLog", "$resultArray")*/
        //tvView3.setText(resultArray.toString())
        //      String input = "T2011-07-04T13:25:41Z";
        //        SimpleDateFormat parser = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
        //        Date date = parser.parse(input);  - это выполнено - мы получае данные
        //        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        //        String formattedDate = formatter.format(date);  - мы форматируем данные
        //https://stackoverflow.com/questions/999172/how-to-parse-a-date   - источник


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

