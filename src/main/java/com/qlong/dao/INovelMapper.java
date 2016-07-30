package com.qlong.dao;

import com.qlong.model.Novel;
import org.springframework.stereotype.Repository;

/**
 * Created by qianlong on 2016/7/22.
 */
@Repository
public interface INovelMapper {
    int insertNovel(Novel novel);
    Novel getNovelById(int id);
}
