package com.example.bahaa.movieapp;

import java.util.ArrayList;

public interface MovieRepository {


    void saveMoviesFromAPI(String url, String key, String pref, VolleyListener listener);

    ArrayList<Movie> getMovieFromAPI();


}
