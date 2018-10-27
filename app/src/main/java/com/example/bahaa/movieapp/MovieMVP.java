package com.example.bahaa.movieapp;

import java.util.ArrayList;

public interface MovieMVP {

    interface View {

        void setMovieList(ArrayList<Movie> movieList);

        void initRecyclerView();

        void notifyAdapter();

    }


    interface Presenter {

        void setView(MovieMVP.View view);

        void callMovieApi();

        void getMovieResponse();

        void setOrderPreference(String pref);

        void notifyView();






    }


    interface Model {
        void createMovieList(String pref, VolleyListener listener);

        ArrayList<Movie> getMovieList();

    }
}
