package com.example.moxy_retrofit.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface ILoginView: MvpView {
    @AddToEndSingle
    fun onLoginSuccess(sumResult: String)
    @AddToEndSingle
    fun onLoginError(sumResult: String)

}

interface BaseView :MvpView{
    @AddToEndSingle
    fun showDialog()
    @AddToEndSingle
    fun showError(massage:String)
}