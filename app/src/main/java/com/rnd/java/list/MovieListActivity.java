package com.rnd.java.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import com.rnd.java.R;
import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity implements MovieListContractor.MovieListView {

    private MovieListContractor.MoviePresenter moviePresenter;
    private RecyclerView rvMovieList;
    private ProgressBar progress;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lsit);
        initAndSetListn();
        moviePresenter = new IMoviePresenter(this);
        moviePresenter.wsCalling();
    }

    @Override
    public void initAndSetListn() {
        rvMovieList = findViewById(R.id.rvMovieList);
        progress = findViewById(R.id.progress);
        rvMovieList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void getListOfMovie(MovieResponse movieResponse) {
        progress.setVisibility(View.GONE);
        Log.e("Movie response", "---" + movieResponse);
        MovieListAdapter movieListAdapter = new MovieListAdapter(this, (ArrayList<MovieResponse.Result>) movieResponse.getResults());
        rvMovieList.setAdapter(movieListAdapter);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }



}
