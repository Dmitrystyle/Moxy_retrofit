package com.example.moxy_retrofit.presenter
import com.example.moxy_retrofit.api.SimpleApi
import com.example.moxy_retrofit.utils.Constants.Companion.ERROR_MASSAGE
import com.example.moxy_retrofit.view.MainView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moxy.MvpPresenter

class RepoPresenter() : MvpPresenter<MainView>() {
    fun getPostPresenter(userName: String) {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val list = SimpleApi.create().getRepo(userName)
                viewState.showDialog(list)
            } catch (e: Exception) {
                e.printStackTrace()
                viewState.showError(ERROR_MASSAGE)
            }
        }
    }
}




