package com.zenkaidigital.app.agape.modelos

data class Publicador(
    val cod : String,
    val nombre : String,
    val descripcion : String,
    val telefono : String,
    val correoElectronico : String,
    val paginaWeb : String,
    val ultimaActualizacion : Long
)
