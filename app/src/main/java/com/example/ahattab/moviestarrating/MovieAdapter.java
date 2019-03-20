package com.example.ahattab.moviestarrating;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>{

        List<Movie> movieList;

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView movieName, movieId;
        Button btn_deleteRecord;
        RatingBar rating;

        MyViewHolder(View view)
        {
            super(view);

            movieName = view.findViewById(R.id.movieName);
            movieId = view.findViewById(R.id.movieId);
            rating = view.findViewById(R.id.ratingBar);
            btn_deleteRecord = view.findViewById(R.id.btn_delete_record);
        }
    }
    MovieAdapter(List<Movie> movieList)
    {
        this.movieList = movieList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movie_row, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieAdapter.MyViewHolder viewHolder, int i)
    {
        final Movie movie = movieList.get(i);

        viewHolder.movieName.setText(movie.getMovieName());

        int count = movie.getMovieId();
        System.out.println("movie Id: " + count);
        count++;

        viewHolder.movieId.setText(String.valueOf("" + count));
        viewHolder.rating.setNumStars((int) movie.getMovieRating());

        viewHolder.btn_deleteRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerView.ViewHolder holder = (RecyclerView.ViewHolder) v.getTag();
            if (v.getId() == viewHolder.btn_deleteRecord.getId()) {
                  System.out.println("cool");
                movieList.remove(viewHolder.getPosition());

                notifyDataSetChanged();}


                System.out.println("view id" + v.getId());
            }
        });


    }
    @Override
    public int getItemCount() {
        return this.movieList.size();
    }

}
