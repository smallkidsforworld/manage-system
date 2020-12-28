create table `user`(
    `id` integer NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `name` varchar(20) unique,
    `introduction` text comment '个人介绍',
    `phone` varchar(11) unique,
    `password` varchar(32) ,
    `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modifyTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `userAuthority` integer default 0 comment '用户权限',
    primary key (`id`),
    unique (`name`,`phone`)
) engine = innodb
  auto_increment = 1
  default charset = utf8mb4 comment ='个人信息';


create table `daily_manage`  (
    `id` integer NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `user_id` integer,
    `info` text comment '信息',
    `title` varchar(50) comment '标题',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `end_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '结束时间',
    primary key (`id`),
    foreign key(user_id) references user(id),
    unique (user_id,`title`)
);