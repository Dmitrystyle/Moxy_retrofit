package com.example.moxy_retrofit.ui.main.presenter
import com.example.moxy_retrofit.data.api.SimpleApi
import com.example.moxy_retrofit.ui.base.BasePresenter
import com.example.moxy_retrofit.utils.Constants.Companion.ERROR_MASSAGE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RepoPresenter() : BasePresenter() {
    fun requestPostPresenter(userName: String) {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val list = SimpleApi.create().getRepo(userName) //сюда указываем
                viewState.showListVew(list)
            } catch (e: Exception) {
                e.printStackTrace()
                viewState.showError(ERROR_MASSAGE)
            }
        }
    }
}




