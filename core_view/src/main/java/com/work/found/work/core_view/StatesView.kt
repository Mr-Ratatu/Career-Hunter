package com.work.found.work.core_view

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import kotlinx.coroutines.*

enum class States {
    LOADING, SUCCESS, ERROR
}

class StatesView @JvmOverloads constructor(
    context: Context,
    attrStyle: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrStyle, defStyle) {

    companion object {
        private const val SPIN_DURATION = 300L
        private const val ONE_SECONDS = 1000L
    }

    private val stateName = ContentView<TextView>(R.id.state_tv_name, this)
    private val stateIcon = ContentView<ImageView>(R.id.state_iv_icon, this)

    private val coroutineScope = CoroutineScope(Job() + Dispatchers.Main.immediate)

    private val iconRotationAnimation = ValueAnimator.ofFloat(0f, 360f)
    private val hideViewAnimation = ValueAnimator.ofInt(measuredHeight, 0)
    private var rotationAnimationListener: RotationAnimationListener
    private var hideAnimationListener: HideAnimationListener

    init {
        LayoutInflater.from(context).inflate(R.layout.states_layout, this)
        rotationAnimationListener = RotationAnimationListener()
        hideAnimationListener = HideAnimationListener()
        iniRotationAnim()
    }

    private fun iniRotationAnim() {
        iconRotationAnimation.apply {
            interpolator = LinearInterpolator()
            repeatCount = Animation.INFINITE
            duration = SPIN_DURATION
            start()
        }
    }

    private fun startHeightAnim() {
        hideViewAnimation.apply {
            interpolator = LinearInterpolator()
            duration = SPIN_DURATION
            start()
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        iconRotationAnimation.addUpdateListener(rotationAnimationListener)
        hideViewAnimation.addUpdateListener(hideAnimationListener)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        coroutineScope.cancel()
        iconRotationAnimation.removeAllUpdateListeners()
        hideViewAnimation.removeAllUpdateListeners()
    }

    fun updateState(state: States) {
        when (state) {
            States.LOADING -> setLoadingState()
            States.SUCCESS -> setSuccessState()
            States.ERROR -> setErrorState()
        }
    }

    private fun setLoadingState() {
        stateIcon { setImageResource(R.drawable.ic_loading) }
        stateName { text = resources.getString(R.string.loading_state) }

    }

    private fun setSuccessState() {
        iconRotationAnimation.end()
        stateIcon { setImageResource(R.drawable.ic_success) }

        stateName {
            text = resources.getString(R.string.success_state)
            setTextColor(resources.getColor(R.color.positive, null))
        }
        coroutineScope.launch {
            delay(ONE_SECONDS)
            visibility = View.GONE
        }
        startHeightAnim()
    }

    private fun setErrorState() {
        iconRotationAnimation.end()
        stateIcon { setImageResource(R.drawable.ic_error) }

        stateName {
            text = resources.getString(R.string.error_state)
            setTextColor(resources.getColor(R.color.negative, null))
        }
    }

    private inner class RotationAnimationListener : ValueAnimator.AnimatorUpdateListener {

        override fun onAnimationUpdate(animator: ValueAnimator) {
            stateIcon { rotation = animator.animatedValue as Float }
        }
    }

    private inner class HideAnimationListener : ValueAnimator.AnimatorUpdateListener {

        override fun onAnimationUpdate(animator: ValueAnimator) {
            this@StatesView.layoutParams.height = animator.animatedValue as Int
            requestLayout()
        }
    }
}