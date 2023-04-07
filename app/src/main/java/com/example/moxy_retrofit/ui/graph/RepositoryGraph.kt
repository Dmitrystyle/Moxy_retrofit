package com.example.moxy_retrofit.ui.graph

import android.graphics.Color
import com.example.moxy_retrofit.data.model.Stars
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import java.text.SimpleDateFormat
import java.util.*
import android.text.format.DateFormat;

class RepositoryGraph(result: List<Stars>, var barChart: BarChart) {
    private val repoDataList=result
    val dataFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val arr = repoDataList.map { dataFormatter.parse(it.starred_at) }

    fun getNuberStarsbyDate() {
        val formatter = arr.map { dataFormatter.format(it) }
        val formatedData = formatter.groupingBy { it }.eachCount().filter { it.value > 1 }.toList()
        val newData = formatedData.mapIndexed { index, pair ->
            BarEntry(
                index.toFloat(),
                pair.second.toFloat()
            )
        } as ArrayList<BarEntry>
        graph(newData)
    }

    fun getNuberStarsbyYear() {
        //выводим год
        val year =arr.map{DateFormat.format("yyyy",it)}
        val formatedDataYear = year.groupingBy { it }.eachCount().filter { it.value>1 }.toList()
        val newDataYear = formatedDataYear.mapIndexed { index, pair -> BarEntry(index.toFloat(), pair.second.toFloat())} as ArrayList<BarEntry>
        graph(newDataYear)
    }

    fun getNuberStarsbyMonth() {
        //выводим месяц
        val month =arr.map{DateFormat.format("MM",it)}
        val formatedDataMonth = month.groupingBy { it }.eachCount().filter { it.value>1 }.toList()
        val newDataMonth = formatedDataMonth.mapIndexed { index, pair -> BarEntry(index.toFloat(), pair.second.toFloat())} as ArrayList<BarEntry>
        graph(newDataMonth)
    }

      private fun graph(Data: ArrayList<BarEntry>) {
            val list: ArrayList<BarEntry> = Data
            val barDataSet= BarDataSet(list,"List")
            barDataSet.setColors(ColorTemplate.MATERIAL_COLORS,255)
            barDataSet.valueTextColor= Color.BLACK
            val barData= BarData(barDataSet)
            barChart.setFitBars(true)
            barChart.data= barData
            barChart.description.text= "Bar Chart"
            barChart.animateY(2000)
       }












    //____сортируем данные______имя:   janishar   проект:  android-kotlin-mvp-architecture


}