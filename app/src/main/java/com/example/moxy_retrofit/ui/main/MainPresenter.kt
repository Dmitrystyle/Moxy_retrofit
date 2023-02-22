package com.example.moxy_retrofit.ui.main
import android.content.res.Resources
import com.example.moxy_retrofit.R
import com.example.moxy_retrofit.R.string.error_massage
import com.example.moxy_retrofit.data.repository.Repository
import com.example.moxy_retrofit.ui.base.BasePresenter
import kotlinx.coroutines.*

class MainPresenter() : BasePresenter() {


    fun requestRepoListPresenter(userName: String ) {



         launch {
            try {
                val list =  Repository.getRepo(userName)
                viewState.showRepoList(list)
            } catch (e: Exception) {
                e.printStackTrace()
                val massageText = Resources.getSystem().getString(error_massage)
                viewState.showError("$massageText ${e.message}" )
            }
        }
    }

}




