package com.example.moxy_retrofit.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle




interface BaseView : MvpView {
        @AddToEndSingle
        fun showDialog(s: String)
        @AddToEndSingle
        fun showError(massage:String)
    }
