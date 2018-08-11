package com.jutikorn.eddieplayer.song.structure.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.jutikorn.eddieplayer.common.structure.BaseViewModel
import com.jutikorn.eddieplayer.musiclist.structure.entity.Song
import com.jutikorn.eddieplayer.song.SongContract

class SongViewModel : BaseViewModel(), SongContract.IViewModel {

    override val songsLiveData = MutableLiveData<Song>()
    override val errorLiveData = MutableLiveData<Pair<Int?, String?>>()

    val data: MutableLiveData<PagedList<Song>> = LivePagedListBuilder()
}