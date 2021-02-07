package com.echo.calendar.core;

import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;

import com.echo.calendar.BaseApplication;

import java.io.IOException;

/**
 * 音频播放管理类
 */
public class MediaPlayerManager {

    private static String currName = "";

    public static MediaPlayer mediaPlayer = new MediaPlayer();


    /**
     * 播放音乐
     *
     * @param name 音乐名称
     */
    public static void play(String name) {
        // 如果是当前播放的，则暂停，否则重新播放
        if (currName.equals(name)) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.reset();
                return;
            }
        }
        mediaPlayer.reset();
        currName = name;
        try {
            AssetFileDescriptor fd = BaseApplication.application.getAssets().openFd(name);
            mediaPlayer.reset();
            mediaPlayer.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getLength());
            mediaPlayer.prepareAsync();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setOnPreparedListener(MediaPlayer::start);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
