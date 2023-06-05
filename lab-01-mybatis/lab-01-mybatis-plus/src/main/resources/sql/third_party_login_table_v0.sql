CREATE TABLE `sys_u_third_party_user` (
      `UID` varchar(36) NOT NULL COMMENT '主键',
      `APPLICATION_UID` varchar(36) NOT NULL COMMENT '应用UID ',
      `USER_ID` varchar(36) NOT NULL COMMENT '用户ID',
      `USER_NAME` varchar(20) DEFAULT NULL COMMENT '用户名称',
      `ROLE_NAME` varchar(20) DEFAULT NULL COMMENT '角色名称',
      `ALLOW_LOGIN` tinyint(1) DEFAULT NULL COMMENT '是否允许登录',
      PRIMARY KEY (`UID`),
      KEY `IDX_APPLICATION_UID` (`APPLICATION_UID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='第三方登录允许用户信息表';

