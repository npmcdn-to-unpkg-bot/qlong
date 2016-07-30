package com.qlong.dao;

import com.qlong.model.Chapter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by qianlong on 2016/7/22.
 */
@Repository
public interface IChapterMapper {
    int insertChapter(Chapter chapter);
    List<Chapter> getChapterByNovelId(int novelId);
    Chapter getChapterById(int chapterId);
    int getChapterCountByNovelId(int novelId);
    List<Chapter> getChapterPageByNovelId(@Param("novelId") int novelId,@Param("pageSize") int pageSize, @Param("start") int start);
}
