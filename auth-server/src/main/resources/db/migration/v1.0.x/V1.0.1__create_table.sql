CREATE TABLE `t_merchant_account`
(
    `id`          varchar(32) NOT NULL,
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `username`    varchar(32) NOT NULL,
    `password`    varchar(64) NOT NULL,
    PRIMARY KEY (`id`)
) COMMENT = '商户账号表';

CREATE TABLE `t_user_account`
(
    `id`          varchar(32) NOT NULL,
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `username`    varchar(32) NOT NULL,
    `password`    varchar(64) NOT NULL,
    PRIMARY KEY (`id`)
) COMMENT = '用户账号表';
