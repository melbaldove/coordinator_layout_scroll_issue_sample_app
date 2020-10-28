package com.heyyou.myapplication.coordinator.coordinatordetail

import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

/**
 * Coordinates Business Logic for [CoordinatorDetailScope].
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
class CoordinatorDetailInteractor :
    Interactor<CoordinatorDetailInteractor.CoordinatorDetailPresenter, CoordinatorDetailRouter>() {

    @Inject
    lateinit var presenter: CoordinatorDetailPresenter

    @Inject
    lateinit var listener: Listener

    private val disposables = CompositeDisposable()

    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)

        presenter.back()
            .subscribe { listener.onBack() }
            .addTo(disposables)
    }

    override fun willResignActive() {
        super.willResignActive()

        disposables.clear()
    }

    interface Listener {
        fun onBack(): Unit
    }
    /**
     * Presenter interface implemented by this RIB's view.
     */
    interface CoordinatorDetailPresenter {
        fun back(): Observable<Unit>
    }
}
