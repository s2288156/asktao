CREATE TABLE `t_user`
(
    `id`          varchar(32) NOT NULL,
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `username`    varchar(32) NULL,
    `password`    varchar(255) NULL,
    `name`        varchar(32) NULL,
    `sex`         varchar(8) NULL COMMENT '男 - MALE; 女 - FEMALE',
    `mobile`      varchar(11) NULL COMMENT '手机号',
    `birthday`    timestamp NULL COMMENT '生日',
    `email`       varchar(40) NULL,
    PRIMARY KEY (`id`)
) COMMENT = '用户表';

CREATE TABLE `t_merchant`
(
    `id`          varchar(32)  NOT NULL,
    `create_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `username`    varchar(32)  NOT NULL,
    `password`    varchar(255) NOT NULL,
    `shop_name`   varchar(64) NULL COMMENT '店铺名称',
    PRIMARY KEY (`id`)
) COMMENT = '商户信息表';