package com.example.slidingbutton

import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import androidx.core.os.postDelayed


class SlidingButton(
    val screenWidth: Int,
    val screenHeight: Int,
    callbackReturnValue: CallbackReturnValue
) : View.OnTouchListener {
    private var dX: Float = 0f
    var mCallbackReturnValue = callbackReturnValue
    override fun onTouch(view: View, event: MotionEvent): Boolean {
        var newX: Float
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                dX = view.x - event.rawX
            }
            MotionEvent.ACTION_MOVE -> {

                newX = event.rawX + dX
                if ((newX <= 0 || newX >= screenWidth - view.width)) {
                    view.animate()
                        .x(newX)
                        .setDuration(0)
                        .start()

                    mCallbackReturnValue.backValue(newX)
                    Handler(Looper.getMainLooper()).postDelayed(0) {
                        newX = 180f
                        view.animate()
                            .x(newX)
                            .setDuration(1000/2)
                            .start()
                    }
                    return true
                }
            }
        }
        return true
    }
}