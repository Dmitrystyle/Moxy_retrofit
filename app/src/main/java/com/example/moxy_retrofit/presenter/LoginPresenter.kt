package com.example.moxy_retrofit.presenter

import com.example.moxy_retrofit.view.ILoginView


import moxy.MvpPresenter


class LoginPresenter ()  : MvpPresenter<ILoginView>(), ILoginPresenter  {

    override fun getData(A: String, B: String) {

        val sumResult = A.toInt() + B.toInt()


        if (sumResult==0) {
            viewState.onLoginError("Введите число")
        }
        else {
            viewState.onLoginSuccess(sumResult.toString())
        }

    }
}



