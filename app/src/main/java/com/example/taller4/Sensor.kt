package com.example.taller4

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Sensor: AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var acelerometro: Sensor? = null
    private lateinit var btnVolver: Button
    private lateinit var imagen: ImageView
    private var activado = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sensor_activity)

        btnVolver = findViewById(R.id.btn_volver2)
        imagen = findViewById(R.id.imageView2)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        btnVolver.setOnClickListener{
            finish()
        }

    }

    private fun iniciar(){
        sensorManager.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_NORMAL)
        activado = true

    }

    private fun detener(){
        sensorManager.unregisterListener(this)
        activado = false
    }

    override fun onResume() {
        super.onResume()
        if (!activado) {
            iniciar()
            activado = true
        }
    }

    override fun onPause() {
        super.onPause()
        if (activado) {
            detener()
            activado = false
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event == null) return

        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]

            val movimiento = Math.sqrt((x * x + y * y + z * z).toDouble())

            if (movimiento > 1) {
                imagen.setBackgroundColor(resources.getColor(R.color.verdePastel))
            } else {
                imagen.setBackgroundColor(resources.getColor(R.color.white))
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
       // No se necesita implementar en este caso
    }

}