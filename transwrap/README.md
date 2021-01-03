# 部分配置
1. 配置端口：10000(according the setup)
2. 打包项目 mvn clean install -P dev -D skipTests

# 未解决问题
~~3. 未解决问题:无法从数据库中正常获取时间(考虑注解user table->po.user)~~
~~4. 数据库暂时没有着落，需要购买.~~
5. 配置跨域访问(低优先级)

# 高优先级任务
aop巩固练习
~~6. 日志部分不够完善，需要处理。~~
    7. 权限校验部分   
       - 权限校验部分，使用细粒度？粗粒度?.   
    8. SpringCloud 实现项目重构？(later).   
    9. 项目整体存在冗余。po与entity。   
需要完善的部分，用户登录部分缓存。  
消息队列实现，用户的推荐推送，以及用户的注册发送验证码。      
日志部分使用ElasticSearch实现记录??

# 已完成
~~1. 配置相关数据库到windows    ~~
~~2. 修改配置，设置配置文件默认为product~~

解决maven依赖无法导入问题   
https://blog.csdn.net/fanxindong0620/article/details/108947405   
注意配置mysql时区   
https://blog.csdn.net/qq_40194399/article/details/94552948