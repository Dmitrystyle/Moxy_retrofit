package com.example.moxy_retrofit.view

import com.example.moxy_retrofit.model.Repo
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle




interface BaseView : MvpView {

        @AddToEndSingle
        fun showDialog(s: ArrayList<Repo>)
        @AddToEndSingle
        fun showError(massage:String)
    }
