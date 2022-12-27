package com.work.found.routing.base

import androidx.fragment.app.FragmentTransaction
import com.work.found.routing.R

data class Animation(val enter: Int, val exit: Int, val popEnter: Int, val popExit: Int) {
    companion object {
        fun defaultAnimation() = Animation(
            R.anim.screen_open_enter,
            R.anim.screen_open_exit,
            R.anim.screen_close_enter,
            R.anim.screen_close_exit
        )

        fun scaleFadeAnimation() = Animation(
            R.anim.screen_scale_fade_enter,
            0,
            0,
            R.anim.screen_scale_fade_exit,
        )

        fun noAnimation() = Animation(0, 0, 0, 0)
        fun noPopAnimation() = Animation(R.anim.screen_open_enter, R.anim.screen_open_exit, 0, 0)
        fun fromBottomToTop() = Animation(
            R.anim.screen_open_enter_from_bottom_to_top,
            R.anim.screen_open_exit_from_bottom_to_top,
            0,
            0
        )
    }
}

internal fun FragmentTransaction.setCustomAnimations(anim: Animation) {
    this.setCustomAnimations(anim.enter, anim.exit, anim.popEnter, anim.popExit)
}