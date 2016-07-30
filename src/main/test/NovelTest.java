import com.qlong.dao.IChapterMapper;
import com.qlong.dao.INovelMapper;
import com.qlong.model.Chapter;
import com.qlong.model.Novel;
import org.joda.time.DateTime;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by qianlong on 2016/7/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class NovelTest {

    @Autowired
    IChapterMapper chapterMapper;
    @Autowired
    INovelMapper novelMapper;

    @Test
    public void doNovelRead() throws IOException {
        String url = "http://www.biquge.la/book/168/";
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.getElementById("list").getElementsByTag("a");
        String chapterName = "";
        String content = "";
        int novelId = 5;
        int i=0;
        for (Element element : elements){
           if (i==0){
               Chapter chapter = new Chapter();
               chapter.setChapterName(element.text());
               chapter.setNovelId(5);
               Document chapterContent = Jsoup.connect(url+element.attr("href")).get();
               chapter.setContent(Jsoup.clean(chapterContent.getElementById("content").html(), Whitelist.basic()));
               chapterMapper.insertChapter(chapter);
               i++;
           }
        }

    }






}
