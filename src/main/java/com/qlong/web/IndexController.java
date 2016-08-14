package com.qlong.web;

import com.qlong.dao.IChapterMapper;
import com.qlong.dao.INovelMapper;
import com.qlong.dao.IUserMapper;
import com.qlong.model.Chapter;
import com.qlong.model.Novel;
import com.qlong.model.Pagtion;
import com.qlong.model.User;
import com.qlong.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qianlong on 2016/7/21.
 */
@Controller
public class IndexController {
    @Autowired
    private IUserMapper userMapper;
    @Autowired
    private INovelMapper novelMapper;
    @Autowired
    private IChapterMapper chapterMapper;
    @Autowired
    ChapterService chapterService;


    @RequestMapping(value = {"/","index.html"})
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @ResponseBody
    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable("id") int id){
        User user = userMapper.getUserById(id);
        return user;
    }

    @ResponseBody
    @RequestMapping("/novel/{id}")
    public Novel getNovel(@PathVariable("id") int id){
        Novel novel = novelMapper.getNovelById(id);
        List<Chapter> chapters = chapterMapper.getChapterByNovelId(id);
        novel.setChapters(chapters);
        return novel;
    }

    @ResponseBody
    @RequestMapping("/chapter/{id}")
    public Chapter getChapter(@PathVariable("id") int id){
        Chapter chapter = chapterMapper.getChapterById(id);
        return chapter;
    }

    @ResponseBody
    @RequestMapping("/chapters/{id}")
    public List<Chapter> getChapters(@PathVariable("id") int id){
        List<Chapter> chapters = chapterMapper.getChapterByNovelId(id);
        return chapters;
    }

    @ResponseBody
    @RequestMapping("/page")
    public Pagtion<Chapter> getChapterList(HttpServletRequest request){
        String pageSize = request.getParameter("pageSize");
        String pageNo = request.getParameter("pageNo");
        String novelId = request.getParameter("novelId");
        Pagtion<Chapter> pagtion = chapterService.getChapterPage(Integer.valueOf(novelId),Integer.valueOf(pageSize),Integer.valueOf(pageNo));
        return pagtion;
    }

    @RequestMapping("/chapter/{novelId}/{chapterId}")
    public ModelAndView getChapter(@PathVariable("novelId") int novelId,@PathVariable("chapterId") int chapterId){
        Chapter chapter = chapterMapper.getChapterById(chapterId);



        Map<String,Object>  map = new HashMap<String, Object>();
        map.put("chapter",chapter);
        return new ModelAndView("chapter",map);
    }


}
