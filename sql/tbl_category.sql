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

 Date: 15/07/2021 19:54:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_category
-- ----------------------------
DROP TABLE IF EXISTS `tbl_category`;
CREATE TABLE `tbl_category` (
  `id` varchar(40) NOT NULL COMMENT '主键',
  `category_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '建立的名称-如 CentOS7 安装Yum',
  `gmt_create` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='安装软件的类别表';

SET FOREIGN_KEY_CHECKS = 1;
