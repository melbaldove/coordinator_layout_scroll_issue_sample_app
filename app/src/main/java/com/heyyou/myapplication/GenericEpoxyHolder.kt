package com.heyyou.myapplication

import android.view.View
import com.airbnb.epoxy.EpoxyHolder
import kotlinx.android.extensions.LayoutContainer

/**
 * @author Melby Baldove
 * melby@heyyou.com.au
 */
class GenericEpoxyHolder : EpoxyHolder(), LayoutContainer {
    override lateinit var containerView: View
    override fun bindView(itemView: View) {
        containerView = itemView
    }
}
