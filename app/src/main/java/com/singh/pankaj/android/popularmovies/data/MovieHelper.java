package com.singh.pankaj.android.popularmovies.data;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.os.Build.VERSION_CODES.M;


/**
 * Created by Pankaj on 11/7/2016.
 */

public class MovieHelper extends SQLiteOpenHelper {

    private static  int DATABASE_VERSION=1;
    static String DATABASE_NAME="movie.db";
    public MovieHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        final String SQL_CREATE_MOVIE_TABLE="CREATE TABLE"+MovieContract.MovieEntity.TABLE_NAME+ "("+
                MovieContract.MovieEntity._ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                MovieContract .MovieEntity.COLUMN_MOVIE_ID +" INTEGER NOT NULL, "+
                MovieContract .MovieEntity.COLUMN_TITLE +" TEXT,  "+
                MovieContract.MovieEntity.COLUMN_IMAGE +" TEXT,  "+
                MovieContract.MovieEntity.COLUMN_IMAGE2 +" TEXT,  "+
                MovieContract.MovieEntity.COLUMN_OVERVIEW +" TEXT,  "+
                MovieContract.MovieEntity.COLUMN_RATING +" INTEGER,  "+
                MovieContract.MovieEntity.COLUMN_DATE +" TEXT);  ";
        db.execSQL(SQL_CREATE_MOVIE_TABLE);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String DELETE_OLD_DATABASE="DROP TABLE IF EXISTS " + MovieContract.MovieEntity.TABLE_NAME +"";
        db.execSQL(DELETE_OLD_DATABASE);


    }

}
