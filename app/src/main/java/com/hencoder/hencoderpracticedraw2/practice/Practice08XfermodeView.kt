package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

import com.hencoder.hencoderpracticedraw2.R

class Practice08XfermodeView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.batman)
    private val bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)

    private val xfermode1 = PorterDuffXfermode(PorterDuff.Mode.SRC)
    private val xfermode2 = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
    private val xfermode3 = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 使用 paint.setXfermode() 设置不同的结合绘制效果

        // 别忘了用 canvas.saveLayer() 开启 off-screen buffer
        val saveLayer = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG)

        canvas.drawBitmap(bitmap1, 0f, 0f, paint)
        // 第一个：PorterDuff.Mode.SRC
        paint.xfermode = xfermode1
        canvas.drawBitmap(bitmap2, 0f, 0f, paint)
        paint.xfermode = null

        canvas.drawBitmap(bitmap1, (bitmap1.width + 100).toFloat(), 0f, paint)
        // 第二个：PorterDuff.Mode.DST_IN
        paint.xfermode = xfermode2
        canvas.drawBitmap(bitmap2, (bitmap1.width + 100).toFloat(), 0f, paint)
        paint.xfermode = null

        canvas.drawBitmap(bitmap1, 0f, (bitmap1.height + 20).toFloat(), paint)
        // 第三个：PorterDuff.Mode.DST_OUT
        paint.xfermode = xfermode3
        canvas.drawBitmap(bitmap2, 0f, (bitmap1.height + 20).toFloat(), paint)
        paint.xfermode = null

        // 用完之后使用 canvas.restore() 恢复 off-screen buffer
        canvas.restoreToCount(saveLayer)
    }
}
