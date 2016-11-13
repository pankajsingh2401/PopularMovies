package com.singh.pankaj.android.popularmovies.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;import com.singh.pankaj.android.popularmovies.PopularMoviesFragment;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Pankaj on 11/8/2016.
 */

public class Movie implements Parcelable {

    private int id;
    private String title;   //original_title
    private String image;   //poster_path
    private String image2;  //backdrop_path
    private String overview;
    private int rating;  //vote_average
    private String date;    //release_path

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getImage2() {
        return image2;
    }

    public String getOverview() {
        return overview;
    }

    public int getRating() {
        return rating;
    }

    public String getDate() {
        return date;
    }


    //Default constructor accepting zero parameters
    public Movie()
    {

    }
    //constructor accepting Movie instance
    private Movie(Parcel in)
    {
        this.id = in.readInt();
        this.title = in.readString();
        this.image = in.readString();
        this.image2 =in.readString();
        this.overview =in.readString();
        this.rating = in.readInt();
        this.date = in.readString();

    }
    //Override the method of parcelable describeContents
    @Override
    public int describeContents()
    {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel destination, int flags) {
        destination.writeInt(id);
        destination.writeString(title);
        destination.writeString(image);
        destination.writeString(image2);
        destination.writeString(overview);
        destination.writeInt(rating);
        destination.writeString(date);
    }
    public static final Parcelable.Creator<Movie> CREATOR =new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[0];
        }
    };
    public Movie(JSONObject movie) throws JSONException {
        this.id = movie.getInt("id");
        this.title = movie.getString("original_title");
        this.image = movie.getString("poster_path");
        this.image2 = movie.getString("backdrop_path");
        this.overview = movie.getString("overview");
        this.rating = movie.getInt("vote_average");
        this.date = movie.getString("release_date");
    }
    public Movie(Cursor cursor) {
        this.id = cursor.getInt(PopularMoviesFragment.COL_MOVIE_ID);
        this.title = cursor.getString(PopularMoviesFragment.COL_TITLE);
        this.image = cursor.getString(PopularMoviesFragment.COL_IMAGE);
        this.image2 = cursor.getString(PopularMoviesFragment.COL_IMAGE2);
        this.overview = cursor.getString(PopularMoviesFragment.COL_OVERVIEW);
        this.rating = cursor.getInt(PopularMoviesFragment.COL_RATING);
        this.date = cursor.getString(PopularMoviesFragment.COL_DATE);
    }
}
