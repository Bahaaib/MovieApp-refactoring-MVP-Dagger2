package com.example.bahaa.movieapp.root;

import android.app.Application;

import com.example.bahaa.movieapp.MovieModule;
import com.example.bahaa.movieapp.PicassoModule;

public class App extends Application {

    public ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .picassoModule(new PicassoModule())
                .movieModule(new MovieModule())
                .build();

    }

    public ApplicationComponent getComponent(){
        return component;
    }

}
