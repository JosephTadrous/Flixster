package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    String title;
    String posterPath;
    String overview;

    public Movie(JSONObject jsonObject) throws JSONException {
        title = jsonObject.getString("title");
        posterPath = jsonObject.getString("poster_path");
        overview = jsonObject.getString("overview");
    }

    public static List<Movie> moviesFromJSONArray(JSONArray moviesJSONArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < moviesJSONArray.length(); i++) {
            // populating movies list
            movies.add(new Movie(moviesJSONArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getOverview() {
        return overview;
    }
}
