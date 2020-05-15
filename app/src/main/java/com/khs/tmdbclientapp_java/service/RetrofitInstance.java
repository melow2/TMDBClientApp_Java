package com.khs.tmdbclientapp_java.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @auther hyeoksin
 * @since
 */
public class RetrofitInstance {
    private static String BASE_URL="https://api.themoviedb.org/3/";
    private static Retrofit retrofit = null;
    public static MovieAPIService getInstance(){
        if(retrofit==null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(MovieAPIService.class);
    }
}
