package com.saifkhichi.apis.gcore.android.render

import android.content.Context
import android.graphics.Point
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import com.saifkhichi.apis.gcore.android.AndroidGame
import com.saifkhichi.apis.gcore.render.Scene

/**
 * A scene in the Android game.
 */
abstract class AndroidScene(game: AndroidGame) : Scene(game) {

    lateinit var activity: GameActivity

    protected val context: Context get() = activity.applicationContext

    protected val screenSize: Point get() = activity.screenSize

    protected fun setContentView(@LayoutRes layoutId: Int) {
        activity.root.let { root ->
            View.inflate(activity, layoutId, root)
        }
    }

    protected fun findViewById(@IdRes resId: Int): View? {
        return activity.root.findViewById(resId)
    }

    protected fun addView(view: View) {
        activity.root.addView(view)
    }

    override fun onStop() {
        onBackPressed()
    }

    open fun onBackPressed() {
        finish()
    }

    protected fun finish() {
        game.end()
        activity.finish()
    }

}