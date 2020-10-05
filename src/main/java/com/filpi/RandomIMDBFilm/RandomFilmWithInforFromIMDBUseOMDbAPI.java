package com.filpi.RandomIMDBFilm;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomFilmWithInforFromIMDBUseOMDbAPI {

    public static String film(IMDBModel model , String api , int minIndexOfRandom , int maxIndexOfRandom , int countOfPages , int index) throws IOException {

        ArrayList<String> pack = new ArrayList<>();

        URL url = new URL("http://www.omdbapi.com/?i=" + RandomIMDBFilm.parser(randomIMDBId(minIndexOfRandom , maxIndexOfRandom) , countOfPages) + "&apikey=" + api);

        Scanner in = new Scanner((InputStream) url.getContent());

        StringBuilder result = new StringBuilder();

        while (in.hasNext()) {
            result.append(in.nextLine());
        }
        try {
            JSONObject object = new JSONObject(result.toString());
            model.setTitle(object.getString("Title"));
            model.setImdbRating(object.getString("imdbRating"));
            model.setRated(object.getString("Rated"));
            model.setImdbID(object.getString("imdbID"));
            model.setYear(object.getString("Year"));
            model.setImdbVotes(object.getString("imdbVotes"));
            model.setCountry(object.getString("Country"));
            model.setPoster(object.getString("Poster"));
            model.setGenre(object.getString("Genre"));
            model.setDirector(object.getString("Director"));
            model.setRunTime(object.getString("Runtime"));
            model.setPlot(object.getString("Plot"));

            pack.add(model.getTitle());
            pack.add(model.getImdbRating());
            pack.add(model.getRated());
            pack.add(model.getImdbID());
            pack.add(model.getYear());
            pack.add(model.getImdbVotes());
            pack.add(model.getCountry());
            pack.add(model.getPoster());
            pack.add(model.getGenre());
            pack.add(model.getDirector());
            pack.add(model.getRunTime());
            pack.add(model.getPlot());

            return pack.get(index);

        } catch (JSONException e) {
           return "Error...";
        }
    }

    public static int randomIMDBId(int min , int max) {
        Random rand = new Random();
        return rand.nextInt((max-min)+1)+min;
    }

}