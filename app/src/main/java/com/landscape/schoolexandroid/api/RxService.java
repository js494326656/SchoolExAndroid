package com.landscape.schoolexandroid.api;

import android.text.TextUtils;

import com.landscape.schoolexandroid.common.AppConfig;
import com.orhanobut.logger.Logger;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SkyEyesStion on 2016/2/26.
 */
public class RxService {
    private static OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor
            (new HttpLoggingInterceptor(message -> {
                if (!TextUtils.isEmpty(message) && message.startsWith("{")) {
                    Logger.json(message);
                } else {
                    Logger.i(message);
                }
            }).setLevel(HttpLoggingInterceptor.Level.BODY)).build();
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(AppConfig.BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private RxService() {
        //construct
    }

    public static <T> T createApi(Class<T> clazz) {
        return retrofit.create(clazz);
    }

    public static void netErr(Throwable throwable){
        Logger.e(throwable.getMessage());
    }
}