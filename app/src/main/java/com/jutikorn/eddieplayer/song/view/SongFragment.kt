package com.jutikorn.eddieplayer.song.view

import android.content.Context
import android.databinding.ViewDataBinding
import com.jutikorn.eddieplayer.R
import com.jutikorn.eddieplayer.common.view.BaseFragment
import com.jutikorn.eddieplayer.databinding.FragmentSongBinding
import com.jutikorn.eddieplayer.song.SongContract
import com.jutikorn.eddieplayer.song.structure.di.SongComponent
import com.jutikorn.eddieplayer.song.structure.di.SongInjector

class SongFragment : BaseFragment<SongComponent>(), SongContract.View {

    override val resourceId: Int
        get() = R.layout.fragment_song

    override fun onViewDataBound(binding: ViewDataBinding) {
        if (binding is FragmentSongBinding) {
            binding.components = COMPONENTS
        }
    }

    override fun createComponent(context: Context): SongComponent = SongInjector(this).COMPONENTS

    override fun showConnectionProblem(show: Boolean) {

    }

    override fun showInfoMessage(message: String) {
    }
}