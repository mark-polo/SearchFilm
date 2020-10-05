package com.filpi;

import com.filpi.ProjectGlobalVariables.GlobalVar;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoogleFilmPage {
    public static String FilmYear(String film_name) throws IOException {
        URL url = new URL("https://www.google.com/search?newwindow=1&hl=ru&source=hp&ei=dOc_X4DiDc3zgAbbz4WQCA&q=" + film_name + "&oq="  + film_name + "&gs_lcp=CgZwc3ktYWIQAzIFCC4QkwIyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCABKBQgEEgExSgUIBxIBMUoFCAgSATFQg8YIWIPGCGDwzwhoAHAAeACAAR2IAR2SAQExmAEAoAECoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwiA7NTLzazrAhXNOcAKHdtnAYIQ4dUDCAc&uact=5");

        Document doc = Jsoup.connect(String.valueOf(url)).get();
        String el_gy = doc.select(".wwUB2c.PZPZlf span").text();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(el_gy);
        if(matcher.find()) GlobalVar.FILM_YEAR_IN_GOOGLE_PAGE = matcher.group(); /// only year

        return GlobalVar.FILM_YEAR_IN_GOOGLE_PAGE;
    }

    public static String FilmGenre(String film_name) throws IOException {
        URL url = new URL("https://www.google.com/search?newwindow=1&hl=ru&source=hp&ei=dOc_X4DiDc3zgAbbz4WQCA&q=" + film_name + "&oq="  + film_name + "&gs_lcp=CgZwc3ktYWIQAzIFCC4QkwIyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCABKBQgEEgExSgUIBxIBMUoFCAgSATFQg8YIWIPGCGDwzwhoAHAAeACAAR2IAR2SAQExmAEAoAECoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwiA7NTLzazrAhXNOcAKHdtnAYIQ4dUDCAc&uact=5");

        Document doc = Jsoup.connect(String.valueOf(url)).get();
        String el_gg = doc.select(".wwUB2c.PZPZlf span").text();

        Pattern pattern = Pattern.compile("(‧)\\D+");
        Matcher matcher = pattern.matcher(el_gg);
        if(matcher.find()) GlobalVar.FILM_GENRE_IN_GOOGLE_PAGE = matcher.group(); /// only genre

        return GlobalVar.FILM_GENRE_IN_GOOGLE_PAGE;
    }

    public static String FilmPoster(String film_name) throws IOException {
        URL url = new URL("https://www.google.com/search?newwindow=1&hl=ru&source=hp&ei=dOc_X4DiDc3zgAbbz4WQCA&q=" + film_name + "&oq="  + film_name + "&gs_lcp=CgZwc3ktYWIQAzIFCC4QkwIyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCABKBQgEEgExSgUIBxIBMUoFCAgSATFQg8YIWIPGCGDwzwhoAHAAeACAAR2IAR2SAQExmAEAoAECoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwiA7NTLzazrAhXNOcAKHdtnAYIQ4dUDCAc&uact=5");

        Document doc = Jsoup.connect(String.valueOf(url)).get();
        Elements el_filmpro = doc.select(".r a");
        for(Element el : el_filmpro) {
            if(el.absUrl("href").startsWith("https://www.film.ru/")) {
                URL url_film = new URL(el.absUrl("href"));

                Document doc_film = Jsoup.connect(String.valueOf(url_film)).get();
                GlobalVar.FILM_POSTER_IN_GOOGLE_PAGE = doc_film.select(".movies-left img").attr("src");
            }
        }
        return GlobalVar.FILM_POSTER_IN_GOOGLE_PAGE;
    }

    public static String FilmName(String film_name) throws IOException {
        URL url = new URL("https://www.google.com/search?newwindow=1&hl=ru&source=hp&ei=dOc_X4DiDc3zgAbbz4WQCA&q=" + film_name + "&oq="  + film_name + "&gs_lcp=CgZwc3ktYWIQAzIFCC4QkwIyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCABKBQgEEgExSgUIBxIBMUoFCAgSATFQg8YIWIPGCGDwzwhoAHAAeACAAR2IAR2SAQExmAEAoAECoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwiA7NTLzazrAhXNOcAKHdtnAYIQ4dUDCAc&uact=5");

        Document doc = Jsoup.connect(String.valueOf(url)).get();
        GlobalVar.FILM_NAME_IN_GOOGLE_PAGE = doc.select(".SPZz6b h2").text();

        return GlobalVar.FILM_NAME_IN_GOOGLE_PAGE;
    }
    public static String FilmPlot(String film_name) throws IOException {
        URL url = new URL("https://www.google.com/search?newwindow=1&hl=ru&source=hp&ei=dOc_X4DiDc3zgAbbz4WQCA&q=" + film_name + "&oq="  + film_name + "&gs_lcp=CgZwc3ktYWIQAzIFCC4QkwIyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCABKBQgEEgExSgUIBxIBMUoFCAgSATFQg8YIWIPGCGDwzwhoAHAAeACAAR2IAR2SAQExmAEAoAECoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwiA7NTLzazrAhXNOcAKHdtnAYIQ4dUDCAc&uact=5");

        Document doc = Jsoup.connect(String.valueOf(url)).get();
        GlobalVar.FILM_PLOT_IN_GOOGLE_PAGE = doc.select(".kno-rdesc span").text();

        return GlobalVar.FILM_PLOT_IN_GOOGLE_PAGE;
    }
    public static ArrayList<String> FilmActorsAndSameFilms(String film_name) throws IOException {
        ArrayList<String> arr_ga = new ArrayList<>();
        URL url = new URL("https://www.google.com/search?newwindow=1&hl=ru&source=hp&ei=dOc_X4DiDc3zgAbbz4WQCA&q=" + film_name + "&oq="  + film_name + "&gs_lcp=CgZwc3ktYWIQAzIFCC4QkwIyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCABKBQgEEgExSgUIBxIBMUoFCAgSATFQg8YIWIPGCGDwzwhoAHAAeACAAR2IAR2SAQExmAEAoAECoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwiA7NTLzazrAhXNOcAKHdtnAYIQ4dUDCAc&uact=5");

        Document doc = Jsoup.connect(String.valueOf(url)).get();
        Elements el_ga = doc.select(".zVvuGd.MRfBrb a");
        for(Element el : el_ga) {
            arr_ga.add(el.attr("title"));
        }

        return arr_ga;
    }

    public static String FilmRatings (String film_name) throws IOException {

        URL url = new URL("https://www.google.com/search?newwindow=1&hl=ru&source=hp&ei=dOc_X4DiDc3zgAbbz4WQCA&q=" + film_name + "&oq="  + film_name + "&gs_lcp=CgZwc3ktYWIQAzIFCC4QkwIyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCABKBQgEEgExSgUIBxIBMUoFCAgSATFQg8YIWIPGCGDwzwhoAHAAeACAAR2IAR2SAQExmAEAoAECoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwiA7NTLzazrAhXNOcAKHdtnAYIQ4dUDCAc&uact=5");

        Document doc = Jsoup.connect(String.valueOf(url)).get();
        String rat = doc.select(".yQ8hqd.ksSzJd.w6Utff span").text();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(rat);
        if(matcher.find()) GlobalVar.FILM_RATINGS_IN_GOOGLE_PAGE = matcher.group(); /// only rating

        return GlobalVar.FILM_RATINGS_IN_GOOGLE_PAGE + " / " + "10";

    }
}