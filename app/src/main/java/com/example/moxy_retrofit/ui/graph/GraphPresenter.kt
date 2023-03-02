package com.example.moxy_retrofit.ui.graph

import com.example.moxy_retrofit.R
import com.example.moxy_retrofit.data.repository.Repository
import com.example.moxy_retrofit.ui.base.BasePresenter
import com.example.moxy_retrofit.ui.main.MainView
import kotlinx.coroutines.launch

class GraphPresenter: BasePresenter <MainView>(){

    fun requestRepoListPresenter(userName: String ) {

        launch {
            try {
                val list =  Repository.getRepo(userName)
                viewState.showRepoList(list)
            } catch (e: Exception) {
                e.printStackTrace()
                val massageText = R.string.error_massage
                val massageType:String = "${e.message}"
                viewState.showError(massageText, massageType)

            }
        }
    }
}