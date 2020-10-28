package com.heyyou.myapplication.coordinator.coordinatordetail

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class CoordinatorDetailRouterTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var component: CoordinatorDetailBuilder.Component
  @Mock internal lateinit var interactor: CoordinatorDetailInteractor
  @Mock internal lateinit var view: CoordinatorDetailView

  private var router: CoordinatorDetailRouter? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    router = CoordinatorDetailRouter(view, interactor, component)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use RouterHelper to drive your router's lifecycle.
    RouterHelper.attach(router!!)
    RouterHelper.detach(router!!)

    throw RuntimeException("Remove this test and add real tests.")
  }

}

