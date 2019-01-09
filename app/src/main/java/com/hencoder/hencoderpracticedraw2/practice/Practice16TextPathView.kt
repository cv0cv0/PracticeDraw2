package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class Practice16TextPathView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val pathPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val textPath = Path()
    private val text = "Hello HenCoder"

    init {
        paint.textSize = 120f
        // 使用 Paint.getTextPath() 来获取文字的 Path
        paint.getTextPath(text, 0, text.length, 50f, 400f, textPath)

        pathPaint.style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawText(text, 50f, 200f, paint)
        canvas.drawPath(textPath, pathPaint)
    }
}
