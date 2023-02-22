package com.example.moxy_retrofit.ui.main

import com.example.moxy_retrofit.data.model.Repo
import com.example.moxy_retrofit.ui.base.BaseView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution

interface MainView : BaseView {
        @AddToEndSingle
        fun showRepoList(result: List<Repo>)
        @OneExecution
        fun showError(massage:Int, massageType:String)
    }
