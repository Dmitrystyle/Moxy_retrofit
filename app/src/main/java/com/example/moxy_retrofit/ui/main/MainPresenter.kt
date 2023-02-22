package com.example.moxy_retrofit.ui.main
import com.example.moxy_retrofit.data.repository.Repository
import com.example.moxy_retrofit.ui.base.BasePresenter
import kotlinx.coroutines.*

class MainPresenter() : BasePresenter() {
    fun requestRepoListPresenter(userName: String) {
         launch {
            try {
                val list =  Repository.getRepo(userName)
                viewState.showRepoList(list)
            } catch (e: Exception) {
                e.printStackTrace()
                viewState.showError("ERROR_MASSAGE")
            }
        }
    }

}

