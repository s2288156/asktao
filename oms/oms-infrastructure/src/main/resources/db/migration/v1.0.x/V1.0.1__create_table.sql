CREATE TABLE `t_cart_product`
(
    `id`          varchar(32) NOT NULL,
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `uid`         varchar(32) NULL,
    `product_id`  varchar(32) NULL COMMENT '商品id',
    `quantity`    int NULL COMMENT '数量',
    PRIMARY KEY (`id`),
    INDEX         `idx_uid_pid`(`uid`, `product_id`) USING BTREE
) COMMENT = '购物车商品表';

CREATE TABLE `t_order`
(
    `id`           varchar(32)    NOT NULL,
    `create_time`  timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time`  timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `uid`          varchar(32)    NOT NULL,
    `total_amount` decimal(10, 2) NOT NULL COMMENT '总金额',
    `status`       tinyint        NOT NULL DEFAULT 0 COMMENT '状态: 0 - 待支付，1 - 支付中，2 - 支付成功，3 - 支付失败，4 - 退款中，5 - 已退款',
    `order_no`     varchar(32)    NOT NULL COMMENT '订单号',
    `trade_no`     varchar(32) NULL COMMENT '支付单号',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `uk_order_no`(`order_no`) USING BTREE,
    UNIQUE INDEX `uk_trade_no`(`trade_no`) USING BTREE,
    INDEX          `idx_uid`(`uid`) USING BTREE
) COMMENT = '订单表';

CREATE TABLE `t_order_item`
(
    `id`          varchar(32) NOT NULL,
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `order_id`    varchar(32) NULL,
    `product_id`  varchar(32) NULL COMMENT '商品id',
    `quantity`    int NULL COMMENT '商品购买数量',
    PRIMARY KEY (`id`),
    INDEX         `idx_order_id`(`order_id`) USING BTREE,
    INDEX         `idx_product_id`(`product_id`) USING BTREE
) COMMENT = '订单项目表';