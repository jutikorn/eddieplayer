package com.jutikorn.eddieplayer.song.structure.di

import android.support.v4.app.Fragment
import com.jutikorn.eddieplayer.common.di.BaseInjector

class SongInjector(fragment: Fragment) : BaseInjector<SongComponent> {

    override val COMPONENTS: SongComponent = SongComponentImpl(fragment)
}