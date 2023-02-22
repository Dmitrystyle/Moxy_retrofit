package com.example.moxy_retrofit.ui.main

import android.app.AlarmManager
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moxy_retrofit.data.model.Repo
import com.example.moxy_retrofit.ui.base.BaseActivity
import moxy.ktx.moxyPresenter


class MainActivity : BaseActivity(), MainView {
    private val adapter = RepositoryAdapter()
    private val presenter by moxyPresenter { MainPresenter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.moxy_retrofit.R.layout.activity_main)
        setupUI()
    }

    private fun setupUI() {
        val button = findViewById<Button>(com.example.moxy_retrofit.R.id.button)
        val userNameEditText = findViewById<EditText>(com.example.moxy_retrofit.R.id.editNamePerson)
        button.setOnClickListener {
            presenter.requestRepoListPresenter(userNameEditText.text.toString())
        }
        val recyclerview = findViewById<RecyclerView>(com.example.moxy_retrofit.R.id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)

        recyclerview.adapter = adapter

    }

    override fun showRepoList(result: List<Repo>) {
        adapter.repoList = result
    }

    override fun showError(massage: String) {

           Toast.makeText(this, massage , Toast.LENGTH_SHORT).show()
    }
}