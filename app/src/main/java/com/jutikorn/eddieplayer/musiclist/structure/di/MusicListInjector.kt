package com.jutikorn.eddieplayer.musiclist.structure.di

import android.content.Context
import android.support.v4.app.Fragment
import com.jutikorn.eddieplayer.common.di.BaseInjector
import com.jutikorn.eddieplayer.common.di.NetModule

class MusicListInjector(context: Context,
                        fragment: Fragment) : BaseInjector<MusicListComponent> {

    override val COMPONENTS: MusicListComponent = MusicListComponentImpl(context, fragment)
}