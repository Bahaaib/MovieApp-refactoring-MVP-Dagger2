package com.example.bahaa.movieapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.bahaa.movieapp.root.App;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import javax.inject.Inject;

public class MovieActivity extends AppCompatActivity implements MovieMVP.View {


    private ArrayList<Movie> movies;
    private RecyclerView recyclerView;
    private MovieAdapter adapter;
    private GridLayoutManager gridLayoutManager;

    @Inject
    public MovieMVP.Presenter presenter;

    @Inject
    public Picasso picasso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        ((App) getApplication()).getComponent().inject(this);
        Log.i("main", "injected");

        presenter.setView(this);
        presenter.setOrderPreference("popular?");


        movies = new ArrayList<>();


        presenter.callMovieApi();
        presenter.getMovieResponse();

        initRecyclerView();


        //Log.i("main", movies.get(0).getMovieTitle());


    }

    @Override
    public void setMovieList(ArrayList<Movie> movieList) {
        this.movies = movieList;
    }

    @Override
    public void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.gameRecyclerView);
        adapter = new MovieAdapter(this, movies, picasso);
        recyclerView.setAdapter(adapter);
        gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        Log.i("main", "RV is OK!");


    }

    @Override
    public void notifyAdapter() {
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("main", "onResume");

        // presenter.setView(this);
        // presenter.setOrderPreference("popular?");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("main", "onStart");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.pref_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.popular_item:
                presenter.setOrderPreference("popular?");
                adapter.notifyDataSetChanged();
                break;
            case R.id.top_rated_item:
                presenter.setOrderPreference("top_rated?");
                presenter.callMovieApi();
                adapter.notifyDataSetChanged();
                break;
        }
        return true;


    }


}
