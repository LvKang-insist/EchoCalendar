package com.echo.calendar.ui.main;

import androidx.fragment.app.Fragment;

import com.echo.calendar.R;
import com.echo.calendar.core.ui.BaseActivity;
import com.echo.calendar.databinding.ActivityMainBinding;
import com.echo.calendar.ui.home.HomeFragment;
import com.echo.calendar.ui.my.MyFragment;
import com.echo.calendar.ui.setting.SettingFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private int current_page = 0;

    @Override
    public int layout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        List<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new MyFragment());
        list.add(new SettingFragment());
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager(), getLifecycle(), list);
        binding.mainVp2.setAdapter(adapter);
        binding.mainVp2.setOffscreenPageLimit(3);
        binding.mainVp2.setUserInputEnabled(false);
        binding.mainVp2.setCurrentItem(current_page, false);
    }

    @Override
    public void listener() {
        binding.homeLayout.setOnClickListener(v -> {
            current_page = 0;
            setDefault();
            binding.homeImage.setImageResource(R.drawable.home_true);
            binding.homeText.setTextColor(getResources().getColor(R.color.color_23E7EA));
            binding.mainVp2.setCurrentItem(0, false);
        });
        binding.myLayout.setOnClickListener(v -> {
            current_page = 1;
            setDefault();
            binding.myImage.setImageResource(R.drawable.my_true);
            binding.myText.setTextColor(getResources().getColor(R.color.color_23E7EA));
            binding.mainVp2.setCurrentItem(1, false);
        });
        binding.settingLayout.setOnClickListener(v -> {
            current_page = 2;
            setDefault();
            binding.settingImage.setImageResource(R.drawable.setting_true);
            binding.settingText.setTextColor(getResources().getColor(R.color.color_23E7EA));
            binding.mainVp2.setCurrentItem(2, false);
        });
    }

    public void setDefault() {
        binding.homeImage.setImageResource(R.drawable.home_false);
        binding.myImage.setImageResource(R.drawable.my_false);
        binding.settingImage.setImageResource(R.drawable.setting_false);
        binding.homeText.setTextColor(getResources().getColor(R.color.black));
        binding.myText.setTextColor(getResources().getColor(R.color.black));
        binding.settingText.setTextColor(getResources().getColor(R.color.black));
    }

}