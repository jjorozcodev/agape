package com.zenkaidigital.app.agape

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zenkaidigital.app.agape.servicio.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(3000)

        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val citas: Array<String>

        citas = resources.getStringArray(R.array.citas_biblicas_random)

        val citaPos = rand(0, citas.size - 1)
        val citaSeccionada = citas[citaPos].split("#").toTypedArray()

        tvTexto.setText("Cita Bíblica: " + citaSeccionada[0] + "\nVersículo: " + citaSeccionada[1])

        val inst = RestApi.instancia()

        val myCall : Call<List<Publicador>> = inst.obtenerPublicadores("AGAPE")

        myCall.enqueue(object : Callback<List<Publicador>>{
            override fun onFailure(call: Call<List<Publicador>>, t: Throwable) {
                Log.d("TEST", t.message!!)
            }

            override fun onResponse(call: Call<List<Publicador>>, response: Response<List<Publicador>>) {
                val pub : List<Publicador> = response.body()!!

                val resp : String = "C> " + pub[0].cod +" N> " + pub[0].nombre + " D> " + pub[0].descripcion + " A> " + pub[0].ultimaActualizacion

                Toast.makeText(applicationContext, "RESPUESTA SERVICIO> $resp", Toast.LENGTH_SHORT).show()

            }
        }
        )
    }

    fun rand(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument" }
        val rand = Random(System.nanoTime())
        return (start..end).random(rand)
    }
}
