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
        summ()
    }

    private fun summ() {



        var buttonSumm=findViewById<Button>(R.id.buttonSum)
        var edTexA=findViewById<EditText>(R.id.editTextSumA)
        var edTexB=findViewById<EditText>(R.id.editTextSumB)

        buttonSumm.setOnClickListener {
            presenter.onSumm(edTexA.text.toString(), edTexB.text.toString())
        }
    }


    @SuppressLint("WrongViewCast")
    override fun onLoginSuccess(sumResult: String) {

        val textView : TextView =findViewById<EditText>(R.id.resultSumm) as TextView
        textView.text =sumResult

    }

    override fun onLoginError(sumResult: String) {
        Toast.makeText(this, sumResult, Toast.LENGTH_LONG).show()
    }
}