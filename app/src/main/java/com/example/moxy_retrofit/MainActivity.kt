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
        getData() //вводим данные
    }

    private fun getData() {

        var buttonSumm=findViewById<Button>(R.id.button)
       // var textSeach=findViewById<EditText>(R.id.editTextURL)
        buttonSumm.setOnClickListener {
            presenter.getPostPresenter()
        }
    }


    override fun showDialog(s: String) {
         Toast.makeText(this, s, Toast.LENGTH_LONG).show()

    }

    override fun showError(massage: String) {
        Toast.makeText(this, massage, Toast.LENGTH_LONG).show()
    }
}