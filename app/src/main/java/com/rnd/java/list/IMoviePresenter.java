package com.rnd.java.list;

import android.util.Log;

import com.rnd.java.network.ApiInterface;
import com.rnd.java.network.WsCalling;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IMoviePresenter implements MovieListContractor.MoviePresenter {

    private MovieListContractor.MovieListView movieListView;

    public IMoviePresenter(MovieListContractor.MovieListView movieListView) {
        this.movieListView = movieListView;
        movieListView.initAndSetListn();
    }

    @Override
    public void wsCalling() {
        ApiInterface apiService = WsCalling.getClient().create(ApiInterface.class);
        Call<MovieResponse> call = apiService.getTopRatedMovies(WsCalling.API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                movieListView.getListOfMovie(response.body());
             }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.e("response size ", "" + t);
            }
        });

    }


}
