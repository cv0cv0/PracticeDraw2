package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.LightingColorFilter
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R

class Practice06LightingColorFilterView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)
    private val colorFilter1 = LightingColorFilter(0x00ffff, 0x000000)
    private val colorFilter2 = LightingColorFilter(0xffffff, 0x003000)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter

        // 第一个 LightingColorFilter：去掉红色部分
        paint.colorFilter = colorFilter1
        canvas.drawBitmap(bitmap, 0f, 0f, paint)

        // 第二个 LightingColorFilter：增强绿色部分
        paint.colorFilter = colorFilter2
        canvas.drawBitmap(bitmap, (bitmap.width + 100).toFloat(), 0f, paint)
    }
}
