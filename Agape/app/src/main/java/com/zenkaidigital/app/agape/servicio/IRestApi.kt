package com.zenkaidigital.app.agape.servicio

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IRestApi {
    @GET("publicadores")
    fun obtenerPublicadores(@Query("cod") codPublicador : String): Call<List<Publicador>>

    @GET("publicadores/{codPublicador}/programas")
    fun obtenerProgramas(@Path("codPublicador") codPublicador : String): Call<List<Programa>>

    @GET("publicadores/{codPublicador}/localidades")
    fun obtenerLocalidades(@Path("codPublicador") codPublicador : String): Call<List<Localidad>>

    @GET("publicadores/{codPublicador}/redes")
    fun obtenerRedesSociales(@Path("codPublicador") codPublicador : String): Call<List<RedSocial>>

    @GET("publicadores/{codPublicador}/eventos")
    fun obtenerEventos(@Path("codPublicador") codPublicador : String): Call<List<Evento>>
}