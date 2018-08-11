package com.jutikorn.eddieplayer.musiclist.structure

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.jutikorn.eddieplayer.musiclist.structure.entity.Song
import com.jutikorn.eddieplayer.common.structure.AppContract

interface MusicListContract {

    interface IViewModel : AppContract.IViewModel {
        val songsLiveData: MutableLiveData<List<Song>>
        val errorLiveData: MutableLiveData<Pair<Int?, String?>>
    }

    interface Repository : AppContract.Repository {
        fun fetchMusic(success: (List<Song>) -> Unit, failed: (Int?, String?) -> Unit)
    }

    interface UseCase : AppContract.UseCase {
        fun fetchMusic(songsLiveData: MutableLiveData<List<Song>>, errorLiveData: MutableLiveData<Pair<Int?, String?>>)
        fun onMusicItemClick(song: Song)
    }

    interface Router : AppContract.Router {
        fun navigateToSong(song: Song)
    }

    interface View : AppContract.View
}