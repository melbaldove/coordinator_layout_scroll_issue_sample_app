package com.heyyou.myapplication.coordinator

import android.view.LayoutInflater
import android.view.ViewGroup
import com.heyyou.myapplication.FullScreenView
import com.heyyou.myapplication.R
import com.heyyou.myapplication.coordinator.coordinatordetail.CoordinatorDetailBuilder
import com.heyyou.myapplication.coordinator.coordinatordetail.CoordinatorDetailInteractor
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.CLASS
import javax.inject.Qualifier
import javax.inject.Scope

/**
 * Builder for the {@link CoordinatorScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class CoordinatorBuilder(dependency: ParentComponent) :
    ViewBuilder<CoordinatorView, CoordinatorRouter, CoordinatorBuilder.ParentComponent>(dependency) {

    /**
     * Builds a new [CoordinatorRouter].
     *
     * @param parentViewGroup parent view group that this router's view will be added to.
     * @return a new [CoordinatorRouter].
     */
    fun build(parentViewGroup: ViewGroup): CoordinatorRouter {
        val view = createView(parentViewGroup)
        val interactor = CoordinatorInteractor()
        val component = DaggerCoordinatorBuilder_Component.builder()
            .parentComponent(dependency)
            .view(view)
            .interactor(interactor)
            .build()
        return component.coordinatorRouter()
    }

    override fun inflateView(
        inflater: LayoutInflater,
        parentViewGroup: ViewGroup
    ): CoordinatorView? {
        return inflater.inflate(R.layout.coordinator_rib, parentViewGroup, false) as CoordinatorView
    }

    interface ParentComponent {
        fun fullScreenView(): FullScreenView
    }

    @dagger.Module
    abstract class Module {

        @CoordinatorScope
        @Binds
        internal abstract fun presenter(view: CoordinatorView): CoordinatorInteractor.CoordinatorPresenter

        @dagger.Module
        companion object {

            @CoordinatorScope
            @Provides
            @JvmStatic
            internal fun router(
                component: Component,
                view: CoordinatorView,
                interactor: CoordinatorInteractor,
                fullScreenView: FullScreenView,
            ): CoordinatorRouter {
                return CoordinatorRouter(
                    view,
                    interactor,
                    component,
                    fullScreenView as ViewGroup,
                    CoordinatorDetailBuilder(component)
                )
            }

            @CoordinatorScope
            @Provides
            @JvmStatic
            internal fun coordinatorDetailListener(interactor: CoordinatorInteractor): CoordinatorDetailInteractor.Listener {
                return interactor.CoordinatorDetailListener()
            }
        }

        // TODO: Create provider methods for dependencies created by this Rib. These should be static.
    }

    @CoordinatorScope
    @dagger.Component(
        modules = arrayOf(Module::class),
        dependencies = arrayOf(ParentComponent::class)
    )
    interface Component : InteractorBaseComponent<CoordinatorInteractor>,
        CoordinatorDetailBuilder.ParentComponent, BuilderComponent {

        @dagger.Component.Builder
        interface Builder {
            @BindsInstance
            fun interactor(interactor: CoordinatorInteractor): Builder

            @BindsInstance
            fun view(view: CoordinatorView): Builder

            fun parentComponent(component: ParentComponent): Builder
            fun build(): Component
        }
    }

    interface BuilderComponent {
        fun coordinatorRouter(): CoordinatorRouter
    }

    @Scope
    @Retention(CLASS)
    internal annotation class CoordinatorScope

    @Qualifier
    @Retention(CLASS)
    internal annotation class CoordinatorInternal
}
