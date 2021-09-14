CREATE TABLE `t_book_detail`
(
    `id`              varchar(32) NOT NULL,
    `create_time`     timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time`     timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `product_id`      varchar NULL COMMENT '商品id',
    `press_name`      varchar(64) NULL COMMENT '出版社',
    `writer_name`     varchar(16) NULL COMMENT '作者',
    `press_id`        varchar(32) NULL COMMENT '出版社id',
    `writer_id`       varchar(32) NULL COMMENT '作者id',
    `publishing_time` datetime NULL COMMENT '出版时间',
    PRIMARY KEY (`id`),
    INDEX             `idx_product_id`(`product_id`) USING BTREE,
    INDEX             `idx_press_id`(`press_id`) USING BTREE,
    INDEX             `idx_writer_id`(`writer_id`) USING BTREE
) COMMENT = '图书商品详情表';

CREATE TABLE `t_book_press`
(
    `id`          varchar(32) NOT NULL,
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `press_name`  varchar(64) NULL COMMENT '出版社名称',
    PRIMARY KEY (`id`)
) COMMENT = '出版社信息表';

CREATE TABLE `t_book_writer`
(
    `id`          varchar(32) NOT NULL,
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `writer_name` varchar(16) NULL COMMENT '作者名称',
    PRIMARY KEY (`id`)
) COMMENT = '作者信息表';


CREATE TABLE `t_category`
(
    `id`            varchar(32) NOT NULL,
    `create_time`   timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time`   timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `parent_id`     varchar NULL COMMENT '上级id',
    `category_name` varchar(32) NOT NULL COMMENT '类型名称',
    `level`         tinyint UNSIGNED NOT NULL COMMENT '分类等级0，1，2，3...',
    PRIMARY KEY (`id`),
    INDEX           `idx_parent_id`(`parent_id`) USING BTREE,
    UNIQUE INDEX `uk_category_name`(`category_name`) USING BTREE
) COMMENT = '商品分类表';

CREATE TABLE `t_file`
(
    `id`            varchar(32) NOT NULL,
    `create_time`   timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time`   timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `path`          varchar(128) NULL,
    `depend_table`  varchar(32) NULL COMMENT '依赖表名',
    `depend_id`     varchar(32) NULL COMMENT '依赖id',
    `business_type` varchar(32) NULL COMMENT '业务类型',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `uk_depend_id`(`depend_id`) USING BTREE
) COMMENT = '文件上传表';

CREATE TABLE `t_product`
(
    `id`          varchar(32)  NOT NULL,
    `create_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `category_id` varchar(32)  NOT NULL COMMENT '分类id',
    `merchant_id` varchar(32)  NOT NULL COMMENT '商户id',
    `title`       varchar(128) NOT NULL COMMENT '标题',
    `description` varchar(512) NULL COMMENT '描述',
    `price`       decimal(10, 2) NULL COMMENT '单价，单位元，保留两位小数点',
    `stock`       int NULL COMMENT '库存',
    `cover_img`   varchar(128) NULL COMMENT '封面图片',
    `status`      varchar(16) NULL COMMENT '状态：编辑、上架审核、上架、下架',
    PRIMARY KEY (`id`),
    INDEX         `index_category_id`(`category_id`) USING BTREE
) COMMENT = '商品表';

