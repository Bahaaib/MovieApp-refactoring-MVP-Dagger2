package com.example.bahaa.movieapp.root;

import android.app.Application;

import com.example.bahaa.movieapp.MovieModule;

public class App extends Application {

    public ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .movieModule(new MovieModule())
                .build();

    }

    public ApplicationComponent getComponent(){
        return component;
    }

}
