package com.example.blog.modules.sys.dao;

import com.example.blog.modules.sys.entity.VO.UsersVOEntity;
import org.springframework.stereotype.Repository;

/**
 * @Author: example.blog
 * @ProjectName: adminsystem
 * @Package: com.example.blog.modules.sys.dao
 * @Description:
 * @Date: 2019/8/17 0017 12:44
 **/
@Repository
public interface UsersLoginDao {
    UsersVOEntity findByPhone(String phone);

}
