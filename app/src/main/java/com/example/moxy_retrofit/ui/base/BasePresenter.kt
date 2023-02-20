package com.example.moxy_retrofit.ui.base

import com.example.moxy_retrofit.ui.main.MainView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import moxy.MvpPresenter
import kotlin.coroutines.CoroutineContext

open class BasePresenter: MvpPresenter<MainView>(), CoroutineScope {

    private val superviserJob = Job()
    override val coroutineContext: CoroutineContext = superviserJob + Dispatchers.Main

    fun cleanup() {
        superviserJob.cancel()
    }

}