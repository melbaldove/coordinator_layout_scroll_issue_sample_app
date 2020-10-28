package com.heyyou.myapplication

import com.heyyou.myapplication.coordinator.CoordinatorBuilder
import com.heyyou.myapplication.coordinator.CoordinatorRouter
import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link RootBuilder.RootScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class RootRouter(
    view: RootView,
    interactor: RootInteractor,
    component: RootBuilder.Component,
    private val coordinatorBuilder: CoordinatorBuilder
) : ViewRouter<RootView, RootInteractor, RootBuilder.Component>(view, interactor, component) {
    private var coordinatorRouter: CoordinatorRouter? = null
    fun attachCoordinator() {
        if(coordinatorRouter != null) return
        coordinatorRouter = coordinatorBuilder.build(view)
        view.addView(coordinatorRouter?.view)
        attachChild(coordinatorRouter)
    }

    fun detachCoordinator() {
        coordinatorRouter ?: return
        view.removeView(coordinatorRouter?.view)
        detachChild(coordinatorRouter)
        coordinatorRouter = null
    }

    override fun willDetach() {
        super.willDetach()
        detachCoordinator()
    }
}
