package com.echo.calendar.ui.login;

import android.content.Intent;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.Toast;

import com.echo.calendar.R;
import com.echo.calendar.core.storage.DBManager;
import com.echo.calendar.core.storage.bean.UserEntity;
import com.echo.calendar.core.storage.dao.UserDao;
import com.echo.calendar.core.storage.sp.EchoPreference;
import com.echo.calendar.core.ui.BaseActivity;
import com.echo.calendar.databinding.ActivityLoginBinding;
import com.echo.calendar.ui.launch.LaunchActivity;
import com.echo.calendar.ui.main.MainActivity;

import java.util.List;
import java.util.Objects;

/**
 * 登录页面
 */
public class LoginActivity extends BaseActivity<ActivityLoginBinding> {

    public UserDao userDao;

    @Override
    public int layout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        userDao = DBManager.getManager(getApplication()).getUserDao();
    }

    @Override
    public void listener() {

        binding.loginRegister.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });

        binding.loginForgetPassword.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, ForgeActivity.class));
        });

        binding.login.setOnClickListener(v -> {
            String number = Objects.requireNonNull(binding.loginNumber.getText()).toString();
            String password = Objects.requireNonNull(binding.loginPassword.getText()).toString();
            if (number.length() <= 0) {
                Toast.makeText(v.getContext(), "请输入账号", Toast.LENGTH_LONG).show();
                return;
            }
            if (password.length() <= 0) {
                Toast.makeText(v.getContext(), "请输入密码", Toast.LENGTH_LONG).show();
                return;
            }
            //获取数据库数据，进行匹配
            List<UserEntity> users = userDao.queryAll();
            for (int i = 0; i < users.size(); i++) {
                UserEntity userEntity = users.get(i);
                if (userEntity.number.equals(number)) {
                    if (userEntity.password.equals(password)) {
                        Toast.makeText(v.getContext(), "登录成功", Toast.LENGTH_LONG).show();
                        EchoPreference.loginSuccess(number);
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                        return;
                    }
                }
            }
            Toast.makeText(v.getContext(), "账号或密码输入错误", Toast.LENGTH_LONG).show();
        });
    }
}
