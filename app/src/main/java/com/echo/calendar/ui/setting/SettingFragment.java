package com.echo.calendar.ui.setting;

import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.View;

import com.echo.calendar.BaseApplication;
import com.echo.calendar.R;
import com.echo.calendar.core.MediaPlayerManager;
import com.echo.calendar.core.ui.BaseFragment;
import com.echo.calendar.databinding.FragSettingBinding;

import java.io.IOException;
import java.io.InputStream;

import static com.echo.calendar.core.MediaPlayerManager.play;

/**
 * 设置
 */
public class SettingFragment extends BaseFragment<FragSettingBinding> {

    MediaPlayer mediaPlayer;

    @Override
    public int layout() {
        return R.layout.frag_setting;
    }

    @Override
    public void initView() {
        mediaPlayer = MediaPlayerManager.mediaPlayer;
    }

    @Override
    public void listener() {
        //点击事件播放音频
        binding.settingShineOne.setOnClickListener(v -> {
            play("shine_one.mp3");
        });
        binding.settingShineTwo.setOnClickListener(v -> {
            play("shine_two.mp3");
        });
        binding.settingShineThree.setOnClickListener(v -> {
            play("shine_three.mp3");
        });

        binding.settingOvercastOne.setOnClickListener(v -> {
            play("overcast_one.mp3");
        });
        binding.settingOvercastTwo.setOnClickListener(v -> {
            play("overcast_two.mp3");
        });
        binding.settingOvercastThree.setOnClickListener(v -> {
            play("overcast_three.mp3");
        });

        binding.settingRainyOne.setOnClickListener(v -> {
            play("rainy_one.mp3");
        });
        binding.settingRainyTwo.setOnClickListener(v -> {
            play("rainy_two.mp3");
        });
        binding.settingRainyThree.setOnClickListener(v -> {
            play("rainy_three.mp3");
        });

        binding.settingSnowyOne.setOnClickListener(v -> {
            play("snowy_one.mp3");
        });
        binding.settingSnowyTwo.setOnClickListener(v -> {
            play("snowy_two.mp3");
        });
        binding.settingSnowyThree.setOnClickListener(v -> {
            play("snowy_three.mp3");
        });
    }

}
