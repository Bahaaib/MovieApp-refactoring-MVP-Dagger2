package com.example.bahaa.movieapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.like.LikeButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class MovieAdapter extends RecyclerView.Adapter {

    //Here we recieve from the calling Activity :
    // The cards container List & The Parent Activity context

    private Context context;
    private ArrayList<Movie> adapterModel;


    private Picasso picasso;

    {
        adapterModel = new ArrayList<>();
    }


    public MovieAdapter(Context context, ArrayList<Movie> adapterModel, Picasso picasso) {
        this.context = context;
        this.adapterModel = adapterModel;
        this.picasso = picasso;

    }


    //Here We tell the RecyclerView what to show at each element of it..it'd be a cardView!
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.movie_card, parent, false);
        return new MovieViewHolder(view);
    }

    //Here We tell the RecyclerView what to show at each CardView..
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MovieViewHolder) holder).BindView(position);

    }

    @Override
    public int getItemCount() {
        return adapterModel.size();
    }


    //Here we bind all the children views of each cardView with their corresponding
    // actions to show & interact with them
    public class MovieViewHolder extends RecyclerView.ViewHolder {

        public ImageView moviePoster;
        public LikeButton favoriteButton;
        // public boolean isFavorite;
        //public ArrayList<Integer> favoriteMoviesIdList = new ArrayList<>();


        public MovieViewHolder(View itemView) {
            super(itemView);

            moviePoster = (ImageView) itemView.findViewById(R.id.movie_poster);
            favoriteButton = (LikeButton) itemView.findViewById(R.id.fav_heart);


        }


        //Here where all the glory being made..!
        public void BindView(final int position) {


            picasso.load(APIHelper.IMG_URL + APIHelper.IMG_SIZE + adapterModel.get(position).getMoviePoster())
                    .fit()
                    .into(moviePoster);


        }


    }


}