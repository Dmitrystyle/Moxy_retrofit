package com.example.moxy_retrofit.ui.main.view

import com.example.moxy_retrofit.data.model.Repo
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution

interface MainView : MvpView {
        @AddToEndSingle
        fun showRepoList(result: List<Repo>)
        @OneExecution
        fun showError(massage:String)
    }
