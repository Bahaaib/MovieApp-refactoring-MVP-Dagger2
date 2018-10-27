package com.example.bahaa.movieapp.root;

import com.example.bahaa.movieapp.MovieActivity;
import com.example.bahaa.movieapp.MovieModule;
import com.example.bahaa.movieapp.PicassoModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {ApplicationModule.class, MovieModule.class, PicassoModule.class})
public interface ApplicationComponent {

     void inject(MovieActivity target);
}
