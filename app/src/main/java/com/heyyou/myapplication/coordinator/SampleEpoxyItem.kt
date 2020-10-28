package com.heyyou.myapplication.coordinator

import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.heyyou.myapplication.GenericEpoxyHolder
import com.heyyou.myapplication.R

/**
 * @author Melby Baldove
 * melby@heyyou.com.au
 */
@EpoxyModelClass(layout = R.layout.sample_epoxy_item)
abstract class SampleEpoxyItem: EpoxyModelWithHolder<GenericEpoxyHolder>() {
}