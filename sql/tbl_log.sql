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

 Date: 15/07/2021 19:55:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_log
-- ----------------------------
DROP TABLE IF EXISTS `tbl_log`;
CREATE TABLE `tbl_log` (
  `id` varchar(40) DEFAULT NULL COMMENT '日志表主键ID',
  `log_explain` longtext COMMENT '日志说明',
  `gmt_create` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` timestamp NULL DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志表';

SET FOREIGN_KEY_CHECKS = 1;
