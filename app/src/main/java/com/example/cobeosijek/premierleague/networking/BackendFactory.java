package com.example.cobeosijek.premierleague.networking;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cobeosijek on 27/10/2017.
 */

public class BackendFactory {

    private static String BASE_URL = "http://api.football-data.org/v1/";

    private static Retrofit retrofit;

    private static ApiService apiService;

    private static Retrofit setUpRetrofit() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public static ApiService setUpApiService() {
        if (apiService == null) {
            apiService = setUpRetrofit().create(ApiService.class);
        }

        return apiService;
    }
}
