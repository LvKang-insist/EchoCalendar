package com.echo.calendar.ui.login;

import android.view.View;
import android.widget.Toast;

import com.echo.calendar.R;
import com.echo.calendar.core.storage.DBManager;
import com.echo.calendar.core.storage.bean.UserEntity;
import com.echo.calendar.core.storage.dao.UserDao;
import com.echo.calendar.core.ui.BaseActivity;
import com.echo.calendar.databinding.ActivityForgetBinding;

import java.util.List;
import java.util.Objects;

/**
 * 修改密码
 */
public class ForgeActivity extends BaseActivity<ActivityForgetBinding> {

    private UserDao userDao;

    @Override
    public int layout() {
        return R.layout.activity_forget;
    }

    @Override
    public void initView() {
        userDao = DBManager.getManager(getApplication()).getUserDao();
    }

    @Override
    public void listener() {
        binding.loginSetting.setOnClickListener(v -> {
            String number = Objects.requireNonNull(binding.loginNumber.getText()).toString();
            String password = Objects.requireNonNull(binding.loginPassword.getText()).toString();
            String passwordTwo = Objects.requireNonNull(binding.loginPasswordTwo.getText()).toString();
            if (number.length() <= 0) {
                Toast.makeText(v.getContext(), "请输入账号", Toast.LENGTH_LONG).show();
                return;
            }
            if (password.length() <= 0) {
                Toast.makeText(v.getContext(), "请输入新密码", Toast.LENGTH_LONG).show();
                return;
            }
            if (passwordTwo.length() <= 0) {
                Toast.makeText(v.getContext(), "请再次输入新密码", Toast.LENGTH_LONG).show();
                return;
            }
            if (!password.equals(passwordTwo)) {
                Toast.makeText(v.getContext(), "两次密码输入不一致", Toast.LENGTH_LONG).show();
                return;
            }
            //获取user表所有数据
            List<UserEntity> entities = userDao.queryAll();
            for (int i = 0; i < entities.size(); i++) {
                UserEntity entity = entities.get(i);
                //如果账号相同，则修改密码
                if (entity.number.equals(number)) {
                    entity.password = password;
                    userDao.update(entity);
                    Toast.makeText(v.getContext(), "修改成功", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
            Toast.makeText(v.getContext(), "未找到此账号", Toast.LENGTH_LONG).show();
        });
    }
}
