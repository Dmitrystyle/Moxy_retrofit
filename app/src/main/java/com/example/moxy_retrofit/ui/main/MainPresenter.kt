package com.example.moxy_retrofit.ui.main
import com.example.moxy_retrofit.data.repository.Repository
import com.example.moxy_retrofit.ui.base.BasePresenter
import com.example.moxy_retrofit.utils.Constants.Companion.ERROR_MASSAGE
import com.example.moxy_retrofit.utils.PresentalScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainPresenter() : BasePresenter() {

    fun requestPostPresenter(userName: String) {
         PresentalScope.launch(Dispatchers.Main) {
            try {

                val list =  Repository.getRepo(userName)                // SimpleApi.create().getRepo(userName) //сюда указываем
                viewState.showRepoList(list)
            } catch (e: Exception) {
                e.printStackTrace()
                viewState.showError(ERROR_MASSAGE)
            }
        }
    }
}




