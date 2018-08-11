package com.jutikorn.eddieplayer.musiclist.structure.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.jutikorn.eddieplayer.musiclist.structure.MusicListContract
import com.jutikorn.eddieplayer.musiclist.structure.entity.Song
import com.jutikorn.eddieplayer.common.structure.BaseViewModel

class MainViewModel : BaseViewModel(), MusicListContract.IViewModel {

    override val songsLiveData = MutableLiveData<List<Song>>()
    override val errorLiveData = MutableLiveData<Pair<Int?, String?>>()
}