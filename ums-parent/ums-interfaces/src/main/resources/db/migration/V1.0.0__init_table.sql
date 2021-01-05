CREATE TABLE `t_admin`
(
    `id`          varchar(32)      NOT NULL,
    `create_time` timestamp        NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
    `update_time` timestamp        NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `name`        varchar(16)      NULL DEFAULT NULL COMMENT '名字',
    `age`         tinyint UNSIGNED NULL DEFAULT NULL COMMENT '年龄',
    `gender`      tinyint UNSIGNED NULL DEFAULT NULL COMMENT '性别，0 - 未知，1 - 男，2 - 女',
    `status`      tinyint UNSIGNED NULL DEFAULT 1 COMMENT '账户状态，0 - 删除，1 - 正常，2 - 冻结',
    `birthday`    date             NULL DEFAULT NULL COMMENT '生日',
    `icon`        varchar(255)     NULL DEFAULT NULL COMMENT '头像',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT = '后台管理人员表';

CREATE TABLE `t_admin_role`
(
    `id`       varchar(32) NOT NULL,
    `admin_id` varchar(32) NULL DEFAULT NULL,
    `role_id`  varchar(32) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
);

CREATE TABLE `t_member`
(
    `id`          varchar(32)      NOT NULL,
    `create_time` timestamp        NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
    `update_time` timestamp        NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `name`        varchar(16)      NULL DEFAULT NULL COMMENT '名字',
    `age`         tinyint UNSIGNED NULL DEFAULT NULL COMMENT '年龄',
    `gender`      tinyint UNSIGNED NULL DEFAULT NULL COMMENT '性别，0 - 未知，1 - 男，2 - 女',
    `status`      tinyint UNSIGNED NULL DEFAULT 1 COMMENT '账户状态，0 - 删除，1 - 正常，2 - 冻结',
    `birthday`    date             NULL DEFAULT NULL COMMENT '生日',
    `icon`        varchar(255)     NULL DEFAULT NULL COMMENT '头像',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT = '商城会员表';

CREATE TABLE `t_resource`
(
    `id`          varchar(32)  NOT NULL,
    `create_time` timestamp    NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp    NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `name`        varchar(255) NULL DEFAULT NULL COMMENT '资源名称',
    `url`         varchar(255) NULL DEFAULT NULL COMMENT '资源URL',
    `description` varchar(500) NULL DEFAULT NULL COMMENT '描述',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT = '后台资源表';

CREATE TABLE `t_role`
(
    `id`          varchar(32)  NOT NULL,
    `create_time` timestamp    NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp    NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `name`        varchar(100) NULL DEFAULT NULL COMMENT '名称',
    `description` varchar(255) NULL DEFAULT NULL COMMENT '描述',
    `sort`        int          NULL DEFAULT NULL COMMENT '排序',
    PRIMARY KEY (`id`) USING BTREE
);

CREATE TABLE `t_role_resource`
(
    `id`          varchar(32) NOT NULL,
    `role_id`     varchar(32) NULL DEFAULT NULL,
    `resource_id` varchar(32) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
);

