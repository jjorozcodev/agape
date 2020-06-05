package com.zenkaidigital.app.agape.servicio

import com.zenkaidigital.app.agape.App
import com.zenkaidigital.app.agape.R
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestApi {
    companion object{
        private val contexto = App.context
        private val URL = contexto?.resources!!.getString(R.string.rest_api_endpoint_root_url)

        fun instancia(): IRestApi {
            val retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create<IRestApi>(IRestApi::class.java)
        }
    }
}