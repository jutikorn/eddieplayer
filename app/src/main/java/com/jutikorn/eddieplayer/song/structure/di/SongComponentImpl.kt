package com.jutikorn.eddieplayer.song.structure.di

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import com.jutikorn.eddieplayer.song.SongContract
import com.jutikorn.eddieplayer.song.structure.MusicPlayerImpl
import com.jutikorn.eddieplayer.song.structure.SongUseCaseImpl
import com.jutikorn.eddieplayer.song.structure.viewmodel.SongViewModel
import com.jutikorn.eddieplayer.song.view.SongFragmentArgs

class SongComponentImpl(fragment: Fragment) : SongComponent {

    override val lifecycleOwner: LifecycleOwner = fragment


    override val viewModel: SongContract.IViewModel = ViewModelProviders.of(fragment).get(SongViewModel::class.java).apply {
        this.songsLiveData.value = SongFragmentArgs.fromBundle(fragment.arguments).song
    }

    override val player: SongContract.MusicPlayer by lazy {
        MusicPlayerImpl(fragment).apply {
            viewModel.songsLiveData.value?.url?.let {
                setSource(it)
            }
            lifecycleOwner.lifecycle.addObserver(this)
        }
    }

    override val interactor: SongContract.UseCase by lazy { SongUseCaseImpl(player) }
}