package com.example.demo.mvp;

import android.util.Log;

import com.example.demo.bean.ResponseBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author rjs
 * @package com.example.demo.mvp
 * @date 2021/4/12
 * @desc
 */
public class DemoPresenter extends DemoContract.ContractPresenter {

    public DemoPresenter(DemoContract.ContractView view, DemoContract.ContractModel model) {
        super(view, model);
    }

    @Override
    public void showResault() {
        Observable<ResponseBean> observable = model.disposeData("17774039692", "R123456");

        observable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
              .subscribe(new Observer<ResponseBean>() {
                  @Override
                  public void onSubscribe(Disposable d) {

                  }

                  @Override
                  public void onNext(ResponseBean demoBean) {

                  }

                  @Override
                  public void onError(Throwable e) {

                  }

                  @Override
                  public void onComplete() {

                  }
              });
    }
}
