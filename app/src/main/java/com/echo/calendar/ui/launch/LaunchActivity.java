package com.echo.calendar.ui.launch;

import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.service.autofill.UserData;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.echo.calendar.R;
import com.echo.calendar.core.storage.DBManager;
import com.echo.calendar.core.storage.bean.UserEntity;
import com.echo.calendar.core.storage.sp.EchoPreference;
import com.echo.calendar.core.ui.BaseActivity;
import com.echo.calendar.databinding.ActivityLaunchBinding;
import com.echo.calendar.ui.login.LoginActivity;
import com.echo.calendar.ui.main.MainActivity;

import java.util.List;


/**
 * 启动页
 */
public class LaunchActivity extends BaseActivity<ActivityLaunchBinding> {

    AppCompatImageView image;

    @Override
    public int layout() {
        return R.layout.activity_launch;
    }

    @Override
    public void initView() {
        image = findViewById(R.id.launch_image);
        //使用 glide 加载启动图，防止内存泄漏
        Glide.with(this)
                .load(R.drawable.launch)
                .into(image);
        image.setOnClickListener(v -> {
            //判断是否登录
            if (EchoPreference.getLogin()) {
                startActivity(new Intent(LaunchActivity.this, MainActivity.class));
            } else {
                startActivity(new Intent(LaunchActivity.this, LoginActivity.class));
            }
            finish();
        });
    }
}