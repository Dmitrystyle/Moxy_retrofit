package com.example.moxy_retrofit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.moxy_retrofit.presenter.LoginPresenter
import com.example.moxy_retrofit.view.BaseView
import com.example.moxy_retrofit.view.ILoginView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity: MvpAppCompatActivity(), BaseView {

    val presenter by moxyPresenter { LoginPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData() //вводим данные
    }

    private fun getData() {

        var buttonSumm=findViewById<Button>(R.id.button)
        var textSeach=findViewById<EditText>(R.id.editTextURL)


        buttonSumm.setOnClickListener {
            presenter.getData(textSeach.text.toString())
        }
    }


    override fun showDialog() {
        var TexRequest=findViewById<TextView>(R.id.setTextRequest)
        TexRequest.text =//присваиваем результат
    }

    override fun showError(massage: String) {
        Toast.makeText(this, sumResult, Toast.LENGTH_LONG).show()
    }
}