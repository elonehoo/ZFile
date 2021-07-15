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

 Date: 15/07/2021 17:25:46
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

-- ----------------------------
-- Table structure for tbl_script
-- ----------------------------
DROP TABLE IF EXISTS `tbl_script`;
CREATE TABLE `tbl_script` (
  `id` varchar(40) NOT NULL COMMENT '主键',
  `digit` int DEFAULT NULL COMMENT '位数',
  `script` longtext COMMENT '脚本内容',
  `category_id` varchar(40) DEFAULT NULL COMMENT '脚本类别',
  `gmt_create` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='脚本信息表';

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` varchar(40) NOT NULL COMMENT '主键',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `photo` varchar(255) DEFAULT NULL COMMENT '头像',
  `nickName` varchar(50) DEFAULT NULL COMMENT '昵称',
  `gmt_create` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户基本信息表';

SET FOREIGN_KEY_CHECKS = 1;
