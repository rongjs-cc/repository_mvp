package com.example.basemodule.net;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;

/***
 * @Author Gcvition
 * @CreateDate 2019-12-02
 * @Desc 获取Token
 * @Version 1.0
 */
public interface ApiToken {

    @FormUrlEncoded
    Call<TokenBean> getToken();

}
