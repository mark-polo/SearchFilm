package com.filpi.Recommendation;

import com.filpi.GetFilmInfoUseURL.FilmInfoUseURL;
import com.filpi.GoogleFilmPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Recommendation {

    public static String filmRec(String film_name , ArrayList<String> keywords) throws IOException {
        String urlList = null;

        ArrayList<String> sameFilm = GoogleFilmPage.FilmActorsAndSameFilms(film_name);

        Movie movie = new Movie();

        movie.setKeywords(keywords);

        ArrayList<String> key =  movie.getKeywords();

        URL url = new URL("https://www.google.com/search?q="+ key.get(0) + "+фильм&rlz=1C1SQJL_ruUA815UA815&oq="+ key.get(0) +"+фильм&aqs=chrome..69i57.19174j0j7&sourceid=chrome&ie=UTF-8");

        Document doc = Jsoup.connect(String.valueOf(url)).get();

        Elements el =  doc.select(".jhtnKe a");

        for (Element e : el) {
            urlList = e.absUrl("href");
        }

        return  "Рекомендованные фильмы : " + "\n" +
                sameFilm.get(5) + "\n" +
                sameFilm.get(6) + "\n" +
                sameFilm.get(7) + "\n" +
                sameFilm.get(8) + "\n" +
                sameFilm.get(9) + "\n" +
                "Фильмы  по ключевому слову : " + "\n" +
                FilmInfoUseURL.getInfoAboutFilmTitle(urlList) + "\n" +
                FilmInfoUseURL.getInfoAboutFilmYear(urlList) + "\n" +
                FilmInfoUseURL.getInfoAboutFilmGenre(urlList) + "\n" +
                FilmInfoUseURL.getInfoAboutFilmRatings(urlList);
    }
}