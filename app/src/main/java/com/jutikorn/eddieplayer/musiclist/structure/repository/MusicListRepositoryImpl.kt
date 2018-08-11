package com.jutikorn.eddieplayer.musiclist.structure.repository

import com.jutikorn.eddieplayer.api.EddiePlayerApi
import com.jutikorn.eddieplayer.api.enqueue
import com.jutikorn.eddieplayer.musiclist.structure.MusicListContract
import com.jutikorn.eddieplayer.musiclist.structure.entity.Song
import com.jutikorn.eddieplayer.common.structure.BaseRepository

class MusicListRepositoryImpl(val eddiePlayerApi: EddiePlayerApi) : BaseRepository(), MusicListContract.Repository {

    override fun fetchMusic(success: (List<Song>) -> Unit, failed: (Int?, String?) -> Unit) {
        eddiePlayerApi.getSongs().enqueue(success, failed)
    }

}