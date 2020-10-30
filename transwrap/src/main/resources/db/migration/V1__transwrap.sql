create table `user`(
    `id` integer NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `name` varchar(20) unique,
    `introduction` text comment '个人介绍',
    `phone` varchar(11) unique,
    `password` varchar(32) ,
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `user_authority` integer default 0 comment '用户权限',
    primary key (`id`),
    unique (`name`,`phone`)
) engine = innodb
  auto_increment = 1
  default charset = utf8mb4 comment ='个人信息';


create table `dailymanage`  (
    `id` integer NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `userid` integer,
    `info` text comment '信息',
    `title` varchar(50) comment '标题',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    primary key (`id`),
    foreign key(userid) references user(id),
    unique (`userid`,`title`)
);