package com.example.blog.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.modules.sys.entity.UsersEntity;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: example.blog
 * @ProjectName: adminsystem
 * @Package: com.example.blog.modules.sys.dao
 * @Description:
 * @Date: 2019/8/16 0016 21:29
 **/
@Repository
public interface RegisterDao extends BaseMapper<UsersEntity> {


}
