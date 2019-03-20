package com.example.ahattab.moviestarrating;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private List<Movie> movieList = new ArrayList<>();

   // private MovieAdapter movieAdapter;
    String returnedMovieNmae;
     String returnedRating;
     String returnedId;
    ArrayList<Movie> alm = new ArrayList<>();
    Movie m = null;
    MovieAdapter movieAdapter = new MovieAdapter(movieList);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycle = findViewById(R.id.recycle1);
       // movieAdapter = new MovieAdapter(movieList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recycle.setLayoutManager(layoutManager);
        recycle.setItemAnimator(new DefaultItemAnimator());
        recycle.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recycle.setAdapter(movieAdapter);
        //movieList.addAll(generateData());
        Button addRec = findViewById(R.id.btn_addRecord);

        addRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (getApplicationContext(),Main2Activity.class);
                startActivityForResult(i,1);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        if (requestCode == 1 && resultCode == RESULT_OK){

             returnedMovieNmae = data.getStringExtra("return_movie_name");
            System.out.println("onActivityResult movie name: " + returnedMovieNmae);
             returnedRating = data.getStringExtra("return_movie_rating");
            float rRating = Float.parseFloat(returnedRating);
//            System.out.println("Rating: " + rRating);
            returnedId = data.getStringExtra("return_movie_id");
            int rId = Integer.valueOf(returnedId);

            int m3= movieList.size()-1;
            m3++;

            Movie m1  = new Movie(returnedMovieNmae, rRating, m3);
            movieList.add(m1);


            }
    }



    protected ArrayList<Movie> generateData()
    {
        m = new Movie("manual value 1", 1, 1);
        System.out.println("movie name 2: " + returnedMovieNmae);
//       m = new Movie(m.getMovieName(), 2, 1);
        alm.add(m);
        return alm;

    }

}
