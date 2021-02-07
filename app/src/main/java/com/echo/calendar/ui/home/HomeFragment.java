package com.echo.calendar.ui.home;

import android.annotation.SuppressLint;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;

import com.echo.calendar.BaseApplication;
import com.echo.calendar.R;
import com.echo.calendar.core.MediaPlayerManager;
import com.echo.calendar.core.ui.BaseFragment;
import com.echo.calendar.databinding.FragHomeBinding;

import java.io.IOException;
import java.util.Random;

import static com.echo.calendar.core.MediaPlayerManager.play;

/**
 * 首页
 */
public class HomeFragment extends BaseFragment<FragHomeBinding> {

    String[] weather = new String[]{"天气 晴天", "天气 阴天", "天气 雨天", "天气 雪天"};

    String[] shine = new String[]{"shine_one.mp3", "shine_two.mp3", "shine_three.mp3"};
    String[] overcast = new String[]{"overcast_one.mp3", "overcast_two.mp3", "overcast_three.mp3"};
    String[] rainy = new String[]{"rainy_one.mp3", "rainy_two.mp3", "rainy_three.mp3"};
    String[] snowy = new String[]{"snowy_one.mp3", "snowy_two.mp3", "snowy_three.mp3"};
    MediaPlayer mediaPlayer;
    int index;

    @Override
    public int layout() {
        return R.layout.frag_home;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void initView() {
        mediaPlayer = MediaPlayerManager.mediaPlayer;
        int year = binding.calendarView.getCurYear();
        int month = binding.calendarView.getCurMonth();
        binding.homeTitle.setText("" + year + "年" + month + "月");

        index = new Random().nextInt(4);
        binding.homeDate.setText("" + year + "年" + month + "月" + (binding.calendarView.getCurDay() + 1));
        binding.homeWeather.setText(weather[index]);
    }


    @Override
    public void listener() {
        binding.musicOne.setOnClickListener(v -> initPlay(0));
        binding.musicTwo.setOnClickListener(v -> initPlay(1));
        binding.musicThree.setOnClickListener(v -> initPlay(2));
    }

    private void initPlay(int pos) {
        switch (index) {
            case 0:
                play(shine[pos]);
                break;
            case 1:
                play(overcast[pos]);
                break;
            case 2:
                play(rainy[pos]);
                break;
            case 3:
                play(snowy[pos]);
                break;
        }
    }
}
