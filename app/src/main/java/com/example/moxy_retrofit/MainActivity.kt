package com.example.moxy_retrofit

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moxy_retrofit.presenter.LoginPresenter
import com.example.moxy_retrofit.view.BaseView
import com.example.moxy_retrofit.model.Repo
import com.example.retrofit.RepositoryAdapter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity: MvpAppCompatActivity(), BaseView {

    val presenter by moxyPresenter { LoginPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
         getData()
    }

    private fun getData() {

        var button=findViewById<Button>(R.id.button)
        var d=findViewById<EditText>(R.id.editTextTextPersonName3)
        val userName = d.text.toString()
        button.setOnClickListener {
            presenter.getPostPresenter(userName)
        }
    }
    override fun showDialog(result: List<Repo>) {
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)
        val adapter = RepositoryAdapter(result)
        recyclerview.adapter = adapter
    }

    override fun showError(massage: String) {
            Toast.makeText(applicationContext, massage, Toast.LENGTH_SHORT).show()
    }
}