package com.heyyou.myapplication.coordinator

import android.content.Context
import android.util.AttributeSet
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.coordinator_rib.view.*

/**
 * Top level view for {@link CoordinatorBuilder.CoordinatorScope}.
 */
class CoordinatorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : CoordinatorLayout(context, attrs, defStyle), CoordinatorInteractor.CoordinatorPresenter {
    override fun onFinishInflate() {
        super.onFinishInflate()
        val controller = CoordinatorEpoxyController()
        venuemenu_rib_recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        venuemenu_rib_recycler.adapter = controller.adapter
        controller.requestModelBuild()
    }

    override fun info() = RxView.clicks(venuemenu_rib_info).map {}!!

}
