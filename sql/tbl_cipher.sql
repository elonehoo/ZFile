/*
 Navicat Premium Data Transfer

 Source Server         : 轻量级腾讯云服务器
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : 1.15.153.38:3306
 Source Schema         : file-admin

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 15/07/2021 19:40:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_cipher
-- ----------------------------
DROP TABLE IF EXISTS `tbl_cipher`;
CREATE TABLE `tbl_cipher` (
  `id` varchar(40) NOT NULL COMMENT '主键',
  `user_id` varchar(40) DEFAULT NULL COMMENT '用户序号',
  `cipher` varchar(255) DEFAULT NULL COMMENT '密码',
  `gmt_create` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='密码表';

SET FOREIGN_KEY_CHECKS = 1;
