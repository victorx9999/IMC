package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var altura: EditText
    private lateinit var peso: EditText
    private lateinit var idade: EditText
    private lateinit var botao: Button
    private lateinit var texto: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        altura = findViewById(R.id.etAltura)
        peso = findViewById(R.id.etPeso)
        idade = findViewById(R.id.etIdade)
        botao = findViewById(R.id.btCalcularID)
        texto = findViewById(R.id.tvTextoID)


        this.botao.setOnClickListener({calcIMC(it)})

    }

     fun calcIMC(textView: View?) {
        val pesoIMC = peso.toString().toFloat()

        val alturaIMC = (altura.toString().toFloat() * altura.toString().toFloat())

        val imc = pesoIMC / alturaIMC

        if(imc <= 18.5) {
            this.texto.text = "Abaixo do Peso"
        }
        else if(imc <= 24.9) {
            this.texto.text = "Peso Ideal"

        }
        else if(imc <= 29.9) {
            this.texto.text = "Levemente Acima do Peso"

        }
        else if(imc <= 34.9) {
            this.texto.text = "Obesidade"

        }
    }

}

