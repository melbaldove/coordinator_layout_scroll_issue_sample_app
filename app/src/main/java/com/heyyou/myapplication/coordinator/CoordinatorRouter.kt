package com.heyyou.myapplication.coordinator

import android.view.ViewGroup
import com.heyyou.myapplication.coordinator.coordinatordetail.CoordinatorDetailBuilder
import com.heyyou.myapplication.coordinator.coordinatordetail.CoordinatorDetailRouter
import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link CoordinatorBuilder.CoordinatorScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class CoordinatorRouter(
    view: CoordinatorView,
    interactor: CoordinatorInteractor,
    component: CoordinatorBuilder.Component,
    private val fullScreenView: ViewGroup,
    private val coordinatorDetailBuilder: CoordinatorDetailBuilder
) : ViewRouter<CoordinatorView, CoordinatorInteractor, CoordinatorBuilder.Component>(
    view,
    interactor,
    component
) {
    private var coordinatorDetailRouter: CoordinatorDetailRouter? = null
    fun attachCoordinatorDetail() {
        if(coordinatorDetailRouter!= null) return
        coordinatorDetailRouter = coordinatorDetailBuilder.build(fullScreenView)
        fullScreenView.addView(coordinatorDetailRouter?.view)
        coordinatorDetailRouter?.view?.run { setLightStatusBar(this) }
        attachChild(coordinatorDetailRouter)
    }

    fun detachCoordinatorDetail() {
        coordinatorDetailRouter ?: return
        detachChild(coordinatorDetailRouter)
        fullScreenView.removeView(coordinatorDetailRouter?.view)
        coordinatorDetailRouter = null
    }

    override fun willDetach() {
        super.willDetach()
        detachCoordinatorDetail()
    }
}
