package com.example.gyroscopebeadanado

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.room.Update

class MyCanvas @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    val canvas: Canvas = Canvas()
    var speedx: Float = 0f
    var speedy: Float = 0f


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val posx: Float = canvas.width / 2F
        val posy: Float =canvas.height / 2F
        var movex: Float = posx+speedx
        var movey: Float = posy+speedy
        val paint : Paint = Paint()
        //paint.style=Paint.Style.STROKE
        //paint.strokeWidth=10f
        //canvas?.drawCircle(400f,600f,160f ,paint)
        paint.setColor(Color.RED)
        paint.style = Paint.Style.FILL

        var i: Int =0

    canvas!!.drawCircle( movex,  + movey, 30f, paint)
       if(canvas.width-30>movex)
        speedx += 10f
        if(canvas.height-34>movey)
        speedy += 10f
        invalidate()


    println(speedx)




        }
}

