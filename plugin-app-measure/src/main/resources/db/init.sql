-- 计量单位库-计量单位分类 - 测试数据
INSERT INTO lc_measure_unit_category (id, name, description, sort, create_time)
VALUES ('0efe2d6805b5496aa747ecfbfc89fd4d', '重量', '描述重量的相关计量单位', 1, now()),
       ('a9b9d30867f74840a4ebf1c3f6dad98b', '面积', '描述面积的相关计量单位', 2, now()),
       ('70842ace8aec4d02bf26f11e8f5b7829', '长度', '描述长度的相关计量单位', 3, now()),
       ('f1bbe2c366e511eb942c0242ac110003', '角度', '描述角度的相关计量单位', 4, now()),
       ('a827d884675c11eb99470242ac110003', '数量', '描述数量的相关计量单位', 5, now()),
       ('205af9c5b9e111eb9ad30242ac110003', '金额', '描述金额的相关计量单位', 6, now())
;
-- 计量单位库-计量单位 - 测试数据
INSERT INTO lc_measure_unit (id, code, name, symbol, description, category_id, sort, create_time)
VALUES ('8c68c5c5675311ebb8a60242ac110004', '1', '平方厘米', 'cm²', '面积单位', 'a9b9d30867f74840a4ebf1c3f6dad98b', 1, now()),
       ('8c68c7b5675311ebb8a60242ac110004', '2', '平方米', 'm²', '面积单位', 'a9b9d30867f74840a4ebf1c3f6dad98b', 2, now()),
       ('8c68c822675311ebb8a60242ac110004', '3', '平方千米', 'km²', '面积单位', 'a9b9d30867f74840a4ebf1c3f6dad98b', 3, now()),
       ('8c68c85c675311ebb8a60242ac110004', '4', '吨', 't', '重量单位', '0efe2d6805b5496aa747ecfbfc89fd4d', 4, now()),
       ('8c68c88d675311ebb8a60242ac110004', '5', '度', '°', '角度单位', 'f1bbe2c366e511eb942c0242ac110003', 5, now()),
       ('8c68c8bc675311ebb8a60242ac110004', '6', '米', 'm', '长度单位', '70842ace8aec4d02bf26f11e8f5b7829', 6, now()),
       ('8c68c8ea675311ebb8a60242ac110004', '7', '千米', 'km', '长度单位', '70842ace8aec4d02bf26f11e8f5b7829', 7, now()),
       ('8c68c912675311ebb8a60242ac110004', '8', '分米', 'dm', '长度单位', '70842ace8aec4d02bf26f11e8f5b7829', 8, now()),
       ('8c68c946675311ebb8a60242ac110004', '9', '厘米', 'cm', '长度单位', '70842ace8aec4d02bf26f11e8f5b7829', 9, now()),
       ('8c68c976675311ebb8a60242ac110004', '10', '千克', 'kg', '重量单位', '0efe2d6805b5496aa747ecfbfc89fd4d', 10, now()),
       ('8c68c99e675311ebb8a60242ac110004', '11', '克', 'g', '重量单位', '0efe2d6805b5496aa747ecfbfc89fd4d', 11, now()),
       ('8c68c9c6675311ebb8a60242ac110004', '12', '毫克', 'mg', '重量单位', '0efe2d6805b5496aa747ecfbfc89fd4d', 12, now()),
       ('c813e368675c11eb99470242ac110003', '13', '台', '', '数量单位', 'a827d884675c11eb99470242ac110003', 13, now()),
       ('c813e535675c11eb99470242ac110003', '14', '根', '', '数量单位', 'a827d884675c11eb99470242ac110003', 14, now()),
       ('c813e591675c11eb99470242ac110003', '15', '块', '', '数量单位', 'a827d884675c11eb99470242ac110003', 15, now()),
       ('c813e612675c11eb99470242ac110003', '16', '个', '', '数量单位', 'a827d884675c11eb99470242ac110003', 16, now()),
       ('c813e65a675c11eb99470242ac110003', '17', '棵', '', '数量单位', 'a827d884675c11eb99470242ac110003', 17, now()),
       ('c813e693675c11eb99470242ac110003', '18', '颗', '', '数量单位', 'a827d884675c11eb99470242ac110003', 18, now()),
       ('c813e6d4675c11eb99470242ac110003', '19', '架', '', '数量单位', 'a827d884675c11eb99470242ac110003', 19, now()),
       ('83c1ca4e692b11eb861f0242ac110003', '20', '次', '', '数量单位', 'a827d884675c11eb99470242ac110003', 20, now()),
       ('54a27d76b9e111eb9ad30242ac110003', '21', '元', '', '金额单位', '205af9c5b9e111eb9ad30242ac110003', 21, now()),
       ('59db02b8b9e111eb9ad30242ac110003', '22', '万元', '', '金额单位', '205af9c5b9e111eb9ad30242ac110003', 22, now())
;