package com.jutikorn.eddieplayer.musiclist.structure.di

import android.arch.lifecycle.LifecycleOwner
import com.jutikorn.eddieplayer.common.di.Component
import com.jutikorn.eddieplayer.musiclist.structure.MusicListContract

interface MusicListComponent : Component {

    val router: MusicListContract.Router

    val repository: MusicListContract.Repository

    val interactor: MusicListContract.UseCase

    val viewModel : MusicListContract.IViewModel

    val lifecycleOwner: LifecycleOwner
}