package com.example.bahaa.movieapp;

import java.util.ArrayList;


public class MovieModel implements MovieMVP.Model {

    private MovieRepository movieRepository;


    public MovieModel(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void createMovieList(String preference, VolleyListener listener) {
        movieRepository.saveMoviesFromAPI(APIHelper.API_URL,
                APIHelper.API_KEY,
                preference, listener);


    }

    @Override
    public ArrayList<Movie> getMovieList() {
        return movieRepository.getMovieFromAPI();
    }


}
