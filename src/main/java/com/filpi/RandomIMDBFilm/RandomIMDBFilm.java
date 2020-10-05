package com.filpi.RandomIMDBFilm;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RandomIMDBFilm {

    public static String parser(int index , int countOfPages) throws IOException {

        ArrayList<String> ids = new ArrayList<>();
        String id;
        for(int i = 1; i <= countOfPages; i++) {
            URL url = new URL("https://www.imdb.com/search/title/?title_type=feature&num_votes=25,&view=simple&sort=num_votes,desc&start=" + i + "&ref_=adv_nxt");

            Document doc = Jsoup.connect(String.valueOf(url)).get();

            Elements el = doc.select(".col-title a");
            for(Element e : el) {
                id = e.absUrl("href");
                Pattern p = Pattern.compile("(tt)\\d+");
                Matcher m = p.matcher(id);
                if(m.find()) ids.add(m.group());
            }
        }

        return ids.get(index);
    }

}
