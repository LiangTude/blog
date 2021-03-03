package com.example.blog.modules.sys.service;

import com.example.blog.modules.sys.entity.UsersEntity;

/**
 * @Author: example.blog
 * @ProjectName: adminsystem
 * @Package: com.example.blog.modules.sys.service
 * @Description:
 * @Date: 2019/8/9 0009 17:30
 **/
public interface RegisterService {


    /**
     * 注册
     * @param users
     * @return
     */
    public int insUsers(UsersEntity users);

    /**
     * 手机号检测
     * @param phone
     * @return
     */
    public int findByPhone(String phone);

    /**
     * 用户名检测
     * @param username
     * @return
     */
    public int findByUsername(String username);

}