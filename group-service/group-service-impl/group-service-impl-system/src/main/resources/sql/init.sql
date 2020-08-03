/**
    创建认证用户表
 */
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `salt` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'md5密码盐',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '手机号',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `update_user` bigint(20) NOT NULL COMMENT '更新人',
  `update_time` timestamp(0) NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT 1 COMMENT '数据版本',
  `active_flag` tinyint(2) NOT NULL DEFAULT 0 COMMENT '数据状态 0 正常 1 已删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `index_sys_user_pk`(`id`) USING BTREE COMMENT '系统用户表主键索引',
  UNIQUE INDEX `index_sys_user_username`(`username`) USING BTREE COMMENT '系统用户表用户名唯一键索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

/**
    初始化认证用户表数据
 */
INSERT INTO `auth_user` VALUES (1289122790821068801, 'HuWeilong', '82792cac-0784-4a62-b4bc-bf44a57805c1', '13165270713', '$2a$10$xFvtNDmqAxQ4sDfFNPp7c..1dBy1eagJUjHECtaJHbk2KD.CEYuOO', 1289122790821068801, now(), 1289122790821068801, now(), 1, 0);
