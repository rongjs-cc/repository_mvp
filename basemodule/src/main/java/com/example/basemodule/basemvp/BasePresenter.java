package com.example.basemodule.basemvp;

/**
 * @author rjs
 * @package com.example.basemodule.basemvp
 * @date 2021/4/12
 * @desc
 */
public class BasePresenter <V extends BaseView,M extends BaseModel> {

    protected V view;
    protected M model;

    public BasePresenter(V view, M model) {
        this.view = view;
        this.model = model;
    }

    /**
     * 解除绑定
     */
    protected void destoryVM(){
        if(view!=null){
            view=null;
        }
        if(model!=null){
            model=null;
        }
    }
}
