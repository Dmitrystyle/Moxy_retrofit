package com.example.moxy_retrofit.ui.graph

import com.example.moxy_retrofit.R
import com.example.moxy_retrofit.data.repository.Repository
import com.example.moxy_retrofit.ui.base.BasePresenter
import kotlinx.coroutines.launch

class GraphPresenter: BasePresenter <GraphView>(){

    fun requestRepoListPresenter(user: String, userRepositoryName: String ) {

        launch {
            try {
                val list =  Repository.getSTARrepo(user, userRepositoryName)
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