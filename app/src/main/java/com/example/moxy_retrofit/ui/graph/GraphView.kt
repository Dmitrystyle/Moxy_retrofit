package com.example.moxy_retrofit.ui.graph


import com.example.moxy_retrofit.ui.base.BaseView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution


interface GraphView: BaseView {

    @AddToEndSingle
    fun showGraph(massageSTARSdata:String)

    @OneExecution
    fun showError(massage:Int, massageType:String)



}