package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class Practice10StrokeJoinView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = 40f
        style = Paint.Style.STROKE
    }
    private val path = Path().apply {
        rLineTo(200f, 0f)
        rLineTo(-160f, 120f)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()
        // 使用 Paint.setStrokeJoin() 来设置不同的拐角形状

        canvas.translate(100f, 100f)
        // 第一种形状：MITER
        paint.strokeJoin = Paint.Join.MITER
        canvas.drawPath(path, paint)

        canvas.translate(300f, 0f)
        // 第二种形状：BEVEL
        paint.strokeJoin = Paint.Join.BEVEL
        canvas.drawPath(path, paint)

        canvas.translate(300f, 0f)
        // 第三种形状：ROUND
        paint.strokeJoin = Paint.Join.ROUND
        canvas.drawPath(path, paint)

        canvas.restore()
    }
}
