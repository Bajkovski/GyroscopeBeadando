package com.example.accelerobeadanado

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
   var data = FloatArray(3)




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
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this, sensor)
    }
    override fun onSensorChanged(p0: SensorEvent?) {
        if (p0?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
            if (p0?.values != null) {
                mycanvas.data = p0.values
                textView.text ="x: "+p0.values[0].toString()+"\n"+"y: "+p0.values[1].toString()+"\n"+"z: "+p0.values[2].toString()

                mycanvas.invalidate()
            }
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }


}

