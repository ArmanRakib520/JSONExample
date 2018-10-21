package com.mcc.jsonexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<HerosModel> movies;
    private int rowLayout;
    private Context context;


    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;


        public MovieViewHolder(View view) {
            super(view);
            moviesLayout = view.findViewById(R.id.movies_layout);
            movieTitle =  view.findViewById(R.id.title);
            data =  view.findViewById(R.id.subtitle);
            movieDescription =  view.findViewById(R.id.description);
            rating =  view.findViewById(R.id.rating);
        }
    }

    public MoviesAdapter(List<HerosModel> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.movieTitle.setText(movies.get(position).getName());
        holder.data.setText(movies.get(position).getPublisher());
        holder.movieDescription.setText(movies.get(position).getCreatedby());
        holder.rating.setText(movies.get(position).getTeam().toString());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}