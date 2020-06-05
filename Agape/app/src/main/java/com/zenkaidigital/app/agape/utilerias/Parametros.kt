package com.zenkaidigital.app.agape.utilerias

import android.content.Context
import android.content.SharedPreferences
import com.zenkaidigital.app.agape.App
import com.zenkaidigital.app.agape.R
import java.lang.StringBuilder

object Parametros {
    val contexto : Context = App.context!!

    val APP_PARAMS : String = contexto.getString(R.string.app_name)

    var USUARIO : String? = null
    private var SUSCRIPCIONES : String? = APP_PARAMS
    var TOPICOS : List<String>? = null

    var ULTIMA_ACTUALIZACION : Int = 0

    private var preferencias : SharedPreferences? = null

    fun ObtenerParametros(){
        preferencias = contexto.getSharedPreferences(APP_PARAMS, 0)

        USUARIO = preferencias!!.getString(::USUARIO.name, USUARIO)
        SUSCRIPCIONES = preferencias!!.getString(::SUSCRIPCIONES.name, SUSCRIPCIONES)
        ULTIMA_ACTUALIZACION = preferencias!!.getInt(::ULTIMA_ACTUALIZACION.name, ULTIMA_ACTUALIZACION)

        ConvertirTopicos()
    }

    fun ActualizarParametros(){
        val editor : SharedPreferences.Editor = preferencias!!.edit()

        editor.putString(::USUARIO.name, USUARIO)
        editor.putString(::SUSCRIPCIONES.name, SUSCRIPCIONES)
        editor.putInt(::ULTIMA_ACTUALIZACION.name, ULTIMA_ACTUALIZACION)

        editor.apply()
    }

    private fun ConvertirTopicos(){
        TOPICOS = SUSCRIPCIONES!!.split("#").toList()
    }

    fun ActualizarTopicos(topicos : List<String>){
        val suscripciones = StringBuilder()
        suscripciones.append(APP_PARAMS)

        topicos.forEach{
            suscripciones.append("#")
            suscripciones.append(it)
        }

        SUSCRIPCIONES = suscripciones.toString()
        ConvertirTopicos()
    }

    fun ListarTopicos() : List<String>{
        return TOPICOS!!
    }
}