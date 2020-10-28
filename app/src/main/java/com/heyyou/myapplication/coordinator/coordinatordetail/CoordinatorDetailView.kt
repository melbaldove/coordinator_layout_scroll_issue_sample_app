package com.heyyou.myapplication.coordinator.coordinatordetail

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.coordinatordetail_rib.view.*

/**
 * Top level view for {@link CoordinatorDetailBuilder.CoordinatorDetailScope}.
 */
class CoordinatorDetailView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle),
    CoordinatorDetailInteractor.CoordinatorDetailPresenter {
    override fun back() = RxView.clicks(coordinatordetail_rib_back).map {}!!
    fun setLightStatusBar(view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            var flags = view.systemUiVisibility
            flags = flags or SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            view.systemUiVisibility = flags
        }
    }
}

