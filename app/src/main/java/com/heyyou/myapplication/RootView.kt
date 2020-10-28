package com.heyyou.myapplication

import android.content.Context
import android.util.AttributeSet

/**
 * Top level view for {@link RootBuilder.RootScope}.
 */
class RootView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : InsetAwareFrameLayout(context, attrs, defStyle), RootInteractor.RootPresenter, FullScreenView
