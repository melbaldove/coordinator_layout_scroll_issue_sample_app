package com.heyyou.myapplication.coordinator

import com.heyyou.myapplication.coordinator.coordinatordetail.CoordinatorDetailInteractor
import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

/**
 * Coordinates Business Logic for [CoordinatorScope].
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
class CoordinatorInteractor :
    Interactor<CoordinatorInteractor.CoordinatorPresenter, CoordinatorRouter>() {

    @Inject
    lateinit var presenter: CoordinatorPresenter

    private val disposables = CompositeDisposable()
    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)
        presenter.info().subscribe {
            router.attachCoordinatorDetail()
        }.addTo(disposables)
    }

    override fun willResignActive() {
        super.willResignActive()
        disposables.clear()
    }
    inner class CoordinatorDetailListener: CoordinatorDetailInteractor.Listener {
        override fun onBack() {
            router.detachCoordinatorDetail()
        }
    }
    /**
     * Presenter interface implemented by this RIB's view.
     */
    interface CoordinatorPresenter {
        fun info(): Observable<Unit>
    }
}
