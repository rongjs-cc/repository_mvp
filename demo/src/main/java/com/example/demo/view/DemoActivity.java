package com.example.demo.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.basemodule.view.BaseActivity;
import com.example.demo.R;
import com.example.demo.dagger.DaggerDemoComponent;
import com.example.demo.dagger.DemoModule;
import com.example.demo.mvp.DemoContract;
import com.example.demo.mvp.DemoModel;
import com.example.demo.mvp.DemoPresenter;

import javax.inject.Inject;

public class DemoActivity extends BaseActivity implements DemoContract.ContractView {

    @Inject
    DemoPresenter demoPresenter;

    private Button btn;

    @Override
    protected void initData() {
        DaggerDemoComponent.builder().demoModule(new DemoModule(new DemoModel(),this)).build().injectDemoActivity(this);
    }

    @Override
    protected void doEvent() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                demoPresenter.showResault();
            }
        });
    }

    @Override
    protected void initView() {
        btn=findViewById(R.id.demo_btn);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_demo;
    }
}
