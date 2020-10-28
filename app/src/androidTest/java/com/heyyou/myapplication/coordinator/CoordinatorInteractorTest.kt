package com.heyyou.myapplication.coordinator

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class CoordinatorInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: CoordinatorInteractor.CoordinatorPresenter
  @Mock internal lateinit var router: CoordinatorRouter

  private var interactor: CoordinatorInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestCoordinatorInteractor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<CoordinatorInteractor.CoordinatorPresenter, CoordinatorRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}