
-- lc_workplace_info

CREATE TABLE `lc_workplace_info`
(
    `id`          varchar(36) NOT NULL,
    `create_by`   varchar(50) DEFAULT NULL COMMENT '创建人',
    `create_time` datetime    DEFAULT NULL COMMENT '创建日期',
    `update_by`   varchar(50) DEFAULT NULL COMMENT '更新人',
    `update_time` datetime    DEFAULT NULL COMMENT '更新日期',
    `name`        varchar(50) DEFAULT NULL COMMENT '工作地点',
    `type`        varchar(50) DEFAULT NULL COMMENT '类型',
    `code`        varchar(64) DEFAULT NULL COMMENT '编号',
    `del_flag`    int(11)     DEFAULT '0' COMMENT '删除标志',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT ='产品库-通用库-工作地点-基本信息';


-- lc_workplace_option

CREATE TABLE `lc_workplace_option`
(
    `id`           varchar(36) NOT NULL COMMENT '主键',
    `create_by`    varchar(50) DEFAULT NULL COMMENT '创建人',
    `create_time`  datetime    DEFAULT NULL COMMENT '创建日期',
    `update_by`    varchar(50) DEFAULT NULL COMMENT '更新人',
    `update_time`  datetime    DEFAULT NULL COMMENT '更新日期',
    `parameter`    varchar(50) DEFAULT NULL COMMENT '参数',
    `value`        varchar(50) DEFAULT NULL COMMENT '数值',
    `del_flag`     int(11)     DEFAULT '0' COMMENT '删除标志',
    `workplace_id` varchar(36) DEFAULT NULL COMMENT '工作地点id',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT ='产品库-通用库-工作地点-地点条件';


-- lc_workplace_condition

CREATE TABLE `lc_workplace_condition`
(
    `id`                varchar(32) NOT NULL COMMENT 'ID',
    `name`              varchar(32)  DEFAULT NULL COMMENT '定额条件值名称',
    `measuring_unit_id` varchar(32)  DEFAULT NULL COMMENT '计量单位ID',
    `condition_type`    varchar(255) DEFAULT NULL COMMENT '定额类型',
    `code`              varchar(255) DEFAULT NULL COMMENT '定额条件编码',
    `remark`            text COMMENT '备注',
    `create_time`       datetime     DEFAULT NULL,
    `create_by`         varchar(255) DEFAULT NULL,
    `update_time`       datetime     DEFAULT NULL,
    `update_by`         varchar(255) DEFAULT NULL,
    `del_flag`          int(1)       DEFAULT '0',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT ='产品库-通用库-工作地点-条件库';


-- lc_workplace_condition_value

CREATE TABLE `lc_workplace_condition_value`
(
    `id`           varchar(32) NOT NULL COMMENT 'ID',
    `value`        varchar(255) DEFAULT NULL COMMENT '定额条件值名称',
    `code`         varchar(255) DEFAULT NULL COMMENT '定额条件值编码',
    `condition_id` varchar(32) NOT NULL COMMENT '归属条件ID',
    `create_time`  datetime     DEFAULT NULL,
    `create_by`    varchar(255) DEFAULT NULL,
    `update_time`  datetime     DEFAULT NULL,
    `update_by`    varchar(255) DEFAULT NULL,
    `del_flag`     int(1)       DEFAULT '0',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT ='产品库-通用库-工作地点-条件值';
