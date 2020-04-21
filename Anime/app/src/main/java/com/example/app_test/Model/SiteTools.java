package com.example.app_test.Model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
public class SiteTools {
    public static String getVideoURL(String response) {
        String js = "";
        Document document = Jsoup.parse(response);
        Element divElement = document.getElementById("Movie");
        for (Element javascript : divElement.children()) {
            if (javascript.tagName().equals("script")) {
                js = javascript.html();
            }
        }
        int firstIndex = js.indexOf("\"", js.indexOf("file"));
        int secondIndex = js.indexOf("\"", firstIndex + 1);
        String result = js.substring(firstIndex + 1, secondIndex);
        return result;
    }
}
