package com.rnd.java.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rnd.java.R;

import java.util.ArrayList;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MoviHolder> {

    private Context context;
    private ArrayList<MovieResponse.Result> movieResponses;

    public MovieListAdapter(Context context, ArrayList<MovieResponse.Result> movieResponses) {
        this.context = context;
        this.movieResponses = movieResponses;

    }

    @NonNull
    @Override
    public MoviHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_movi_list, parent, false);
        return new MoviHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviHolder holder, int position) {
        holder.textView.setText(movieResponses.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return movieResponses.size();
    }

    class MoviHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public MoviHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }


}
