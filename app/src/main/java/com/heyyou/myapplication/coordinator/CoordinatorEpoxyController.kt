package com.heyyou.myapplication.coordinator

import com.airbnb.epoxy.EpoxyController

/**
 * @author Melby Baldove
 * melby@heyyou.com.au
 */
class CoordinatorEpoxyController: EpoxyController() {
    override fun buildModels() {
        (1..20).forEach {
            sampleEpoxyItem {
                id(it)
            }
        }
    }
}