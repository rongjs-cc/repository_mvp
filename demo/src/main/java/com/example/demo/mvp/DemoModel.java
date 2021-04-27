package com.example.demo.mvp;

import com.example.basemodule.net.RetrofitUtil;
import com.example.demo.api.DemoApi;
import com.example.demo.bean.RequestBean;
import com.example.demo.bean.ResponseBean;

import io.reactivex.Observable;

/**
 * @author rjs
 * @package com.example.demo.mvp
 * @date 2021/4/12
 * @desc
 */
public class DemoModel implements DemoContract.ContractModel {

    @Override
    public Observable<ResponseBean> disposeData(String name, String password) {
        RequestBean requestBean = new RequestBean(name, password);
        Observable<ResponseBean> observable = RetrofitUtil.getInstance().createApi(DemoApi.class).getData(requestBean);
        return observable;
    }
}
