package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class Practice12PathEffectView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var path = Path()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        paint.style = Paint.Style.STROKE

        path.moveTo(50f, 100f)
        path.rLineTo(50f, 100f)
        path.rLineTo(80f, -150f)
        path.rLineTo(100f, 100f)
        path.rLineTo(70f, -120f)
        path.rLineTo(150f, 80f)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect
        canvas.drawPath(path, paint)

        canvas.save()
        canvas.translate(500f, 0f)
        // 第二处：DiscretePathEffect
        canvas.drawPath(path, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(0f, 200f)
        // 第三处：DashPathEffect
        canvas.drawPath(path, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(500f, 200f)
        // 第四处：PathDashPathEffect
        canvas.drawPath(path, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(0f, 400f)
        // 第五处：SumPathEffect
        canvas.drawPath(path, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(500f, 400f)
        // 第六处：ComposePathEffect
        canvas.drawPath(path, paint)
        canvas.restore()
    }
}
