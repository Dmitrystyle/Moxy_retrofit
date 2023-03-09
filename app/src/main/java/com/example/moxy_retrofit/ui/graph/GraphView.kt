package com.example.moxy_retrofit.ui.graph


import com.example.moxy_retrofit.data.model.Stars
import com.example.moxy_retrofit.ui.base.BaseView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution


interface GraphView: BaseView {

    @AddToEndSingle
    fun showGraph(resultStars: List<Stars>)

    @OneExecution
    fun showErrorGraph(massage:Int, massageType:String)



}