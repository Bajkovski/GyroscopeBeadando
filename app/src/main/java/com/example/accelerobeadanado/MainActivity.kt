package com.example.accelerobeadanado

import android.content.res.Configuration
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Display
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(),SensorEventListener {
    private lateinit var mycanvas: MyCanvas
    private lateinit var sensorManager: SensorManager
    private lateinit var sensorAcc: Sensor
    private lateinit var sensorLight: Sensor
    private lateinit var textView: TextView
    private lateinit var textView2: TextView
    var data = FloatArray(3)




    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        mycanvas=findViewById(R.id.draw_field)
        textView=findViewById(R.id.textView)
        textView2=findViewById(R.id.textView2)
        //val height = display!!.height
        //val width = display!!.width
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager


        sensorAcc = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        sensorLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

        mycanvas.movex= (display!!.width)/2f
        mycanvas.movey= (display!!.height)/2f

        //sensorManagerAcc.registerListener(this, sensorAcc, SensorManager.SENSOR_DELAY_FASTEST)
        //sensorManagerLight.registerListener(this, sensorLight, SensorManager.SENSOR_STATUS_ACCURACY_LOW)

    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, sensorAcc, SensorManager.SENSOR_DELAY_FASTEST)
        sensorManager.registerListener(this, sensorLight, SensorManager.SENSOR_DELAY_FASTEST)

    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this, sensorAcc)
        sensorManager.unregisterListener(this, sensorLight)
    }
    override fun onSensorChanged(p0: SensorEvent?) {
        if (p0?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
            if (p0.values != null) {
                mycanvas.dataAcc = p0.values
                textView.text ="x: "+p0.values[0].toString()+"\n"+"y: "+p0.values[1].toString()+"\n"+"z: "+p0.values[2].toString()


            }
        }
        if (p0?.sensor?.type== Sensor.TYPE_LIGHT) {
            if (p0.values != null) {
                mycanvas.dataLight=p0.values[0]
                textView2.text=p0.values[0].toString()

            }
        }
        mycanvas.invalidate()
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }


}

