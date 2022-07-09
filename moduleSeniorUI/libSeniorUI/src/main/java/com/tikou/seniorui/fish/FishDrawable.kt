package com.tikou.seniorui.fish

import android.graphics.*
import android.graphics.drawable.Drawable
import kotlin.math.cos
import kotlin.math.sin

/**

 * @Author Administrator
 * @Date 2022/6/22-12:35
 * @Email wangweitikou1994@gmail.com
 * @Des 游动的小鱼
 */
class FishDrawable : Drawable() {
    private var mPath: Path = Path()
    private var mPaint: Paint = Paint()
    private val OTHER_ALPHA: Int = 110

    // 鱼头基准半径
    private val HEAD_RADIUS: Float = 100F

    // 鱼的重心
    private val mMiddlePointF: PointF
        get() = PointF(4.2F * HEAD_RADIUS, 4.2F * HEAD_RADIUS)

    //鱼头朝向
    private val fishMainAngle: Float = 0F

    //鱼头半径
    private val fishBodyLength: Float = HEAD_RADIUS * 3.2F

    //鱼鳍长度(起始点)
    private val findFishStarLength: Float = HEAD_RADIUS * 0.9F

    //鱼鳍长度()
    private val findFishLength: Float = HEAD_RADIUS * 1.3F

    init {
        mPaint.style = Paint.Style.FILL
        mPaint.isAntiAlias = true
        mPaint.isDither = true
        mPaint.setARGB(OTHER_ALPHA, 244, 92, 71)
    }

    override fun draw(canvas: Canvas) {
        // 鱼头角度
        val fishAngle = fishMainAngle;
        //鱼头圆心坐标
        val headPoint: PointF = calculatePoint(mMiddlePointF, fishBodyLength / 2, fishAngle)
        canvas.drawCircle(headPoint.x, headPoint.y, HEAD_RADIUS, mPaint)
        //鱼鳍右
        val rightFishPoint: PointF = calculatePoint(headPoint, findFishStarLength, fishAngle - 110F)
        makeFish(canvas, rightFishPoint, fishAngle, true)
        //鱼鳍左
        val leftFishPoint: PointF = calculatePoint(headPoint, findFishStarLength, fishAngle + 110F)
        makeFish(canvas, leftFishPoint, fishAngle, false)

    }

    private fun makeFish(
        canvas: Canvas,
        rightFishPoint: PointF,
        fishAngle: Float,
        isRight: Boolean
    ) {
        val controlAngle: Float = 115F
        //终点
        val endPointF = calculatePoint(rightFishPoint, findFishLength, fishAngle - 180)
        //控制点
        val controlPointF =
            calculatePoint(
                rightFishPoint, findFishLength * 1.8F,
                if (isRight) fishAngle - controlAngle else fishAngle + controlAngle
            )
        mPath.reset()
        mPath.moveTo(rightFishPoint.x, rightFishPoint.y)
        mPath.quadTo(controlPointF.x, controlPointF.y, endPointF.x, endPointF.y)
        canvas.drawPath(mPath, mPaint)

    }

    private fun calculatePoint(startPoint: PointF, length: Float, angle: Float): PointF {
        val deltaX: Float = (cos(Math.toRadians(angle.toDouble())) * length).toFloat()
        val deltaY: Float = (sin(Math.toRadians((angle - 180).toDouble())) * length).toFloat()
        return PointF(startPoint.x + deltaX, startPoint.y + deltaY)
    }

    override fun setAlpha(alpha: Int) {
        mPaint.alpha = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        mPaint.colorFilter = colorFilter
    }

    @Deprecated(
        "Deprecated in Java",
        ReplaceWith("PixelFormat.TRANSLUCENT", "android.graphics.PixelFormat")
    )
    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

    override fun getIntrinsicWidth(): Int {
        return (8.4F * HEAD_RADIUS).toInt()
    }

    override fun getIntrinsicHeight(): Int {
        return (8.4F * HEAD_RADIUS).toInt()
    }
}