package com.saifkhichi.apis.gcore.android

import android.graphics.Point
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation

/**
 * AnimationPlayer provides an interface for playing some common animations.
 *
 * @author Saif Khan<saifkhichi96></saifkhichi96>@gmail.com>
 * @version 1.0
 */
object AnimationPlayer {
    /**
     * Animates and translates a view from a starting point to an ending point on screen.
     *
     * @param object   the view to be translated
     * @param from     coordinates of the initial point
     * @param to       coordinates of the final point
     * @param duration duration of the translation animation
     * @param callback callback object to be invoked when animation finishes
     */
    fun translateAnimation(
        `object`: View,
        from: Point,
        to: Point,
        duration: Int,
        callback: Animation.AnimationListener?,
    ) {
        val move = TranslateAnimation(from.x.toFloat(), to.x.toFloat(), from.y.toFloat(), to.y.toFloat())
        move.duration = duration.toLong()
        move.setAnimationListener(callback)
        move.fillAfter = true
        `object`.startAnimation(move)
    }
}