CREATE TABLE `sys_c_user` (
        `ID` int NOT NULL COMMENT '主键ID',
        `NAME` varchar(36) NOT NULL COMMENT '姓名',
        `MOBILE` varchar(11) DEFAULT NULL COMMENT '手机号',
        `AGE` int DEFAULT NULL COMMENT '年龄',
        `STATUS` tinyint(1) DEFAULT NULL COMMENT '状态',
        `DELETED` tinyint(1) unsigned zerofill NOT NULL COMMENT '是否删除',
        `IS_VALID` tinyint(1) DEFAULT NULL COMMENT '是否有效',
        `CREATE_BY` varchar(36) DEFAULT NULL COMMENT '创建人',
        `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
        `FLOW_NO` bigint DEFAULT NULL COMMENT '流水号',
        PRIMARY KEY (`ID`),
        KEY `IDX_NAME` (`NAME`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统用户表';


------------------------------------------------

CREATE TABLE `sys_c_user` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `NAME` varchar(36) NOT NULL COMMENT '姓名',
  `MOBILE` varchar(11) DEFAULT NULL COMMENT '手机号',
  `AGE` int DEFAULT NULL COMMENT '年龄',
  `STATUS` tinyint(1) DEFAULT NULL COMMENT '状态',
  `DELETED` tinyint(1) unsigned zerofill DEFAULT NULL COMMENT '是否删除',
  `IS_VALID` tinyint(1) DEFAULT NULL COMMENT '是否有效',
  `CREATE_BY` varchar(36) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `FLOW_NO` bigint DEFAULT NULL COMMENT '流水号',
  PRIMARY KEY (`ID`),
  KEY `IDX_NAME` (`NAME`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `sys_c_user` (
                              `ID` bigint NOT NULL COMMENT '主键ID',
                              `NAME` varchar(36) NOT NULL COMMENT '姓名',
                              `MOBILE` varchar(11) DEFAULT NULL COMMENT '手机号',
                              `AGE` int DEFAULT NULL COMMENT '年龄',
                              `STATUS` tinyint(1) DEFAULT NULL COMMENT '状态',
                              `DELETED` tinyint(1) unsigned zerofill DEFAULT NULL COMMENT '是否删除',
                              `IS_VALID` tinyint(1) DEFAULT NULL COMMENT '是否有效',
                              `CREATE_BY` varchar(36) DEFAULT NULL COMMENT '创建人',
                              `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
                              `FLOW_NO` bigint DEFAULT NULL COMMENT '流水号',
                              PRIMARY KEY (`ID`),
                              KEY `IDX_NAME` (`NAME`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;