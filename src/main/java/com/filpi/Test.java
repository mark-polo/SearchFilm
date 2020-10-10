package com.filpi;

import com.filpi.IMDbFilm.GetFilm;
import com.filpi.IMDbFilm.IMDbFilmUseOMDbAPI;
import com.filpi.RandomIMDBFilm.IMDBModel;
import com.filpi.RandomIMDBFilm.RandomFilmWithInforFromIMDBUseOMDbAPI;
import com.filpi.Recommendation.Recommendation;

import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws IOException {
        IMDBModel model = new IMDBModel();

        System.out.println(GoogleFilmPage.FilmYear("тупой и еще тупее"));
        System.out.println(GoogleFilmPage.FilmGenre("третий лишний"));
        System.out.println(GoogleFilmPage.FilmPoster("миллион способов потерять голову"));
        System.out.println(GoogleFilmPage.FilmName("Джанго освобождённый"));
        System.out.println(GoogleFilmPage.FilmPlot("12 лет рабства"));

        ArrayList<String> arr = GoogleFilmPage.FilmActorsAndSameFilms("миллион способов потерять голову");
        System.out.println(arr);

        System.out.println(GoogleFilmPage.FilmRatings("тупой и еще тупее 2"));

        System.out.println(RandomFilmWithInforFromIMDBUseOMDbAPI.film(model , "your omdb api key" , 0 , 100 , 2 , 2));

        System.out.println(IMDbFilmUseOMDbAPI.IMDbFilm(model , "your omdb api key" , "12 лет рабства" , 3));

        ArrayList<String> key = new ArrayList<>();
        key.add("комедии");

        System.out.println(Recommendation.filmRec("Полтора шпиона" , key));
    }
}