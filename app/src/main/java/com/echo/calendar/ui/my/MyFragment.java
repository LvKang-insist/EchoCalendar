package com.echo.calendar.ui.my;

import android.content.Intent;
import android.view.View;

import com.echo.calendar.R;
import com.echo.calendar.core.ui.BaseFragment;
import com.echo.calendar.databinding.FragMyBinding;

/**
 * 我的页面
 */
public class MyFragment extends BaseFragment<FragMyBinding> {
    @Override
    public int layout() {
        return R.layout.frag_my;
    }

    @Override
    public void initView() {

    }

    @Override
    public void listener() {
        binding.myBackground.setOnClickListener(v -> startActivity(new Intent(requireContext(), MyDetailActivity.class)));
    }
}
