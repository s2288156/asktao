CREATE TABLE `t_account`
(
    `id`          varchar(32) NOT NULL,
    `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `username`    varchar(32) NULL COMMENT '登录用户名',
    `password`    varchar(64) NULL COMMENT '登录密码',
    `mobile`      varchar(11) NULL COMMENT '账户手机号',
    `email`       varchar(64) NULL COMMENT '账户邮箱',
    PRIMARY KEY (`id`)
) COMMENT = '账户表，只保存登录通用信息';

