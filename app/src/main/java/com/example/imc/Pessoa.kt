package com.example.imc

import java.io.Serializable

class Pessoa : Serializable {
    var nome: String
    var idade: Int
    var peso: Double
    var altura: Int


    constructor(nome: String, idade: Int, peso: Double, altura: Int){
        this.nome = nome
        this.idade = idade
        this.peso = peso
        this.altura = altura
    }

    override fun toString(): String {
        return super.toString()
    }
}