package com.example.demo.dagger;

import com.example.demo.mvp.DemoContract;
import com.example.demo.mvp.DemoPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author rjs
 * @package com.example.demo.dagger
 * @date 2021/4/12
 * @desc
 */
@Module
public class DemoModule {

    private DemoContract.ContractModel model;
    private DemoContract.ContractView  view;

    public DemoModule(DemoContract.ContractModel model, DemoContract.ContractView view) {
        this.model = model;
        this.view = view;
    }

    @Provides
    DemoPresenter provideP(){
        return new DemoPresenter(view,model);
    }

}
