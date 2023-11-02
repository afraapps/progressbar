package ir.afraapps.widget.progressbar

import android.graphics.*
import android.graphics.drawable.Drawable

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 1/18/2022.
 */
class RainbowCircleProgress : Drawable() {

    private val paint: Paint
    private val boundRect: RectF
    private val colors: IntArray
    private val positions: FloatArray

    var progress = 0f
        set(value) {
            field = value
            invalidateSelf()
        }

    var thickness = 3f
        set(value) {
            field = value
            paint.strokeWidth = value
            prepareShader(bounds)
            invalidateSelf()
        }

    var width: Int = -1
    var height: Int = -1

    init {
        colors = intArrayOf(
            (0xFFFF0007).toInt(),
            (0xFFFF008F).toInt(),
            (0xFFFE00FE).toInt(),
            (0xFF8C00FF).toInt(),
            (0xFF0034FF).toInt(),
            (0xFF00B9FF).toInt(),
            (0xFF00FF7E).toInt(),
            (0xFF00FF00).toInt(),
            (0xFFFFF500).toInt()
        )
        positions = floatArrayOf(0f, 0.03f, 0.18f, 0.25f, 0.35f, 0.75f, 0.9f, 0.95f, 1f)
        boundRect = RectF()
        paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.STROKE
            color = Color.WHITE
            strokeWidth = thickness
            strokeCap = Paint.Cap.ROUND
            strokeJoin = Paint.Join.ROUND
        }
    }

    override fun onBoundsChange(bounds: Rect) {
        prepareShader(bounds)
    }

    private fun prepareShader(bounds: Rect) {
        val half = thickness / 2f
        boundRect.set(bounds.left + half, bounds.top + half, bounds.right - half, bounds.bottom - half)
        val centerY = boundRect.centerY()
        paint.shader = LinearGradient(
            boundRect.left,
            centerY,
            boundRect.right,
            centerY,
            colors,
            positions,
            Shader.TileMode.MIRROR
        )
    }


    override fun draw(canvas: Canvas) {
        val startAngle = -90f
        val sweepAngle = 360 * progress
        canvas.drawArc(boundRect, startAngle, sweepAngle, false, paint)
    }

    override fun setAlpha(alpha: Int) {

    }

    override fun setColorFilter(colorFilter: ColorFilter?) {

    }

    @Deprecated("Deprecated in Java")
    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }


}