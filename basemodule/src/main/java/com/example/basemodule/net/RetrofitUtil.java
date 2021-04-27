package com.example.basemodule.net;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author rjs
 * @package com.example.basemodule.net
 * @date 2021/4/12
 * @desc
 */
public class RetrofitUtil {

    private final String TAG=RetrofitUtil.class.getSimpleName();
    private static final String BASEURL="http://122.51.121.122:8060/";
    private Retrofit retrofit;
    private static volatile RetrofitUtil instance;

    public static RetrofitUtil getInstance(){
        if(instance==null){
            synchronized (RetrofitUtil.class){
                if(instance==null){
                    instance=new RetrofitUtil();
                }
            }
        }
        return instance;
    }

    private RetrofitUtil(){
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(createRequestInterceptor())
                .addNetworkInterceptor(createLogInterceptor())
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder().baseUrl(BASEURL).client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    /***
     * 创建 Log拦截器
     * @return Log拦截器
     */
    private HttpLoggingInterceptor createLogInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i(TAG, message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }

    /**
     * 创建自定义拦截器
     * @return
     */
    private Interceptor createRequestInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //拦截请求
                Request request = chain.request();
                //拦截响应
                Response response = chain.proceed(request);
                Request.Builder requestBuilder = request.newBuilder()
                        .addHeader("Content-Type", "application-json")
                        .addHeader("chatest", "utf-8");
                if(response.code()==401){
                    requestBuilder.addHeader("Authorization","bearer " + requestToken());
                }
                return chain.proceed(requestBuilder.build());
            }
        };
    }

    /**
     * 同步请求 Token
     */
    private String requestToken(){
        try {
            TokenBean body = retrofit.create(ApiToken.class).getToken().execute().body();
            return body.getToken();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    /***
     * @Desc 创建API
     * @param clazz
     * @param <T>
     * @return api
     */
    public <T> T createApi(Class<T> clazz) {
        return retrofit.create(clazz);
    }
}
