package com.example.moxy_retrofit.ui.base

import com.example.moxy_retrofit.ui.main.MainView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import moxy.MvpPresenter
import kotlin.coroutines.CoroutineContext

open class BasePresenter: MvpPresenter<MainView>(), CoroutineScope {

    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext = job + Dispatchers.Main

    override fun onDestroy() {
        super.onDestroy()
    }

}