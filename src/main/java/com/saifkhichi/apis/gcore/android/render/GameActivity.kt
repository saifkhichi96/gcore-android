package com.saifkhichi.apis.gcore.android.render

import android.app.Activity
import android.graphics.Point
import android.os.Bundle
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.saifkhichi.apis.gcore.android.AndroidGame

abstract class GameActivity : Activity() {

    /**
     * The root container in which all game scenes are inflated.
     */
    lateinit var root: RelativeLayout

    /**
     * The game.
     */
    private lateinit var game: AndroidGame

    /**
     * The screen dimensions.
     */
    var screenSize = Point()

    override fun onCreate(savedInstanceState: Bundle?) {
        // Enable fullscreen game mode (no title bar, no status bar)
        window.decorView.systemUiVisibility = ViewGroup.SYSTEM_UI_FLAG_FULLSCREEN or
                ViewGroup.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                ViewGroup.SYSTEM_UI_FLAG_IMMERSIVE_STICKY


        super.onCreate(savedInstanceState)
        root = RelativeLayout(this)
        root.layoutParams = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT)
        setContentView(root)

        // Get window size
        windowManager.defaultDisplay.getSize(screenSize)

        game = init()
        start(game)
    }

    protected abstract fun init(): AndroidGame

    private fun start(game: AndroidGame) {
        this.game = game
        this.game.start()
    }

    override fun onBackPressed() {
        game.currentScene?.onStop()
    }

}