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

    var isFragmentOneLoaded = true
    var isFragmentTwoLoaded = true
    var isFragmentThreeLoaded = true
    val manager = supportFragmentManager

    private lateinit var botao: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_main)

        this.botao = findViewById(R.id.btOutraNavegacao)
        this.botao.setOnClickListener({ onClick(it) })

        Log.i("APP_VV", "Outra - OnCreate")

        val mensagem = intent.getStringExtra("MSG_IDA")
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()


        ///////////////////////////////////////////////////////////////////////

        val Change = findViewById<Button>(R.id.btnIMC)
        val Change2 = findViewById<Button>(R.id.btnCalorias)
        val Change3 = findViewById<Button>(R.id.btnPesoIdeal)

        Change.setOnClickListener({
                ShowFragmentOne()
        })

        Change2.setOnClickListener({
            ShowFragmentTwo()
        })

        Change3.setOnClickListener({
            ShowFragmentThree()})

    }


    fun onClick(view: View){
        Log.i("APP_VV", "Clicou no botão Volta")
        val intent = Intent()
        intent.putExtra("MSG_VOLTA", "Que bom!")
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    fun ShowFragmentOne() {
        val transaction = manager.beginTransaction()
        val fragment = FragmentOne()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = true
        isFragmentThreeLoaded = false
        isFragmentTwoLoaded = false
    }

    fun ShowFragmentTwo() {
        val transaction = manager.beginTransaction()
        val fragment = FragmentTwo()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = false
        isFragmentThreeLoaded = false
        isFragmentTwoLoaded = true
    }

    fun ShowFragmentThree() {
        val transaction = manager.beginTransaction()
        val fragment = FragmentThree()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = false
        isFragmentTwoLoaded = false
        isFragmentThreeLoaded = true
    }

}