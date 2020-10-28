package com.heyyou.myapplication.coordinator.coordinatordetail

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class CoordinatorDetailInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: CoordinatorDetailInteractor.CoordinatorDetailPresenter
  @Mock internal lateinit var router: CoordinatorDetailRouter

  private var interactor: CoordinatorDetailInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestCoordinatorDetailInteractor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<CoordinatorDetailInteractor.CoordinatorDetailPresenter, CoordinatorDetailRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}