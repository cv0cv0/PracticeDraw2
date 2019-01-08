package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R

class Practice05ComposeShaderView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null) // 硬件加速下 ComposeShader 不能使用两个同类型的 Shader
        // 用 Paint.setShader(shader) 设置一个 ComposeShader
        // Shader 1: BitmapShader 图片：R.drawable.batman
        // Shader 2: BitmapShader 图片：R.drawable.batman_logo
        val bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.batman)
        val bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)
        val shader1 = BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        val shader2 = BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        val composeShader = ComposeShader(shader1, shader2, PorterDuff.Mode.DST_OUT)
        paint.shader = composeShader
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(200f, 200f, 200f, paint)
    }
}
