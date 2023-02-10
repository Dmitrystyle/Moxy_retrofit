package com.example.moxy_retrofit

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moxy_retrofit.presenter.LoginPresenter
import com.example.moxy_retrofit.view.BaseView
import com.example.retrofit.RepositoryAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity: MvpAppCompatActivity(), BaseView {

    private var adapter: RepositoryAdapter? = null

    val presenter by moxyPresenter { LoginPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
         setupUI()
         getData()


    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RepositoryAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun getData() {

        var buttonSumm=findViewById<Button>(R.id.button)
        var d=findViewById<EditText>(R.id.editTextTextPersonName3)
        val user = d.text.toString()
        buttonSumm.setOnClickListener {
            GlobalScope.launch {
                presenter.getPostPresenter(user)
            }
        }
    }


    override fun showDialog(s: String) {

        recyclerView.adapter

    }

    override fun showError(massage: String) {
            Toast.makeText(applicationContext, "massage", Toast.LENGTH_SHORT).show()

    }


}