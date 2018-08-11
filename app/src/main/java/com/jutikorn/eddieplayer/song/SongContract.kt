package com.jutikorn.eddieplayer.song

import android.arch.lifecycle.MutableLiveData
import com.jutikorn.eddieplayer.common.structure.AppContract
import com.jutikorn.eddieplayer.musiclist.structure.entity.Song

interface SongContract {

    interface IViewModel : AppContract.IViewModel {
        val songsLiveData: MutableLiveData<Song>
        val errorLiveData: MutableLiveData<Pair<Int?, String?>>
    }

    interface UseCase : AppContract.UseCase {
        fun setSong(song: Song)
        fun onSeek(seek: Int)
        fun isPlaying(): Boolean
        fun onPlayClick()
    }

    interface View : AppContract.View

    interface MusicPlayer {
        fun setSource(url: String)
        fun play()
        fun pause()
        fun stop()
        fun isPlaying(): Boolean
        fun seekTo(seek: Int)
        fun getDuration() : Int
    }
}