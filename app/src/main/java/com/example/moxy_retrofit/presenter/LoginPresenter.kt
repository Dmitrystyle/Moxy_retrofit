package com.example.moxy_retrofit.presenter

import com.example.moxy_retrofit.api.SimpleApi
import com.example.moxy_retrofit.view.BaseView


import moxy.MvpPresenter
import retrofit2.Call
import retrofit2.Response
import com.example.moxy_retrofit.model.Post as Post


class LoginPresenter ()  : MvpPresenter<BaseView>() {

     fun getPostPresenter() {
        val apiInerfase = SimpleApi.create().getPost()
        apiInerfase.enqueue(object : retrofit2.Callback<Post> {

            override fun onFailure(call: Call<Post>?, t: Throwable) {
                viewState.showError("Error_massage")

            }

            override fun onResponse(call: Call<Post>?, response: Response<Post>) {
                viewState.showDialog("OnResponse sucsses ${response.body()?.title}")
            }

        })

    }
}



