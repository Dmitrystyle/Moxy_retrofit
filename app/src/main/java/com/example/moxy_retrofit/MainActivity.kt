package com.example.moxy_retrofit

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.moxy_retrofit.presenter.LoginPresenter
import com.example.moxy_retrofit.view.BaseView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import retrofit2.Response

class MainActivity: MvpAppCompatActivity(), BaseView {

    val presenter by moxyPresenter { LoginPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
         getData()

    }

    private fun getData() {

        var buttonSumm=findViewById<Button>(R.id.button)
        buttonSumm.setOnClickListener {
            presenter.getPostPresenter()
        }
    }


    override fun showDialog(s: String) {
     //  var setDataRepository = findViewById<TextView>(R.id.textGetDataUser)
     //  setDataRepository.text = s
    }

    override fun showError(massage: String) {
     //   var setDataRepository = findViewById<TextView>(R.id.textGetDataUserr)
     //   setDataRepository.text = massage
    }
}