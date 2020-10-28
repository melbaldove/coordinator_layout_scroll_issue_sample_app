package com.heyyou.myapplication

import android.os.Bundle
import android.view.ViewGroup
import com.uber.rib.core.RibActivity
import com.uber.rib.core.ViewRouter

class MainActivity : RibActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun createRouter(parentViewGroup: ViewGroup): ViewRouter<*, *, *> {
        return RootBuilder(object : RootBuilder.ParentComponent {})
                .build(parentViewGroup)
    }
}