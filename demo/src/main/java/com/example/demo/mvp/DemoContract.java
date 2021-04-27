package com.example.demo.mvp;

import com.example.basemodule.basemvp.BaseModel;
import com.example.basemodule.basemvp.BasePresenter;
import com.example.basemodule.basemvp.BaseView;
import com.example.demo.bean.ResponseBean;

import io.reactivex.Observable;

/**
 * @author rjs
 * @package com.example.demo.mvp
 * @date 2021/4/12
 * @desc
 */
public interface DemoContract {

     interface ContractModel extends BaseModel{

         Observable<ResponseBean> disposeData(String name, String password);
     }

     interface  ContractView extends BaseView{

     }

     abstract class ContractPresenter extends BasePresenter<ContractView,ContractModel>{

         public ContractPresenter(ContractView view, ContractModel model) {
             super(view, model);
         }

         public abstract void showResault();
     }
}
