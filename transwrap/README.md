# 部分配置
1. 配置端口：10000(according the setup)
2. 打包项目 mvn clean install -P dev -D skipTests

# 未解决问题
~~3. 未解决问题:无法从数据库中正常获取时间(考虑注解user table->po.user)~~
~~4. 数据库暂时没有着落，需要购买.~~
5. 配置跨域访问(低优先级)

# 高优先级任务
aop巩固练习
    6. 日志部分不够完善，需要处理。
    7. 权限校验部分


# 已完成
1. 配置相关数据库到windows    
2. 修改配置，设置配置文件默认为product

解决maven依赖无法导入问题   
https://blog.csdn.net/fanxindong0620/article/details/108947405   
注意配置mysql时区   
https://blog.csdn.net/qq_40194399/article/details/94552948