package com.example.moxy_retrofit.ui.main.view

import com.example.moxy_retrofit.data.model.Repo
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface MainView : MvpView {
        @AddToEndSingle
        fun showListVew(result: List<Repo>)
        @AddToEndSingle
        fun showError(massage:String)
    }
