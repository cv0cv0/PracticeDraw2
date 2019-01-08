package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class Practice12PathEffectView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply { style = Paint.Style.STROKE }
    private val path = Path().apply {
        moveTo(50f, 100f)
        rLineTo(50f, 100f)
        rLineTo(80f, -150f)
        rLineTo(100f, 100f)
        rLineTo(70f, -120f)
        rLineTo(150f, 80f)
    }

    private val cornerPathEffect = CornerPathEffect(20f)
    private val discretePathEffect = DiscretePathEffect(20f, 5f)
    private val dashPathEffect = DashPathEffect(floatArrayOf(20f, 10f, 5f, 10f), 0f)
    private val dashPath = Path().apply {
        lineTo(30f, 0f)
        lineTo(15f, 30f)
        close()
    }
    private val pathDashPathEffect = PathDashPathEffect(dashPath, 50f, 0f, PathDashPathEffect.Style.TRANSLATE)
    private val sumPathEffect = SumPathEffect(dashPathEffect, discretePathEffect)
    private val composePathEffect = ComposePathEffect(dashPathEffect, discretePathEffect)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect
        paint.pathEffect = cornerPathEffect
        canvas.drawPath(path, paint)

        canvas.save()
        canvas.translate(500f, 0f)
        // 第二处：DiscretePathEffect
        paint.pathEffect = discretePathEffect
        canvas.drawPath(path, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(0f, 200f)
        // 第三处：DashPathEffect
        paint.pathEffect = dashPathEffect
        canvas.drawPath(path, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(500f, 200f)
        // 第四处：PathDashPathEffect
        paint.pathEffect = pathDashPathEffect
        canvas.drawPath(path, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(0f, 400f)
        // 第五处：SumPathEffect
        paint.pathEffect = sumPathEffect
        canvas.drawPath(path, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(500f, 400f)
        // 第六处：ComposePathEffect
        paint.pathEffect = composePathEffect
        canvas.drawPath(path, paint)
        canvas.restore()
    }
}
