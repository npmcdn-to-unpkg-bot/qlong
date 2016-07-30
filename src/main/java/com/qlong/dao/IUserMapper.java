package com.qlong.dao;

import com.qlong.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by qianlong on 2016/7/21.
 */
@Repository
public interface IUserMapper {
    User getUserById(int id);
}
