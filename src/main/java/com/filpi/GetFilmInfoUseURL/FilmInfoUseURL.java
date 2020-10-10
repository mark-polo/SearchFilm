package com.filpi.GetFilmInfoUseURL;

import com.filpi.ProjectGlobalVariables.GlobalVar;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilmInfoUseURL {

    public static String getInfoAboutFilmTitle(String url) throws IOException {

        URL url_inf = new URL(url);

        Document doc = Jsoup.connect(String.valueOf(url_inf)).get();
        GlobalVar.FILM_INFO_USE_URL_TITLE = doc.select(".SPZz6b h2").text();

        return GlobalVar.FILM_INFO_USE_URL_TITLE;

    }
    public static String getInfoAboutFilmYear(String url) throws IOException {

        URL url_inf = new URL(url);

        Document doc = Jsoup.connect(String.valueOf(url_inf)).get();
        String el_gy = doc.select(".wwUB2c.PZPZlf span").text();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(el_gy);
        if(matcher.find()) GlobalVar.FILM_INFO_USE_URL_YEAR = matcher.group(); /// only year

        return GlobalVar.FILM_INFO_USE_URL_YEAR;

    }
    public static String getInfoAboutFilmGenre(String url) throws IOException {

        URL url_inf = new URL(url);

        Document doc = Jsoup.connect(String.valueOf(url_inf)).get();
        String el_gg = doc.select(".wwUB2c.PZPZlf span").text();

        Pattern pattern = Pattern.compile("(‧)\\D+");
        Matcher matcher = pattern.matcher(el_gg);
        if(matcher.find()) GlobalVar.FILM_INFO_USE_URL_GENRE = matcher.group(); /// only genre

        return GlobalVar.FILM_INFO_USE_URL_GENRE;

    }
    public static String getInfoAboutFilmRatings(String url) throws IOException {

        URL url_inf = new URL(url);

        Document doc = Jsoup.connect(String.valueOf(url_inf)).get();
        String rat = doc.select(".yQ8hqd.ksSzJd.w6Utff span").text();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(rat);
        if(matcher.find()) GlobalVar.FILM_INFO_USE_URL_RATINGS = matcher.group(); /// only rating

        return GlobalVar.FILM_INFO_USE_URL_RATINGS + " / " + "10";

    }
}