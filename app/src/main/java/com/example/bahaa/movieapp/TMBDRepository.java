package com.example.bahaa.movieapp;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

public class TMBDRepository implements MovieRepository {


    private MovieMVP.Model model;
    private ArrayList<Movie> movieList = new ArrayList<>();

    private RequestQueue requestQueue;

    @Inject
    public TMBDRepository(@Named("application_context") Context mContext) {
        requestQueue = Volley.newRequestQueue(mContext);
    }


    @Override
    public void saveMoviesFromAPI(String url, String key, String pref, final VolleyListener listener) {


        movieList.clear();
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                url + pref + "api_key=" + key,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            Log.i("titles", "Got Response!");

                            // Initialize Gson and start new transaction
                            Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
                                @Override
                                public boolean shouldSkipField(FieldAttributes f) {
                                    return false;
                                }

                                @Override
                                public boolean shouldSkipClass(Class<?> clazz) {
                                    return false;
                                }
                            }).create();

                            JSONArray jsonArray = response.getJSONArray("results");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                Movie movie = gson.fromJson(jsonArray.get(i).toString(), Movie.class);
                                Log.i("titles", movie.getMovieTitle());
                                movieList.add(movie);
                            }
                            listener.onFinished();
                        } catch (JSONException e) {

                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener()


        {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });
        requestQueue.add(request);

    }

    @Override
    public ArrayList<Movie> getMovieFromAPI() {
        return movieList;
    }


}
