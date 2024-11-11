package com.example.taller4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class Saludo: AppCompatActivity() {
    private lateinit var btnInicio: Button
    private lateinit var texto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.saludo_activity)
        btnInicio = findViewById(R.id.btn_inicio)
        texto = findViewById(R.id.saludo)

        btnInicio.setOnClickListener {
            val intent = Intent(this, ActividadPrincipal::class.java)
            startActivity(intent)
        }

        val hora = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) //usamos una variable que guarde la hora en la que se esta haciendo uso de la aplicación
        val bienvenida = when {
            hora < 13 -> "Buenos días"
            hora < 20 -> "Buenas tardes"
            else -> "Buenas noches"
        }

        texto.text = "$bienvenida"

    }
}