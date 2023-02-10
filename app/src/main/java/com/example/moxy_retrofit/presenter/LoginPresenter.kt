package com.example.moxy_retrofit.presenter

import com.example.moxy_retrofit.api.SimpleApi
import com.example.moxy_retrofit.view.BaseView
import com.example.retrofit.Repo


import moxy.MvpPresenter
import retrofit2.Call
import retrofit2.Response


class LoginPresenter ()  : MvpPresenter<BaseView>() {

     suspend fun getPostPresenter(user: String) {
        val apiInerfase = SimpleApi.create().getRepo(user)
        apiInerfase.enqueue(object : retrofit2.Callback <List<Repo>>{

            override fun onFailure(call: Call<List<Repo>>?, t: Throwable) {
                viewState.showError("Error_massage")

            }

            override fun onResponse(call: Call<List<Repo>>?, response: Response<List<Repo>>) {
                viewState.showDialog("OnResponse sucsses ${response.body()?.toString()}")
            }

        })

    }
}



