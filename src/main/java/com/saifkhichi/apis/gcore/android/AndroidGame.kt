package com.saifkhichi.apis.gcore.android

import com.saifkhichi.apis.gcore.BaseGame
import com.saifkhichi.apis.gcore.android.render.AndroidScene
import com.saifkhichi.apis.gcore.android.render.GameActivity
import com.saifkhichi.apis.gcore.render.Scene

/**
 * A game implementation for Android.
 *
 * @property activity The game activity in which this android game runs.
 *
 * @constructor Creates a new android game with the given refresh rate.
 * @param fps      The refresh rate (in frames per second) of the game
 * @param activity the game activity in which this game runs
 *
 * @author Saif Khan<saifkhichi96@gmail.com>
 */
abstract class AndroidGame(fps: Int, private val activity: GameActivity) : BaseGame(fps) {

    override fun startScene(sceneClass: Class<out Scene>) {
        super.startScene(sceneClass)
        val scene = activeScene as AndroidScene
        scene.activity = activity
        activity.runOnUiThread { scene.onStart() }
    }

    override fun update(elapsedTime: Long) {
        activity.runOnUiThread { super.update(elapsedTime) }
    }

    override fun onDraw() {
        activity.runOnUiThread { super.onDraw() }
    }
}