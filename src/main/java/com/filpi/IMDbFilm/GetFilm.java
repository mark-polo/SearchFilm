package com.filpi.IMDbFilm;

import com.filpi.ProjectGlobalVariables.GlobalVar;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetFilm {
    public static String getFilm(String film_name) throws IOException {
        URL url = new URL("https://www.google.com/search?newwindow=1&hl=ru&source=hp&ei=dOc_X4DiDc3zgAbbz4WQCA&q=" + film_name + "&oq="  + film_name + "&gs_lcp=CgZwc3ktYWIQAzIFCC4QkwIyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCABKBQgEEgExSgUIBxIBMUoFCAgSATFQg8YIWIPGCGDwzwhoAHAAeACAAR2IAR2SAQExmAEAoAECoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwiA7NTLzazrAhXNOcAKHdtnAYIQ4dUDCAc&uact=5");

        Document doc = Jsoup.connect(String.valueOf(url)).get();

        Elements el = doc.select(".yuRUbf a");

        for(Element e : el) {
            if(e.absUrl("href").startsWith("https://ru.wikipedia.org/wiki/")) {
                GlobalVar.FILM_WIKIPEDIA_URL_FROM_GOOGLE_PAGE = e.absUrl("href");
            }
        }

        /////////// from wikipedia page get imdb url and get id ////////////
        URL url_w = new URL(GlobalVar.FILM_WIKIPEDIA_URL_FROM_GOOGLE_PAGE);

        Document doc_w = Jsoup.connect(String.valueOf(url_w)).get();

        Elements el_w = doc_w.select(".mw-parser-output a");

        for(Element e : el_w) {
            if(e.absUrl("href").startsWith("https://www.imdb.com/title/")) {
                GlobalVar.FILM_IMDB_URL_FROM_WIKIPEDIA_PAGE = e.absUrl("href");
                Pattern p = Pattern.compile("(tt)\\d+");
                Matcher m = p.matcher(GlobalVar.FILM_IMDB_URL_FROM_WIKIPEDIA_PAGE);
                if(m.find()) GlobalVar.FILM_IMDB_ID_FROM_WIKIPEDIA_PAGE = m.group(); //// write only film id f.e. (tt3456789)
            }
        }

        return GlobalVar.FILM_IMDB_ID_FROM_WIKIPEDIA_PAGE;
    }
}