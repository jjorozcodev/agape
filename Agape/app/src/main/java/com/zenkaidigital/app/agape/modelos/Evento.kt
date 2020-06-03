package com.zenkaidigital.app.agape.modelos

data class Evento (
    val id : Long,
    val publicadorCod : String,
    val programaCod : String,
    val nombre : String,
    val descripcion : String,
    val fecha : String,
    val hora : String,
    val eventoUrl : String,
    val imagenUrl : String
)
