package com.example.moxy_retrofit.ui.main.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moxy_retrofit.R
import com.example.moxy_retrofit.ui.main.presenter.RepoPresenter
import com.example.moxy_retrofit.ui.main.view.MainView
import com.example.moxy_retrofit.data.model.Repo
import com.example.moxy_retrofit.adapter.RepositoryAdapter
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity: MvpAppCompatActivity(), MainView {

    private val presenter by moxyPresenter { RepoPresenter() }
   // private lateinit var adapter: RepositoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
         setupUI()
    }

   private fun setupUI() {
        val button=findViewById<Button>(R.id.button)
        val userNameEditText = findViewById<EditText>(R.id.editNamePerson)
        button.setOnClickListener {
                presenter.requestPostPresenter(userNameEditText.text.toString())
        }
    }
    override fun showListVew(result: List<Repo>) {
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)
        var adapter = RepositoryAdapter(result)
        recyclerview.adapter = adapter
    }
    override fun showError(massage: String) {
            Toast.makeText(this, massage, Toast.LENGTH_SHORT).show()
    }
}