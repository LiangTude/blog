package com.example.blog.modules.sys.service;

import com.example.blog.modules.sys.entity.LabelEntity;

import java.util.List;

/**
 * @Author: example.blog
 * @ProjectName: adminsystem
 * @Package: com.example.blog.service
 * @Description: 标签业务接口
 * @Date: 2019/7/6 0006 11:47
 **/
public interface LabelService {

    /**
     * 新增标签
     * @param label 标签名
     * @return
     */
    int insLabel(String[] label);

    /**
     * 查询标签全部
     * @return
     */
    List<LabelEntity> selAllLabel();
}
