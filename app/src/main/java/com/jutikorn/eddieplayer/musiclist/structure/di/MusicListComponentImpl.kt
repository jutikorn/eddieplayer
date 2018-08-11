package com.jutikorn.eddieplayer.musiclist.structure.di

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.v4.app.Fragment
import com.jutikorn.eddieplayer.common.di.NetModule
import com.jutikorn.eddieplayer.musiclist.structure.MusicListContract
import com.jutikorn.eddieplayer.musiclist.structure.repository.MusicListRepositoryImpl
import com.jutikorn.eddieplayer.musiclist.structure.router.MusicListRouterImpl
import com.jutikorn.eddieplayer.musiclist.structure.usecase.MusicListUsecaseImpl
import com.jutikorn.eddieplayer.musiclist.structure.viewmodel.MainViewModel

class MusicListComponentImpl(context: Context,
                             fragment: Fragment) : MusicListComponent {

    override val router by lazy { MusicListRouterImpl(fragment) }

    override val repository by lazy { MusicListRepositoryImpl(NetModule.getInstance(context).eddieApi) }

    override val interactor by lazy { MusicListUsecaseImpl(repository, router) }

    override val viewModel: MusicListContract.IViewModel = ViewModelProviders.of(fragment).get(MainViewModel::class.java)

    override val lifecycleOwner: LifecycleOwner = fragment

}