package com.example.demo.dagger;

import com.example.demo.view.DemoActivity;

import dagger.Component;

/**
 * @author rjs
 * @package com.example.demo.dagger
 * @date 2021/4/12
 * @desc
 */
@Component(modules = DemoModule.class)
public interface DemoComponent {
    void injectDemoActivity(DemoActivity demoActivity);
}
