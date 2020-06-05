package com.zenkaidigital.app.agape.servicio

data class Publicador(
    val cod : String,
    val nombre : String,
    val descripcion : String,
    val telefono : String,
    val correoElectronico : String,
    val paginaWeb : String,
    val ultimaActualizacion : Long
)

data class Programa(
    val publicadorCod : String,
    val cod : String,
    val nombre : String,
    val descripcion : String
)

data class Localidad (
    val publicadorCod : String,
    val nombre : String,
    val ciudad : String,
    val sector : String,
    val direccion : String,
    val latitud : Float,
    val longitud : Float
)

data class RedSocial(
    val publicadorCod : String,
    val red : String,
    val perfil : String,
    val url : String
)

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
