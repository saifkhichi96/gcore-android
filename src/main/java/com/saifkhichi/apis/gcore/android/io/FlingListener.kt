package com.saifkhichi.apis.gcore.android.io

import android.view.GestureDetector
import android.view.MotionEvent

abstract class FlingListener : GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    override fun onSingleTapConfirmed(e: MotionEvent) = false

    override fun onDoubleTap(e: MotionEvent) = false

    override fun onDoubleTapEvent(e: MotionEvent) = false

    override fun onDown(e: MotionEvent) = false

    override fun onShowPress(e: MotionEvent) {}

    override fun onSingleTapUp(e: MotionEvent) = false

    override fun onLongPress(e: MotionEvent) {}

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float) = false

    abstract override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean

}