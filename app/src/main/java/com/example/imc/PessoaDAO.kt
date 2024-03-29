package com.example.imc

import android.content.ContentValues
import android.content.Context
// nome: String, idade: Int, peso: Double, altura: Int
class PessoaDAO {
    var bancoHelper: BancoHelper

    constructor(context: Context){
        this.bancoHelper = BancoHelper(context)
    }

    fun insert(pessoa: Pessoa){
        val banco = this.bancoHelper.writableDatabase
        val cv = ContentValues()
        cv.put("nome", pessoa.nome)
        cv.put("idade", pessoa.idade)
        cv.put("peso", pessoa.peso)
        cv.put("altura", pessoa.altura)
        banco.insert("pessoas", null, cv)
    }

    fun get(id: Int): Pessoa?{
        return null
    }

    fun get(): ArrayList<Pessoa>{
        val lista = arrayListOf<Pessoa>()
        val banco = this.bancoHelper.readableDatabase
        val colunas = arrayOf("id", "nome", "idade", "peso", "altura")

        val c = banco.query("pessoas", colunas, null, null, null, null, null)

        c.moveToFirst()

        do{
            val id = c.getInt(c.getColumnIndex("id"))
            val nome = c.getString(c.getColumnIndex("nome"))
            val idade = c.getInt(c.getColumnIndex("idade"))
            val peso = c.getDouble(c.getColumnIndex("peso"))
            val altura = c.getInt(c.getColumnIndex("altura"))

            val pessoa = Pessoa(id, nome, idade, peso, altura)
            lista.add(pessoa)
        }while (c.moveToNext())

        return lista
    }

    fun update(id: Int, pessoa: Pessoa){
        val cv = ContentValues()
        val where = "id = ?"
        val wherep = arrayOf(pessoa.id.toString())
        cv.put("nome", pessoa.nome)
        cv.put("idade", pessoa.idade)
        cv.put("peso", pessoa.peso)
        cv.put("altura", pessoa.altura)
        this.bancoHelper.writableDatabase.update("pessoas", cv, where, wherep)
    }

    fun delete(id: Int){
        var where = "id = ?"
        var whereP = arrayOf(id.toString())
        this.bancoHelper.writableDatabase.delete("pessoas", where, whereP)
    }

    fun select(): List<Pessoa>{
        val lista = arrayListOf<Pessoa>()
        val banco = this.bancoHelper.readableDatabase
        val colunas = arrayOf("id", "nome", "idade")
        val c = banco.query("pessoas", colunas, null, null, null, null,null)

        c.moveToFirst()
        do {
            var id = c.getInt(c.getColumnIndex("id"))
            var nome = c.getString(c.getColumnIndex("nome"))
            var idade = c.getInt(c.getColumnIndex("idade"))
            var peso = c.getDouble(c.getColumnIndex("peso"))
            var altura = c.getInt(c.getColumnIndex("altura"))

            lista.add(Pessoa(id, nome, idade, peso, altura))
        }while(c.moveToNext())

        return lista
    }

    fun count(): Int{
        val colunas = arrayOf("id")
        val banco = this.bancoHelper.readableDatabase
        val c = banco.query("pessoas", colunas, null, null, null, null, null)

        return c.count
}
}