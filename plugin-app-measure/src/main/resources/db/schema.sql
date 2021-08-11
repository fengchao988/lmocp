
-- lc_measure_ammeter

CREATE TABLE `lc_measure_ammeter`
(
    `id`          varchar(32) NOT NULL COMMENT '主键id',
    `no`          varchar(50)    DEFAULT NULL COMMENT '电表编号',
    `version`     varchar(50)    DEFAULT NULL COMMENT '电表型号',
    `rate`        double(10, 2)  DEFAULT NULL COMMENT '倍率(x.xx 如 1.25)',
    `price`       decimal(10, 2) DEFAULT NULL COMMENT '执行电价',
    `status`      tinyint(1)     DEFAULT NULL COMMENT '状态(1：启用，0：停用)',
    `is_submit`   tinyint(1)     DEFAULT NULL COMMENT '是否提交(1：是，0：否)',
    `update_time` bigint(20)     DEFAULT NULL COMMENT '更新时间',
    `update_by`   varchar(32)    DEFAULT NULL COMMENT '更新人id',
    `create_time` bigint(20)     DEFAULT NULL COMMENT '创建时间',
    `create_by`   varchar(32)    DEFAULT NULL COMMENT '创建人id',
    PRIMARY KEY (`id`),
    KEY `no` (`no`) USING BTREE COMMENT '电表编号'
) COMMENT ='产品库-通用库-计量服务-电表管理';


-- lc_measure_ammeter_operate

CREATE TABLE `lc_measure_ammeter_operate`
(
    `id`          varchar(32) NOT NULL COMMENT '主键id',
    `ammeter_id`  varchar(32) NOT NULL COMMENT '电表id',
    `no`          varchar(50)    DEFAULT NULL COMMENT '电表编号',
    `version`     varchar(50)    DEFAULT NULL COMMENT '电表型号',
    `rate`        double(10, 2)  DEFAULT NULL COMMENT '倍率(如1.25)',
    `price`       decimal(10, 2) DEFAULT NULL COMMENT '电价',
    `operate`     varchar(50)    DEFAULT NULL COMMENT '操作',
    `update_time` bigint(20)     DEFAULT NULL COMMENT '修改日期',
    `update_by`   varchar(32)    DEFAULT NULL COMMENT '操作人id',
    PRIMARY KEY (`id`),
    KEY `ammeter_id` (`ammeter_id`) USING BTREE COMMENT '电表id'
) COMMENT ='产品库-通用库-计量服务-电表变更信息';


-- lc_measure_unit

CREATE TABLE `lc_measure_unit`
(
    `id`          varchar(36)  NOT NULL COMMENT '主键',
    `code`        varchar(255) NOT NULL COMMENT '计量单位code',
    `name`        varchar(255) DEFAULT NULL COMMENT '计量单位展示名称',
    `symbol`      varchar(20)  DEFAULT NULL COMMENT '计量单位展示符号',
    `description` varchar(255) DEFAULT NULL COMMENT '描述',
    `category_id` varchar(36)  DEFAULT NULL COMMENT '分类ID',
    `sort`        int(10)      DEFAULT '0' COMMENT '排序',
    `create_by`   varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time` datetime     DEFAULT NULL COMMENT '创建日期',
    `update_by`   varchar(50)  DEFAULT NULL COMMENT '更新人',
    `update_time` datetime     DEFAULT NULL COMMENT '更新日期',
    `del_flag`    int(1)       DEFAULT '0' COMMENT '删除标志 0 否 1是',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT ='产品库-通用库-计量服务-计量单位';


-- lc_measure_unit_category

CREATE TABLE `lc_measure_unit_category`
(
    `id`          varchar(36) NOT NULL COMMENT '主键',
    `name`        varchar(255) DEFAULT NULL COMMENT '计量单位分类展示名称',
    `description` varchar(255) DEFAULT NULL COMMENT '描述',
    `sort`        int(10)      DEFAULT '0' COMMENT '排序',
    `create_by`   varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time` datetime     DEFAULT NULL COMMENT '创建日期',
    `update_by`   varchar(50)  DEFAULT NULL COMMENT '更新人',
    `update_time` datetime     DEFAULT NULL COMMENT '更新日期',
    `del_flag`    int(1)       DEFAULT '0' COMMENT '删除标志 0 否 1是',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT ='产品库-通用库-计量服务-计量单位分类';
