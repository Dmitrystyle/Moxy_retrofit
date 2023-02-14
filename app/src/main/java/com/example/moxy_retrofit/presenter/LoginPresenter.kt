package com.example.moxy_retrofit.presenter
import android.content.ContentValues.TAG
import android.util.Log
import com.example.moxy_retrofit.api.SimpleApi
import com.example.moxy_retrofit.view.BaseView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moxy.MvpPresenter

class LoginPresenter() : MvpPresenter<BaseView>() {
    fun getPostPresenter(userName: String) {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val list = SimpleApi.create().getRepo(userName)
                viewState.showDialog(list)
               Log.d(TAG, userName)
            } catch (e: Exception) {
                e.printStackTrace()
                viewState.showError("Error")
            }

        }
    }







}




