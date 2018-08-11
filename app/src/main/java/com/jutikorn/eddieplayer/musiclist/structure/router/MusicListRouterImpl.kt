package com.jutikorn.eddieplayer.musiclist.structure.router

import android.support.v4.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.jutikorn.eddieplayer.musiclist.structure.MusicListContract
import com.jutikorn.eddieplayer.musiclist.structure.entity.Song
import com.jutikorn.eddieplayer.musiclist.view.MainFragmentDirections

class MusicListRouterImpl(val fragment: Fragment) : MusicListContract.Router {

    override fun navigateToSong(song: Song) {
        val direction = MainFragmentDirections.openSong(song)
        NavHostFragment.findNavController(fragment).navigate(direction)
    }
}