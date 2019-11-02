package com.example.imc

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var texto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        spinner = findViewById(R.id.spinner)
        texto = findViewById(R.id.tvSpinner)

        val sexo = arrayOf("Masculino", "Feminino")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            sexo
        )
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        // Finally, data bind the spinner object with dapter
        spinner.adapter = adapter;

        // Set an on item selected listener for spinner object
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                // Display the selected item text on text view
                texto.text = "Sexo selecionado : ${parent.getItemAtPosition(position).toString()}"
            }

            override fun onNothingSelected(parent: AdapterView<*>){
                // Another interface callback
            }
        }


    }
}

