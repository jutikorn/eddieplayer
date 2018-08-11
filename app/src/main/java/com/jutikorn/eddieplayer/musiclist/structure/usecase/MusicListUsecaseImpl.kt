package com.jutikorn.eddieplayer.musiclist.structure.usecase

import android.arch.lifecycle.MutableLiveData
import com.jutikorn.eddieplayer.musiclist.structure.MusicListContract
import com.jutikorn.eddieplayer.musiclist.structure.entity.Song

class MusicListUsecaseImpl(val repository: MusicListContract.Repository,
                           val router: MusicListContract.Router) : MusicListContract.UseCase {

    override val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    override fun onMusicItemClick(song: Song) {
        router.navigateToSong(song)
    }

    override fun fetchMusic(songsLiveData: MutableLiveData<List<Song>>,
                            errorLiveData: MutableLiveData<Pair<Int?, String?>>) {
        isLoading.value = true
        repository.fetchMusic({
            isLoading.value = false
            songsLiveData.value = it
        }) { code, msg ->
            isLoading.value = false
            errorLiveData.value = Pair(code, msg)
        }
    }
}