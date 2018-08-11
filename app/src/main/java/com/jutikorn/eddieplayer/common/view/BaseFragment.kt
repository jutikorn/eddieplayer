package com.jutikorn.eddieplayer.common.view

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jutikorn.eddieplayer.common.di.Component
import com.jutikorn.eddieplayer.common.structure.AppContract

abstract class BaseFragment<CP : Component>: Fragment(), AppContract.View {

    abstract val resourceId: Int

    lateinit var COMPONENTS: CP

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        context?.let { COMPONENTS = createComponent(it) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(inflater, resourceId, container, false)
        binding.setLifecycleOwner(this)
        onViewDataBound(binding)
        return binding.root
    }

    abstract fun onViewDataBound(binding: ViewDataBinding)
    abstract fun createComponent(context: Context): CP
}