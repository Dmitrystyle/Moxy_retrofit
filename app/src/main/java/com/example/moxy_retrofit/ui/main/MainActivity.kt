package com.example.moxy_retrofit.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moxy_retrofit.R.*
import com.example.moxy_retrofit.data.model.Repo
import com.example.moxy_retrofit.ui.base.BaseActivity
import com.example.moxy_retrofit.ui.graph.GraphActivity
import moxy.ktx.moxyPresenter


class MainActivity : BaseActivity(), MainView {
    private val adapter = RepositoryAdapter()
    private val presenter by moxyPresenter { MainPresenter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        setupUI()
    }

    private fun setupUI() {
        val button = findViewById<Button>(id.button)
        val userNameEditText = findViewById<EditText>(id.editNamePerson)
        button.setOnClickListener {
            presenter.requestRepoListPresenter(userNameEditText.text.toString())
        }
        val recyclerview = findViewById<RecyclerView>(id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)

        recyclerview.adapter = adapter

        button.setOnClickListener {
            val intent = Intent(this, GraphActivity::class.java )
            startActivity(intent)
        }

    }

    override fun showRepoList(result: List<Repo>) {
        adapter.repoList = result
    }

    override fun showError(massage: Int, massageType:String) {
             Toast.makeText(this, massage , Toast.LENGTH_SHORT).show()
             Toast.makeText(this, massageType , Toast.LENGTH_SHORT).show()
    }
}