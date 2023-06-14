CREATE TABLE `sys_banner` (
      `UID` varchar(36) NOT NULL COMMENT 'ID',
      `REMOTE_FILE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'dfs文件名',
      `FILE_PATH` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件服务器路径',
      `TENANT_CODE` varchar(36) DEFAULT NULL COMMENT '租户编号',
      `C_YMD` datetime DEFAULT NULL COMMENT '创建时间',
      `C_USER` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
      `M_YMD` datetime DEFAULT NULL COMMENT '更新时间',
      `M_USER` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新人',
      PRIMARY KEY (`UID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;




