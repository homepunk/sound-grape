package com.github.homepunk.soundgrape.data.remote.api;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.github.homepunk.soundgrape.data.Constants.Api.Youtube.BASE_URL;

/**
 * Created by Homepunk on 24.10.2017.
 **/

public class YoutubeMusicApiConnection {
    private static YoutubeMusicApi youtubeMusicApi;

    public static YoutubeMusicApi getApiInstance() {
        init();
        return youtubeMusicApi;
    }

    private static void init() {
        if (youtubeMusicApi == null) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(clientBuilder.build())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            youtubeMusicApi = retrofit.create(YoutubeMusicApi.class);
        }
    }
}
