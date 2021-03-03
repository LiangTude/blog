package com.example.blog.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.blog.common.utils.Constant;
import com.example.blog.common.utils.TimeUtil;
import com.example.blog.modules.sys.dao.RegisterDao;
import com.example.blog.modules.sys.entity.UsersEntity;
import com.example.blog.modules.sys.entity.VO.UsersVOEntity;
import com.example.blog.modules.sys.service.AsyncService;
import com.example.blog.modules.sys.service.RedisService;
import com.example.blog.modules.sys.service.RegisterService;
import com.example.blog.modules.sys.shiro.ShiroMD5;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @Author: example.blog
 * @ProjectName: adminsystem
 * @Package: com.example.blog.modules.sys.service.impl
 * @Description:
 * @Date: 2019/8/9 0009 17:32
 **/
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterDao registerDao;

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private RedisService redisService;


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int insUsers(UsersEntity users) {
        String id = UUID.randomUUID().toString();
        users.setId(id);
        users.setRoleId(2);
        Object o = ShiroMD5.MD5(users.getPhone(), users.getPassword());
        users.setPassword(String.valueOf(o));
        String data = new TimeUtil().getFormatDateForThree();
        users.setLastTime(data);
        // 手机号和用户名存入缓存
        redisService.SavePhoneAndUsername(users.getPhone(), users.getUsername());
        return registerDao.insert(users);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public int findByPhone(String phone) {
        int phoneNum = registerDao.selectCount(new QueryWrapper<UsersEntity>().eq("phone", phone));
        // 异步把数据库中的手机号存入缓存
        asyncService.insUserPhone();
        return phoneNum;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public int findByUsername(String username) {
        int name = registerDao.selectCount(new QueryWrapper<UsersEntity>().eq("username", username));
        // 异步把数据库中的用户名存入缓存
        asyncService.insUserName();
        return name;
    }



}
