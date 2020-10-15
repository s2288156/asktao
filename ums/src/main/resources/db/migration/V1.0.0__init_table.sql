CREATE TABLE `t_manager`
(
    `id`          varchar(32)      NOT NULL,
    `create_time` timestamp        NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
    `update_time` timestamp        NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `username`    varchar(32)      NULL COMMENT '用户名',
    `password`    varchar(32)      NULL COMMENT '密码',
    `phone`       varchar(15)      NULL COMMENT '手机号',
    `name`        varchar(16)      NULL COMMENT '名字',
    `age`         tinyint UNSIGNED NULL COMMENT '年龄',
    `gender`      tinyint UNSIGNED NULL COMMENT '性别，0 - 未知，1 - 男，2 - 女',
    `status`      tinyint UNSIGNED NULL DEFAULT 1 COMMENT '账户状态，0 - 删除，1 - 正常，2 - 冻结',
    `birthday`    date             NULL COMMENT '生日',
    `email`       varchar(64)      NULL COMMENT '邮箱',
    `icon`        varchar(255)     NULL COMMENT '头像',
    PRIMARY KEY (`id`)
) COMMENT = '后台管理人员表';

CREATE TABLE `t_manager_role`
(
    `id`         varchar(32) NOT NULL,
    `manager_id` varchar(32) NULL,
    `role_id`    varchar(32) NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `t_member`
(
    `id`          varchar(32)      NOT NULL,
    `create_time` timestamp        NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
    `update_time` timestamp        NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `username`    varchar(32)      NULL COMMENT '用户名',
    `password`    varchar(32)      NULL COMMENT '密码',
    `phone`       varchar(15)      NULL COMMENT '手机号',
    `name`        varchar(16)      NULL COMMENT '名字',
    `age`         tinyint UNSIGNED NULL COMMENT '年龄',
    `gender`      tinyint UNSIGNED NULL COMMENT '性别，0 - 未知，1 - 男，2 - 女',
    `status`      tinyint UNSIGNED NULL DEFAULT 1 COMMENT '账户状态，0 - 删除，1 - 正常，2 - 冻结',
    `birthday`    date             NULL COMMENT '生日',
    PRIMARY KEY (`id`)
) COMMENT = '会员账号表';

CREATE TABLE `t_resource`
(
    `id`          varchar(32)  NOT NULL,
    `create_time` timestamp    NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp    NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `name`        varchar(255) NULL COMMENT '资源名称',
    `url`         varchar(255) NULL COMMENT '资源URL',
    `description` varchar(500) NULL COMMENT '描述',
    PRIMARY KEY (`id`)
) COMMENT = '后台资源表';

CREATE TABLE `t_role`
(
    `id`          varchar(32)  NOT NULL,
    `create_time` timestamp    NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp    NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `name`        varchar(100) NULL COMMENT '名称',
    `description` varchar(255) NULL COMMENT '描述',
    `sort`        int          NULL COMMENT '排序',
    PRIMARY KEY (`id`)
);

CREATE TABLE `t_role_resource`
(
    `id`          varchar(32) NOT NULL,
    `role_id`     varchar(32) NULL,
    `resource_id` varchar(32) NULL,
    PRIMARY KEY (`id`)
);

