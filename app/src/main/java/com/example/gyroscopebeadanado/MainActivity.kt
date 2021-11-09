package com.example.gyroscopebeadanado

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(),SensorEventListener {
   private lateinit var mycanvas: MyCanvas
   private lateinit var sensorManager: SensorManager
   private lateinit var sensor: Sensor
   private lateinit var textView: TextView




    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        mycanvas=findViewById(R.id.draw_field)
        textView=findViewById(R.id.textView)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)


        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)


    }

    override fun onResume() {
        super.onResume()
        // csak akkor menjen a szenzor ha a user látja is a képernyőt
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        // ha a képernyő a háttérbe kerül akkor leiratkozunk
        sensorManager.unregisterListener(this, sensor)
    }
    override fun onSensorChanged(p0: SensorEvent?) {
        if (p0?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
            if (p0?.values != null) {
                mycanvas.data[0] = p0.values[0]
                mycanvas.data[1] = p0.values[1]
                mycanvas.data[2] = p0.values[2]

                //újrarakzolás
                mycanvas.invalidate()
            }
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }


}

