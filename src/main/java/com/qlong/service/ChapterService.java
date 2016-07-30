package com.qlong.service;

import com.qlong.dao.IChapterMapper;
import com.qlong.model.Chapter;
import com.qlong.model.Pagtion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qianlong on 2016/7/22.
 */
@Service
public class ChapterService {
    @Autowired
    IChapterMapper chapterMapper;

    public Pagtion<Chapter> getChapterPage(int novelId,int pageSize,int pageNo){
        int count = chapterMapper.getChapterCountByNovelId(novelId);
        Pagtion<Chapter> page = new Pagtion<Chapter>();
        pageNo = pageNo>1?pageNo:0;
        int start = pageNo*pageSize;
        List<Chapter> chapters = chapterMapper.getChapterPageByNovelId(novelId,pageSize,start);
        int totalPage = count/pageSize + (count%pageSize==0?0:1);
        page.setList(chapters);
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        page.setTotalPage(totalPage);
        return page;
    }

}
