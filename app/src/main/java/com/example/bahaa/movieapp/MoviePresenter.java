package com.example.bahaa.movieapp;

import android.support.annotation.NonNull;
import android.util.Log;

public class MoviePresenter implements MovieMVP.Presenter, VolleyListener {

    @NonNull
    private MovieMVP.View view;
    public MovieMVP.Model model;

    private String pref;

    public MoviePresenter(MovieMVP.View view) {
        this.view = view;
    }

    public MoviePresenter(MovieMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(MovieMVP.View view) {
        this.view = view;
    }


    @Override
    public void callMovieApi() {
        Log.i("presenter", "presenter");
        model.createMovieList(pref, this);
    }

    @Override
    public void getMovieResponse() {
        view.setMovieList(model.getMovieList());
    }

    @Override
    public void setOrderPreference(String pref) {
        this.pref = pref;
    }

    @Override
    public void notifyView() {

        view.notifyAdapter();


    }


    @Override
    public void onFinished() {
        notifyView();
    }
}
