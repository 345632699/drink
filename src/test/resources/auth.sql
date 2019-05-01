/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:8889
 Source Schema         : auth

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 20/04/2019 16:59:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nameZh` varchar(11) NOT NULL DEFAULT '' COMMENT '角色名称：管理员；用户',
  `name` varchar(11) DEFAULT NULL COMMENT '角色：ROLE_ADMIN;ROLE_USER',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1, '用户', 'ROLE_USER');
INSERT INTO `sys_role` VALUES (2, '管理员', 'ROLE_ADMIN');
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(11) NOT NULL DEFAULT '',
  `nickname` varchar(11) NOT NULL DEFAULT '',
  `password` varchar(64) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, 'test', 'ddddd', '231232');
INSERT INTO `sys_user` VALUES (2, 'admin', '', '$2a$10$u8vprgZ31JjomWLO78LOOuNgdTVfMU6dqCtNhqqurixCDsAgixhAa');
INSERT INTO `sys_user` VALUES (3, 'admin123456', '', '$2a$10$5Ruy4HtDIYOMpJK1F2GAZOpniOkCTe.yy5DCRfSrWtctC8IYwEIee');
INSERT INTO `sys_user` VALUES (4, '111111111', '', '$2a$10$j8o7jVFSebMb0f2ZjcAOku9SCQONDp.lOKMgeUgaDJK79yJ4FCyCS');
INSERT INTO `sys_user` VALUES (5, '2213123123', '', '$2a$10$yRKPMq1zeK9gxro4cE27iu5ZYg4wLKyOz.2LPdizgohHkX9f4voFO');
INSERT INTO `sys_user` VALUES (6, '232323', '', '$2a$10$0UIAWPl9hvkZNXOaDhw/sOFURd4go0KoboNfURcAHAHnWUrdvJo.y');
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES (1, 2, 1);
INSERT INTO `sys_user_role` VALUES (2, 3, 1);
INSERT INTO `sys_user_role` VALUES (3, 4, 1);
INSERT INTO `sys_user_role` VALUES (4, 5, 1);
INSERT INTO `sys_user_role` VALUES (5, 6, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
