package com.example.accelerobeadanado


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.view.Surface
import android.view.View
import androidx.annotation.RequiresApi
import kotlin.math.absoluteValue

class MyCanvas @JvmOverloads constructor(
    context: Context, attr: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attr, defStyleAttr) {
    var dataAcc = FloatArray(3)
    var dataLight: Float = 0F
    var movex: Float = 0f
    var movey: Float = 0f
    val paint: Paint = Paint()


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onDraw(canvas: Canvas) {

        super.onDraw(canvas)


        if (dataLight < 200)
            paint.color = Color.RED
        if (dataLight > 200)
            paint.color = Color.BLUE
        if (dataLight < 100)
            paint.color = Color.rgb(
                dataAcc[0].absoluteValue,
                dataAcc[1].absoluteValue,
                dataAcc[2].absoluteValue
            )
        paint.style = Paint.Style.FILL

        if (display.rotation == Surface.ROTATION_0) {
            movex = movex - dataAcc[0] * 0.5f
            movey = movey + dataAcc[1] * 0.5f
        }
        if (display.rotation == Surface.ROTATION_90) {
            movex = movex + dataAcc[1] * 0.5f
            movey = movey + dataAcc[0] * 0.5f
        }
        if (display.rotation == Surface.ROTATION_270) {
            movex = movex - dataAcc[1] * 0.5f
            movey = movey - dataAcc[0] * 0.5f
        }

        if (movey + 50 > height) {
            movey = height.toFloat() - 50f
        }
        if (movex + 50 > width) {
            movex = width.toFloat() - 50f
        }
        if (movey - 50 < 0) {
            movey = 50f
        }
        if (movex - 50 < 0) {
            movex = 50f
        }
        canvas.drawCircle(movex, movey, 50f, paint)
        canvas.save()

    }


}