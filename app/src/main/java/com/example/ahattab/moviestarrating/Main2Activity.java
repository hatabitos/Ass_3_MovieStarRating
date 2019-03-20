package com.example.ahattab.moviestarrating;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private List<Movie> movieList = new ArrayList<>();

    Movie m = new Movie();
    int count=1;
    float numOfStars;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button save = findViewById(R.id.btn_save);
        Button cancel = findViewById(R.id.btn_Cancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (getApplicationContext(),MainActivity.class);
                startActivityForResult(i,2);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText movieName = findViewById(R.id.newMovieName);
                RatingBar movieRating = findViewById(R.id.ratingBar2);
                System.out.println("outsideRating" + movieRating.getRating());

                String returnNewMovieName = movieName.getText().toString();
//                int returnMovieRating1 = movieRating.getNumStars();
//
//                String returnMovieRating = String.valueOf(returnMovieRating1);




                   String returnMovieId = String.valueOf(1);
                   String numofRatingStars = String.valueOf(movieRating.getRating());



                Intent data = new Intent();
                data.putExtra("return_movie_name",returnNewMovieName);
                data.putExtra("return_movie_rating",numofRatingStars);
                data.putExtra("return_movie_id",returnMovieId);

                setResult(RESULT_OK,data);
                Main2Activity.this.finish();
                }
        });

    }
}
