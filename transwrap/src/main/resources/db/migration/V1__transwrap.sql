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
    `userId` integer,
    `info` text comment '信息',
    `title` varchar(50) comment '标题',
    `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modifyTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `endTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '结束时间',
    primary key (`id`),
    foreign key(userId) references user(id),
    unique (userId,`title`)
);


create table `log_recode` (
    `id` integer NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '调用时间',
    `interfaceName` varchar (25) not null comment '接口名',
    `callMethodName` varchar (25) not null comment '调用方法名',
    `callerAddress` varchar (15) not null comment '调用者IP',
)
