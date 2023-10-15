/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : test-toolkit

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 16/10/2023 00:54:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `group_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '小组名称',
  `group_leader_id` bigint(20) NULL DEFAULT NULL COMMENT '组长id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(3) NOT NULL DEFAULT 0 COMMENT '删除标记（0正常 1删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group
-- ----------------------------
INSERT INTO `group` VALUES (1, '管理组', NULL, '2023-10-03 21:03:56', '2023-10-03 21:03:56', 0);

-- ----------------------------
-- Table structure for test_account
-- ----------------------------
DROP TABLE IF EXISTS `test_account`;
CREATE TABLE `test_account`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `account` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `environment` tinyint(4) NOT NULL COMMENT '环境（1测试 2预发 3生产）',
  `detail` tinytext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详情',
  `creator_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(3) NOT NULL DEFAULT 0 COMMENT '删除标记（0正常 1删除）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `creator`(`creator_id`) USING BTREE,
  CONSTRAINT `creator` FOREIGN KEY (`creator_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '测试账号表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_account
-- ----------------------------
INSERT INTO `test_account` VALUES (1, '+86 12399999991', 1, '密码 123456，画啦啦正式课', 1, '2023-10-15 23:18:58', '2023-10-15 23:18:58', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `account` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `username` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `group_id` bigint(20) NULL DEFAULT NULL COMMENT '小组Id',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像url',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(3) NOT NULL DEFAULT 0 COMMENT '删除标记（0正常 1删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'admin', 1, NULL, '2023-10-03 20:53:55', '2023-10-04 02:59:20', 0);
INSERT INTO `user` VALUES (2, 'test', 'e10adc3949ba59abbe56e057f20f883e', 'zzz', NULL, NULL, '2023-10-04 03:29:46', '2023-10-04 03:29:46', 0);
INSERT INTO `user` VALUES (3, '13302711471', 'e10adc3949ba59abbe56e057f20f883e', 'tzh', NULL, NULL, '2023-10-04 19:07:00', '2023-10-04 19:07:00', 0);
INSERT INTO `user` VALUES (4, '13302711472', 'e10adc3949ba59abbe56e057f20f883e', 'asd', NULL, NULL, '2023-10-04 19:12:45', '2023-10-04 19:12:45', 0);

SET FOREIGN_KEY_CHECKS = 1;
