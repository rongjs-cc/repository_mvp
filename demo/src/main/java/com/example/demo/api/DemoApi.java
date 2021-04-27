package com.example.demo.api;


import com.example.demo.bean.RequestBean;
import com.example.demo.bean.ResponseBean;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author rjs
 * @package com.example.demo
 * @date 2021/4/13
 * @desc
 */
public interface DemoApi {

    @POST("api/Android/Login")
    Observable<ResponseBean> getData(@Body RequestBean requestBean);

}
