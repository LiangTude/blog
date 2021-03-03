
## 本地开发  
**第一步：** 把数据库文件导入本地，已上传  
**第二步：** 修改application一系列配置文件(redis配置文件，数据库配置文件)，如不知道application存在位置，可查看下面的项目架构  
**第三步：** 修改腾讯云短信验证配置，位置查看选项目架构(测试阶段不修改无影响)  
**第四步：** 在网页打开： localhost:8080  
## 项目架构
```
|--- pom                                        // acblog配置文件
|--- blog-plus.sql                              // acblog数据库设计
|--- src                                        // 源代码
|--- |--- main                                  // 代码页
          |--- Java                             // 后台代码
             |--- common                        // 公共类
                   |--- config                  // 配置类(以.config后缀结尾)
                   |--- utils                   // 工具类
                        |--- phoneVerify        // 腾讯云短信验证代码
         |--- modules                           // 服务端代码
                  |--- controller               // 表现层
                  |--- dao                      // 持久层
                  |--- entity                   // 实体层
                  |--- service                  // 业务逻辑层
                  |--- shiro                    // shiro配置类
                  |--- AcblogApplication        // spring boot启动类
|--- |--- resources                             // 资源
              |--- mappering                    // 持久层xml文件
              |--- static                       // 静态文件
              |--- templates                    // 前端页面
              |--- application.properties       // 全局配置类
              |--- application.yml              // 全局配置类
              |--- application-dev.yml          // 全局配置类(开发者模式)
              |--- application-test.yml         // 全局配置类(测试者模式)
              |--- application-prod.yml         // 全局配置类(生产者模式)
```

### 项目介绍
1. 采用 springboot2.1.7+mybatis-plus。
2. 在文章，评论等处添加缓存，提高性能。  
3. 使用nginx反向代理部署。  
## 技术展示
### 后台：
项目构建：Maven  
web框架： spring boot  
数据持久层： mybatis-plus  
安全框架： shiro  
搜索引擎： elasticSearch  
缓存：redis  
数据库：Mysql  
### 前台
前台框架：[layui框架](https://www.layui.com/ "layui框架") [amazeui框架](https://amazeui.clouddeep.cn/ "amazeui框架")  
前端模板： thymeleaf  
 
#### 一些细小的框架，就不一一列举了

## 项目概要

### 项目需求
  博客项目能锻炼自己做项目的能力，全面发展。
### 业务设计

#### 打包上传部署
- 使用jar包部署方式，使用守护进程方式部署，`nohup java -jar blog.jar >temp.txt &`

### 总结

#### 开发中遇到难点
- 使用shiro做安全框架，自己以前也了解过，感觉自己没啥问题，但一用到项目中，傻眼了，只能重新学习了解，发现前后端分离必须使用session管理个人信息，在这儿就耗了好长时间，但功夫不负有心人，victory.
- 打包部署，以前自己只做过部署后台（以war包形式），没真正意思上部署过一个真正项目，认为不太难，往往认为不难的东西，到最终都是花费了大量时间来弄，非常感谢我老大（鑫哥），给我指点了指点，让我少走弯路。
#### 项目优缺点
- 后端代码分工明细，有利于项目的理解和维护。
- 在文章，评论等处添加缓存，提高性能。
- 由于该项目使用两个前台框架，造成代码混乱，但不影响阅读源码。
## 最后想说
> 忍受别人忍受不了的忍受
> 享受别人享受不了的享受

## 关于网站
- 客官觉得不错的话，给个**star**就行。


