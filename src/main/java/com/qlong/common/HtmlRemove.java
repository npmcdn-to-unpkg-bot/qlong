package com.qlong.common;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qianlong on 2016/7/24.
 */
public class HtmlRemove {

    public static String delHTMLTag(String htmlStr){
        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式

        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
        Matcher m_script=p_script.matcher(htmlStr);
        htmlStr=m_script.replaceAll(""); //过滤script标签

        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
        Matcher m_style=p_style.matcher(htmlStr);
        htmlStr=m_style.replaceAll(""); //过滤style标签

        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
        Matcher m_html=p_html.matcher(htmlStr);
        htmlStr=m_html.replaceAll(""); //过滤html标签

        return htmlStr.trim(); //返回文本字符串
    }

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://www.piaotian.net/html/7/7037/4064638.html").userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.106 Safari/537.36").cookie("jq_Obj","1").get();
        System.out.println(doc.html());
        doc.getElementById("guild").remove();
        doc.getElementById("shop").remove();
        doc.getElementsByTag("center").remove();
        doc.getElementsByClass("bottomlink").remove();
        doc.getElementById("Commenddiv").remove();
        doc.getElementById("feit2").remove();
        int size = doc.getElementsByTag("div").size();
        doc.getElementsByTag("div").get(size-1).remove();
        String content = Jsoup.clean(doc.html(),Whitelist.basic());
        System.out.println(content);

    }
}
