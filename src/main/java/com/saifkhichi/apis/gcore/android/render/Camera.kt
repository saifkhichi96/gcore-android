package com.saifkhichi.apis.gcore.android.render

import com.saifkhichi.apis.gcore.physics.RigidBody
import kotlin.math.ceil


class Camera(velocity: Float, left: Float, right: Float, bottom: Float, top: Float) {

    private val left: Float
    private val right: Float
    private val bottom: Float
    private val top: Float

    var offset: Float = 0f
        private set

    var lastTranslation: Float = 0f
        private set

    private var s = 0f
    private var velocity = 0f

    private var body: RigidBody? = null

    init {
        setVelocity(velocity)
        this.left = left
        this.right = right
        this.bottom = bottom
        this.top = top
    }

    fun attachTo(body: RigidBody) {
        this.body = body
    }

    fun setVelocity(velocity: Float) {
        this.velocity = velocity
    }

    private fun limitBoundsY(): Boolean {
        body?.let { body ->
            if (body.isBelow(top)) {
                body.putOn(top)
                return true
            } else if (body.isAbove(bottom)) {
                body.putOn(body.height.toFloat())
                return true
            }
        }
        return false
    }

    private fun limitBoundsX(): Boolean {
        if (offset < left) {
            lastTranslation = 0f
            offset = left
            return true
        } else if (offset > right) {
            lastTranslation = 0f
            offset = right
            return true
        }
        return false
    }

    fun update(elapsedTime: Long): Boolean {
        lastTranslation = ceil((s * elapsedTime))
        offset += lastTranslation
        limitBoundsY()
        return limitBoundsX()
    }

    fun stop() {
        s = 0.0f
    }

    fun panLeft() {
        s = -velocity
    }

    fun panRight() {
        s = velocity
    }

    fun rollback() {
        offset -= lastTranslation
        s = 0.0f
    }
}