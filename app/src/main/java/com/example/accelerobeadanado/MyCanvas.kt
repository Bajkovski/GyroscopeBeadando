package com.example.accelerobeadanado

import android.content.Context
import android.content.Context.SENSOR_SERVICE
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.AttributeSet
import android.view.View
import kotlin.random.Random
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService

class MyCanvas @JvmOverloads constructor(
    context: Context, attr: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attr, defStyleAttr) {
    var data = FloatArray(3)
    var movex: Float = 0f
    var movey: Float = 0f
    val paint: Paint = Paint()



    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.color = Color.RED
        paint.style = Paint.Style.FILL

        movex = movex - data[0] * 0.5f
        movey = movey + data[1] * 0.5f

        if (movey > height) {
            movey = movey - data[1]
        }
        if (movex > width) {
            movex = movex + data[0]
        }
        if (movey < 0) {
            movey = movey - data[1]
        }
        if (movex < 0) {
            movex = movex + data[0]
        }
        canvas.drawCircle(movex, movey, 50f, paint)


    }




}