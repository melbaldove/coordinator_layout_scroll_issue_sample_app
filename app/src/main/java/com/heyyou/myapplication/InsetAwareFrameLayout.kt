package com.heyyou.myapplication

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.WindowInsets
import android.widget.FrameLayout

/**
 * @author Melby Baldove
 * melby@heyyou.com.au
 */
open class InsetAwareFrameLayout @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    protected var insets: WindowInsets? = null
    override fun onApplyWindowInsets(insets: WindowInsets): WindowInsets {
        val childCount = childCount
        this.insets = insets
        for (index in 0 until childCount)
            getChildAt(index).dispatchApplyWindowInsets(insets) // let children know about WindowInsets
        return insets
    }

    override fun onViewAdded(child: View) {
        insets?.let(child::dispatchApplyWindowInsets)
        super.onViewAdded(child)
    }
}
