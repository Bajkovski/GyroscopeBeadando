package com.example.accelerobeadanado

import android.content.Context
import android.content.Context.SENSOR_SERVICE
import android.content.res.Configuration
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import kotlin.random.Random
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService

class MyCanvas @JvmOverloads constructor(
    context: Context, attr: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attr, defStyleAttr) {
    var dataAcc = FloatArray(3)

    var dataLight : Float =0F
    var movex: Float = 0f
    var movey: Float = 0f
    val paint: Paint = Paint()



    override fun onDraw(canvas: Canvas) {

        super.onDraw(canvas)
        canvas.drawCircle(movex, movey, 50f, paint)
        println(    movex)
        if(dataLight<200)
        paint.color = Color.RED
        if(dataLight>200)
            paint.color = Color.BLUE
        paint.style = Paint.Style.FILL


        movex = movex - dataAcc[0] * 0.5f
        movey = movey + dataAcc[1] * 0.5f

        if (movey > height) {
            movey = height.toFloat()
        }
        if (movex > width) {
            movex = width.toFloat()
        }
        if (movey < 0) {
            movey = 0f
        }
        if (movex < 0) {
            movex = 0f
        }

        canvas.save()

    }




}