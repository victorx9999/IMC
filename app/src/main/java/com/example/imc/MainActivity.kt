package com.example.imc

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var texto: TextView
    private lateinit var continuar: Button

    val SECOND = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        spinner = findViewById(R.id.spinner)
        texto = findViewById(R.id.tvSpinner)
        continuar = findViewById(R.id.btContinuar)

        ////////////////////////SPINNER/////////////////////////////////
        val sexo = arrayOf("Masculino", "Feminino")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            sexo
        )
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        spinner.adapter = adapter;

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                // Display the selected item text on text view
                texto.text = "Sexo selecionado : ${parent.getItemAtPosition(position).toString()}"
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        ////////////////////////SPINNER/////////////////////////////////

        this.continuar.setOnClickListener({ onClick(it) })

    }

    fun onClick(view: View){
        Log.i("APP_VV", "Clicou no botão Vai")
        val mensagem = "Funciona!!"
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("MSG_IDA", mensagem)
        //startActivity(intent)
        startActivityForResult(intent, SECOND)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (requestCode == SECOND){
                val mensagem = data?.getStringExtra("MSG_VOLTA")
                Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this, "Voltou pelo dispositivo", Toast.LENGTH_SHORT).show()
        }
    }
}

