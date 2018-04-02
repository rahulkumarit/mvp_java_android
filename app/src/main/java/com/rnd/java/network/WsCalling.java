package com.rnd.java.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WsCalling {

    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    public static final String API_KEY="cf00cdce49f11a0bc3ebc18151ebed29";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


    public static void callWs(int reqCode, String url, WsResponse wsResponse) {


    }


}
