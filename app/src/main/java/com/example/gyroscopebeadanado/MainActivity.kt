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
    lateinit var mycanvas: MyCanvas
    lateinit var sensorManager: SensorManager
    lateinit var sensor: Sensor
    lateinit var textView: TextView
    lateinit var acceleroHandler: AcceleroEventHandler



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        mycanvas=findViewById(R.id.draw_field)
        textView=findViewById(R.id.textView)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)


        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)




    }

    override fun onSensorChanged(p0: SensorEvent?) {
        if (p0?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
            if (p0?.values != null) {

            }
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }


}

