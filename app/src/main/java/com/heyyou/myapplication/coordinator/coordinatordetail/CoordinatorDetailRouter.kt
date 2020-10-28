package com.heyyou.myapplication.coordinator.coordinatordetail

import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link CoordinatorDetailBuilder.CoordinatorDetailScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class CoordinatorDetailRouter(
    view: CoordinatorDetailView,
    interactor: CoordinatorDetailInteractor,
    component: CoordinatorDetailBuilder.Component
) : ViewRouter<CoordinatorDetailView, CoordinatorDetailInteractor, CoordinatorDetailBuilder.Component>(
    view,
    interactor,
    component
)
