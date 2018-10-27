package com.example.bahaa.movieapp;

import android.content.Context;

import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PicassoModule {

    @Singleton
    @Provides
    public Picasso providePicaaso(Context context){
        return Picasso.with(context);
    }
}
