package com.example.bahaa.movieapp.root;

import android.app.Application;
import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Named("application_context")
    @Singleton
    @Provides
    public Context provideContext(){
        return application;
    }


}
