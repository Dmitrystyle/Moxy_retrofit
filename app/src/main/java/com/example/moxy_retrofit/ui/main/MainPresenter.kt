package com.example.moxy_retrofit.ui.main
import com.example.moxy_retrofit.data.repository.Repository
import com.example.moxy_retrofit.ui.base.BasePresenter
import com.example.moxy_retrofit.utils.Constants.Companion.ERROR_MASSAGE
import com.example.moxy_retrofit.utils.PresentalScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainPresenter() : BasePresenter() {

    fun requestPostPresenter(userName: String) {
         PresentalScope.launch(Dispatchers.Main) {
            try {

                val list =  Repository.getRepo(userName)
                viewState.showRepoList(list)
            } catch (e: Exception) {
                e.printStackTrace()
                viewState.showError(ERROR_MASSAGE)
            }

        }

    }
}


/*
class Presenter : PlaylistContract.Presenter, CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    override fun long fetchSongs() {
        // This launch uses the coroutineContext defined
        // by the coroutine presenter.
        launch {
            val songs = fetchSongsFromNetwork()
            withContext(Dispatchers.Main) {
                view?.updateSongList(songs)
            }
        }
    }

    override fun cleanup() {
        // By default, every coroutine initiated in this context
        // will use the job and dispatcher specified by the
        // coroutineContext.
        // The coroutines are scoped to their execution environment.
        job.cancel()
    }
}
*/




