/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : db_heart

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2017-04-04 14:15:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_face_rectangle`
-- ----------------------------
DROP TABLE IF EXISTS `t_face_rectangle`;
CREATE TABLE `t_face_rectangle` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `person_id` int(255) NOT NULL DEFAULT '0' COMMENT '与个人信息表id对应',
  `address` varchar(255) NOT NULL DEFAULT '无' COMMENT '图片地址',
  `anger` double(50,0) NOT NULL DEFAULT '0' COMMENT '愤怒指数',
  `contempt` double(50,0) NOT NULL DEFAULT '0' COMMENT '轻蔑指数',
  `disgust` double(50,0) NOT NULL DEFAULT '0' COMMENT '厌恶指数',
  `fear` double(50,0) NOT NULL DEFAULT '0' COMMENT '恐惧指数',
  `happiness` double(50,0) NOT NULL DEFAULT '0' COMMENT '快乐指数',
  `neutral` double(50,0) NOT NULL DEFAULT '0' COMMENT '中立指数',
  `sadness` double(50,0) NOT NULL DEFAULT '0' COMMENT '悲伤指数',
  `surprise` double(50,0) NOT NULL DEFAULT '0' COMMENT '惊讶指数',
  `is_del` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除：1是0否',
  `created_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_face_rectangle
-- ----------------------------
INSERT INTO `t_face_rectangle` VALUES ('1', '0', '无', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0000-00-00 00:00:00', '0000-00-00 00:00:00');
INSERT INTO `t_face_rectangle` VALUES ('2', '0', '无', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0000-00-00 00:00:00', '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for `t_person`
-- ----------------------------
DROP TABLE IF EXISTS `t_person`;
CREATE TABLE `t_person` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(50) NOT NULL DEFAULT '无' COMMENT '用户名',
  `password` varchar(100) NOT NULL DEFAULT '无' COMMENT '初始密码',
  `salt` varchar(100) NOT NULL DEFAULT '无' COMMENT '盐值',
  `birthday` varchar(100) NOT NULL DEFAULT '无' COMMENT '生日',
  `sex` tinyint(4) NOT NULL DEFAULT '0' COMMENT '性别，1男2女',
  `job` varchar(50) NOT NULL DEFAULT '无' COMMENT '职业',
  `job_describe` varchar(255) NOT NULL DEFAULT '无' COMMENT '职业描述',
  `photo` varchar(255) NOT NULL DEFAULT '无' COMMENT '头像',
  `wechat` varchar(50) NOT NULL DEFAULT '无' COMMENT '微信号',
  `phone` varchar(50) NOT NULL DEFAULT '无' COMMENT '电话',
  `company` varchar(100) NOT NULL DEFAULT '无' COMMENT '单位',
  `address` varchar(100) NOT NULL DEFAULT '无' COMMENT '工作地点或住址',
  `qq` varchar(50) NOT NULL DEFAULT '无' COMMENT 'QQ号码',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除，1是0否',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_person
-- ----------------------------
INSERT INTO `t_person` VALUES ('1', 'aaa', '123456', '123456', '20000908', '1', '', '', '', '', '', '', '', '', '0', '2017-03-23 12:26:47', '2017-03-23 12:26:50');
INSERT INTO `t_person` VALUES ('2', 'bbb', '', '', '', '0', '', '', '', '', '', '', '', '', '0', '2017-03-23 12:26:59', '2017-04-02 13:32:30');
INSERT INTO `t_person` VALUES ('3', '无', '无', '无', '无', '0', '无', '无', '无', '无', '无', '无', '无', '无', '0', '2017-04-02 13:32:58', '2017-04-02 13:32:58');

-- ----------------------------
-- Table structure for `t_person_recommend`
-- ----------------------------
DROP TABLE IF EXISTS `t_person_recommend`;
CREATE TABLE `t_person_recommend` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `person_id` int(255) NOT NULL DEFAULT '0' COMMENT '个人信息表id',
  `face_rectangle_id` int(255) NOT NULL DEFAULT '0' COMMENT '与表情测试表id对应',
  `recommend_id` int(255) NOT NULL DEFAULT '0' COMMENT '推荐表id',
  `is_del` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除：1是0否',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_person_recommend
-- ----------------------------
INSERT INTO `t_person_recommend` VALUES ('1', '0', '0', '0', '0', '0000-00-00 00:00:00', '0000-00-00 00:00:00');
INSERT INTO `t_person_recommend` VALUES ('2', '0', '0', '0', '0', '0000-00-00 00:00:00', '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for `t_recommend`
-- ----------------------------
DROP TABLE IF EXISTS `t_recommend`;
CREATE TABLE `t_recommend` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL DEFAULT '无' COMMENT '名称',
  `category` int(10) NOT NULL DEFAULT '0' COMMENT '推荐类别：1视频，2音乐，3书籍，4运动',
  `grade` int(10) NOT NULL DEFAULT '0' COMMENT '级别',
  `address` varchar(100) NOT NULL DEFAULT '无' COMMENT '链接地址',
  `description` varchar(500) NOT NULL DEFAULT '无' COMMENT '描述',
  `is_del` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除：1是0否',
  `creat_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_recommend
-- ----------------------------
INSERT INTO `t_recommend` VALUES ('1', '无', '1', '1', '无', '无', '0', '2017-04-02 13:58:03', '2017-04-02 13:58:03');
INSERT INTO `t_recommend` VALUES ('2', '无', '1', '1', '无', '无', '0', '0000-00-00 00:00:00', '0000-00-00 00:00:00');
