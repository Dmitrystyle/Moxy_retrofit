package com.example.moxy_retrofit.presenter

import com.example.moxy_retrofit.api.SimpleApi
import com.example.moxy_retrofit.view.BaseView
import com.example.moxy_retrofit.model.Repo

import moxy.MvpPresenter
import retrofit2.Call
import retrofit2.Response


class LoginPresenter ()  : MvpPresenter<BaseView>() {

    fun getPostPresenter(userName:String) {
        val apiInerfase = SimpleApi.create().getRepo(userName)
        apiInerfase.enqueue(object : retrofit2.Callback <List<Repo>>{

            override fun onFailure(call: Call<List<Repo>>?, t: Throwable) {
                viewState.showError("Error_massage")

            }

            override fun onResponse(call: Call<List<Repo>>?, response: Response<List<Repo>>) {

                if (response.isSuccessful && (response.body() != null)){
                    response.body().let {
                       // val data = response
                      //  viewState.showDialog(data)
                        viewState.showDialog(response.body() as ArrayList<Repo>)
                    }
                }

            }

        })

    }
}



