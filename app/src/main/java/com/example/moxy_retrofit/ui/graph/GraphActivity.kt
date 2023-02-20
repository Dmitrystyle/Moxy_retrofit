package com.example.moxy_retrofit.ui.graph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moxy_retrofit.R
import com.example.moxy_retrofit.ui.base.BaseActivity
import com.example.moxy_retrofit.ui.main.MainPresenter
import com.example.moxy_retrofit.ui.main.MainView
import moxy.ktx.moxyPresenter

class GraphActivity :  BaseActivity() {

  //  private val presenter by moxyPresenter { GraphPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)
    }
}