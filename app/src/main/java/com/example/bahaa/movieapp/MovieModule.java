package com.example.bahaa.movieapp;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class MovieModule {

    @Provides
    public MovieMVP.Presenter provideMoviePresenter(MovieMVP.Model model){
        return new MoviePresenter(model);
    }


    @Provides
    public MovieMVP.Model provideMovieModel(MovieRepository repository){
        return new MovieModel(repository);
    }

    @Provides
    public MovieRepository provideMovieRepository(Context context){
        return new TMBDRepository(context);
    }

}
