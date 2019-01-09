package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.BlurMaskFilter
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R

class Practice14MaskFilterView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = BitmapFactory.decodeResource(resources, R.drawable.what_the_fuck)

    private val normalMask = BlurMaskFilter(50f, BlurMaskFilter.Blur.NORMAL)
    private val innerMask = BlurMaskFilter(50f, BlurMaskFilter.Blur.INNER)
    private val outerMask = BlurMaskFilter(50f, BlurMaskFilter.Blur.OUTER)
    private val solidMask = BlurMaskFilter(50f, BlurMaskFilter.Blur.SOLID)

    init {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 用 Paint.setMaskFilter 来设置不同的 BlurMaskFilter

        // 第一个：NORMAL
        paint.maskFilter = normalMask
        canvas.drawBitmap(bitmap, 100f, 50f, paint)

        // 第二个：INNER
        paint.maskFilter = innerMask
        canvas.drawBitmap(bitmap, (bitmap.width + 200).toFloat(), 50f, paint)

        // 第三个：OUTER
        paint.maskFilter = outerMask
        canvas.drawBitmap(bitmap, 100f, (bitmap.height + 100).toFloat(), paint)

        // 第四个：SOLID
        paint.maskFilter = solidMask
        canvas.drawBitmap(bitmap, (bitmap.width + 200).toFloat(), (bitmap.height + 100).toFloat(), paint)
    }
}
