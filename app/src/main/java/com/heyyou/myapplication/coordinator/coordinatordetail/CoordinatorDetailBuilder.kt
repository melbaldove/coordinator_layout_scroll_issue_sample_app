package com.heyyou.myapplication.coordinator.coordinatordetail

import android.view.LayoutInflater
import android.view.ViewGroup
import com.heyyou.myapplication.R
import com.heyyou.myapplication.coordinator.CoordinatorView
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
 * Builder for the {@link CoordinatorDetailScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class CoordinatorDetailBuilder(dependency: ParentComponent) :
    ViewBuilder<CoordinatorDetailView, CoordinatorDetailRouter, CoordinatorDetailBuilder.ParentComponent>(
      dependency
    ) {

    /**
     * Builds a new [CoordinatorDetailRouter].
     *
     * @param parentViewGroup parent view group that this router's view will be added to.
     * @return a new [CoordinatorDetailRouter].
     */
    fun build(parentViewGroup: ViewGroup): CoordinatorDetailRouter {
        val view = createView(parentViewGroup)
        val interactor = CoordinatorDetailInteractor()
        val component = DaggerCoordinatorDetailBuilder_Component.builder()
            .parentComponent(dependency)
            .view(view)
            .interactor(interactor)
            .build()
        return component.coordinatordetailRouter()
    }

    override fun inflateView(
      inflater: LayoutInflater,
      parentViewGroup: ViewGroup
    ): CoordinatorDetailView? {
        return inflater.inflate(R.layout.coordinatordetail_rib, parentViewGroup, false) as CoordinatorDetailView
    }

    interface ParentComponent {
        fun listener(): CoordinatorDetailInteractor.Listener
    }

    @dagger.Module
    abstract class Module {

        @CoordinatorDetailScope
        @Binds
        internal abstract fun presenter(view: CoordinatorDetailView): CoordinatorDetailInteractor.CoordinatorDetailPresenter

        @dagger.Module
        companion object {

            @CoordinatorDetailScope
            @Provides
            @JvmStatic
            internal fun router(
              component: Component,
              view: CoordinatorDetailView,
              interactor: CoordinatorDetailInteractor
            ): CoordinatorDetailRouter {
                return CoordinatorDetailRouter(view, interactor, component)
            }
        }

        // TODO: Create provider methods for dependencies created by this Rib. These should be static.
    }

    @CoordinatorDetailScope
    @dagger.Component(
      modules = arrayOf(Module::class),
      dependencies = arrayOf(ParentComponent::class)
    )
    interface Component : InteractorBaseComponent<CoordinatorDetailInteractor>, BuilderComponent {

        @dagger.Component.Builder
        interface Builder {
            @BindsInstance
            fun interactor(interactor: CoordinatorDetailInteractor): Builder

            @BindsInstance
            fun view(view: CoordinatorDetailView): Builder

            fun parentComponent(component: ParentComponent): Builder
            fun build(): Component
        }
    }

    interface BuilderComponent {
        fun coordinatordetailRouter(): CoordinatorDetailRouter
    }

    @Scope
    @Retention(CLASS)
    internal annotation class CoordinatorDetailScope

    @Qualifier
    @Retention(CLASS)
    internal annotation class CoordinatorDetailInternal
}
