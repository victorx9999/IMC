package com.example.imc

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var botao: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_main)

        this.botao = findViewById(R.id.btOutraNavegacao)
        this.botao.setOnClickListener({ onClick(it) })

        Log.i("APP_VV", "Outra - OnCreate")

        val mensagem = intent.getStringExtra("MSG_IDA")
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
    }

    fun onClick(view: View){
        Log.i("APP_VV", "Clicou no botão Volta")
        val intent = Intent()
        intent.putExtra("MSG_VOLTA", "Que bom!")
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

}