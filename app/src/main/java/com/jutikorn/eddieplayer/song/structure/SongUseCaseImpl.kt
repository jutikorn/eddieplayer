package com.jutikorn.eddieplayer.song.structure

import android.arch.lifecycle.MutableLiveData
import com.jutikorn.eddieplayer.musiclist.structure.entity.Song
import com.jutikorn.eddieplayer.song.SongContract

class SongUseCaseImpl(val player: SongContract.MusicPlayer) : SongContract.UseCase {

    override fun onPlayClick() {
        if (isPlaying()) {
            player.pause()
        } else {
            player.play()
        }
    }

    override fun isPlaying(): Boolean = player.isPlaying()

    override fun setSong(song: Song) {
        player.setSource(song.url)
    }

    override fun onSeek(seek: Int) {
        player.seekTo(seek)
    }

    override val isLoading = MutableLiveData<Boolean>()
}