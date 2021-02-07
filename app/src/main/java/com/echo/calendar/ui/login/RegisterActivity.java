package com.echo.calendar.ui.login;

import android.view.View;
import android.widget.Toast;

import com.echo.calendar.R;
import com.echo.calendar.core.storage.DBManager;
import com.echo.calendar.core.storage.bean.UserEntity;
import com.echo.calendar.core.storage.dao.UserDao;
import com.echo.calendar.core.ui.BaseActivity;
import com.echo.calendar.databinding.ActivityRegisterBinding;

import java.util.Objects;

/**
 * 注册
 */
public class RegisterActivity extends BaseActivity<ActivityRegisterBinding> {

    UserDao userDao;

    @Override
    public int layout() {
        return R.layout.activity_register;
    }

    @Override
    public void initView() {
        userDao = DBManager.getManager(getApplication()).getUserDao();
    }


    @Override
    public void listener() {
        binding.loginBack.setOnClickListener(v -> {
            String number = Objects.requireNonNull(binding.loginNumber.getText()).toString();
            String password = Objects.requireNonNull(binding.loginPassword.getText()).toString();
            if (number.length() <= 0) {
                Toast.makeText(v.getContext(), "请输入手机号", Toast.LENGTH_LONG).show();
                return;
            }
            if (password.length() <= 0) {
                Toast.makeText(v.getContext(), "请输入密码", Toast.LENGTH_LONG).show();
                return;
            }
            UserEntity entity = new UserEntity(number, password);
            //插入新的数据
            userDao.insert(entity);
            Toast.makeText(v.getContext(), "注册成功", Toast.LENGTH_LONG).show();
            finish();
        });
    }
}
