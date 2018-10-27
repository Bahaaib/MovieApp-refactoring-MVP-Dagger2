package com.example.bahaa.movieapp;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("original_title")
    private String movieTitle;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("poster_path")
    private String moviePoster;

    @SerializedName("vote_average")
    private Float voteAvg;

    @SerializedName("overview")
    private String moviePlot;

    @NonNull

    @SerializedName("id")
    private Integer movieId;



    public Movie() {

        //Required Empty Constructor
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }

    public Float getVoteAvg() {
        return voteAvg;
    }

    public void setVoteAvg(Float voteAvg) {
        this.voteAvg = voteAvg;
    }

    public String getMoviePlot() {
        return moviePlot;
    }

    public void setMoviePlot(String moviePlot) {
        this.moviePlot = moviePlot;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }
}