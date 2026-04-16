package com.ludogame.android.presentation.ui.utils

import android.animation.ValueAnimator
import android.view.View

object AnimationHelper {
    fun pulse(view: View, duration: Long = 300L) {
        ValueAnimator.ofFloat(1f, 1.1f, 1f).apply {
            this.duration = duration
            addUpdateListener { value ->
                val scale = value.animatedValue as Float
                view.scaleX = scale
                view.scaleY = scale
            }
        }.start()
    }
}
