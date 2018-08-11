package com.jutikorn.eddieplayer.song.structure.di

import android.arch.lifecycle.LifecycleOwner
import com.jutikorn.eddieplayer.common.di.Component
import com.jutikorn.eddieplayer.song.SongContract

interface SongComponent : Component {

    val viewModel: SongContract.IViewModel
    val interactor: SongContract.UseCase
    val lifecycleOwner: LifecycleOwner
    val player: SongContract.MusicPlayer
}