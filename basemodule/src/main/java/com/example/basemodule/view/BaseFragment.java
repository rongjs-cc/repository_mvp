package com.example.basemodule.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author rjs
 * @package com.example.basemodule
 * @date 2021/4/12
 * @desc
 */
public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getResId(), null);
        initData();
        initView(view);
        doEvent(view);
        return view;
    }

    /** 初始化控件*/
    protected abstract void initView(View view);

    /** fragment事件处理*/
    protected abstract void doEvent(View view);

    /**
     * 获取布局id
     * @return
     */
    protected abstract  int getResId();

    /** 数据初始化*/
    protected abstract void initData();
}
