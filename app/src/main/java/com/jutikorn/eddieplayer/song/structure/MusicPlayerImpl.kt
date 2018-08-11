package com.jutikorn.eddieplayer.song.structure

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.media.AudioManager
import android.support.v4.app.Fragment
import com.jutikorn.eddieplayer.song.SongContract
import android.media.MediaPlayer
import android.net.Uri
import android.media.AudioAttributes
import android.os.Build


class MusicPlayerImpl(val fragment: Fragment) : SongContract.MusicPlayer, LifecycleObserver {

    override fun isPlaying(): Boolean = mediaPlayer.isPlaying

    override fun seekTo(seek: Int) {

    }

    var mediaPlayer: MediaPlayer = MediaPlayer()
 // "http://www.samisite.com/sound/cropShadesofGrayMonkees.mp3"
    override fun setSource(url: String) {
        fragment.context?.let {
            mediaPlayer.setDataSource(it, Uri.parse("http://www.hrupin.com/wp-content/uploads/mp3/testsong_20_sec.mp3"))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mediaPlayer.setAudioAttributes(AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .build())
            } else {
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
            }
            mediaPlayer.prepare()
        }
    }

    override fun play() {
        if (!isPlaying()) {
            mediaPlayer.start()
        }
    }

    override fun pause() {
        if (isPlaying()) {
            mediaPlayer.pause()
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    override fun stop() {
        mediaPlayer.stop()
        mediaPlayer.release()
    }

    override fun getDuration(): Int = mediaPlayer.duration
}