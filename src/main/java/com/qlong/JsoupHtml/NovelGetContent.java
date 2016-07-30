package com.qlong.JsoupHtml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by qianlong on 2016/7/24.
 */
public class NovelGetContent {
    private Logger logger = LoggerFactory.getLogger(NovelGetContent.class);
    public Document getDocument(String url){
        try {
            return Jsoup.connect(url).timeout(3000).get();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Document getChapterList(String url){
        return this.getDocument(url);
    }

    public Document getChapterDocument(String url){
        return this.getDocument(url);
    }

    public String getChapterContent(Document doc){
        return "";
    }
}
