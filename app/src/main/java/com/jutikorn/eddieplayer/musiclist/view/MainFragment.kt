package com.jutikorn.eddieplayer.musiclist.view

import android.arch.lifecycle.Observer
import android.content.Context
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.UiThread
import com.jutikorn.eddieplayer.R
import com.jutikorn.eddieplayer.databinding.FragmentMainBinding
import com.jutikorn.eddieplayer.musiclist.structure.MusicListContract
import com.jutikorn.eddieplayer.common.view.BaseFragment
import com.jutikorn.eddieplayer.common.view.SeparatorItemDecoration
import com.jutikorn.eddieplayer.musiclist.structure.di.MusicListComponent
import com.jutikorn.eddieplayer.musiclist.structure.di.MusicListInjector


class MainFragment : BaseFragment<MusicListComponent>(), MusicListContract.View {

    override val resourceId: Int
        get() = R.layout.fragment_main

    override fun onViewDataBound(binding: ViewDataBinding) {
        if (binding is FragmentMainBinding) {
            this@MainFragment.COMPONENTS.let {
                binding.components = it
                binding.decor = SeparatorItemDecoration()
                binding.adapter = MusicAdapter(it.interactor)
            }
        }
    }

    override fun createComponent(context: Context): MusicListComponent =
            MusicListInjector(context, this@MainFragment).COMPONENTS

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        with(COMPONENTS.viewModel) {
            errorLiveData.observe(this@MainFragment, Observer {

            })
            COMPONENTS.interactor.fetchMusic(this)
        }
    }

    @UiThread
    override fun showConnectionProblem(show: Boolean) {

    }

    @UiThread
    override fun showInfoMessage(message: String) {
    }
}