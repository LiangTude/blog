package com.example.blog.modules.sys.service.impl;

import com.example.blog.common.utils.Constant;
import com.example.blog.common.utils.RedisOperator;
import com.example.blog.modules.sys.dao.IndexDao;
import com.example.blog.modules.sys.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: example.blog
 * @ProjectName: adminsystem
 * @Package: com.example.blog.modules.sys.service.impl
 * @Description:
 * @Date: 2019/8/8 0008 16:13
 **/
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexDao indexDao;

    @Autowired
    private RedisOperator redisOperator;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Long myArticlesCount() {
        Long aLong = indexDao.findmyArticlesCount();
        redisOperator.set(Constant.BLOG_COUNT, aLong);
        return aLong;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public int myLabelsCount() {
        int myLabelsCount = indexDao.findMyLabelsCount();
        redisOperator.set(Constant.LABEL_ALL_COUNT, myLabelsCount);
        return myLabelsCount;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Integer myReportsCount() {
        Integer l1 = indexDao.findMyReportsCount();
        Integer l2 = indexDao.findMyReportCount();
        Integer l3 = l1 + l2;
        redisOperator.set(Constant.BLOG_REPORT_COUNT, l3);
        return l3;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Integer myGuestCount() {
        Integer aLong = indexDao.findmyGuestCount();
        Integer aLong1 = indexDao.findmyGuestRepount();
        Integer al = aLong + aLong1;
        redisOperator.set(Constant.BLOG_GUEST_COUNT, al);
        return al;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public int myWebCount() {
        int visitorCount = indexDao.findWebVisitorCount();
        redisOperator.set(Constant.BLOG_VISIT_COUNT, visitorCount);
        return visitorCount;
    }
}
