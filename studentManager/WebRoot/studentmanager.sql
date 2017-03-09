/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : studentmanager

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2016-03-16 19:17:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'admin', '123456');

-- ----------------------------
-- Table structure for `t_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `className` varchar(100) DEFAULT NULL,
  `classMan` varchar(100) DEFAULT NULL,
  `deptId` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES ('1', '一班', '张三', '4');
INSERT INTO `t_class` VALUES ('2', '二班', '李四', '5');
INSERT INTO `t_class` VALUES ('3', '三班', '三毛', '6');
INSERT INTO `t_class` VALUES ('4', '特殊班', '刘欢', '7');

-- ----------------------------
-- Table structure for `t_dept`
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deptName` varchar(100) DEFAULT NULL,
  `deptMan` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dept
-- ----------------------------
INSERT INTO `t_dept` VALUES ('2', '舞蹈系', '周杰伦');
INSERT INTO `t_dept` VALUES ('3', '机械系', '张阿三');
INSERT INTO `t_dept` VALUES ('4', '计算机系', '马云');
INSERT INTO `t_dept` VALUES ('5', '体育系', '姚明');
INSERT INTO `t_dept` VALUES ('6', '服装系', '李宁');
INSERT INTO `t_dept` VALUES ('7', '软件系', '周阿四');

-- ----------------------------
-- Table structure for `t_exam`
-- ----------------------------
DROP TABLE IF EXISTS `t_exam`;
CREATE TABLE `t_exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kcId` int(11) DEFAULT NULL,
  `examName` varchar(100) DEFAULT NULL,
  `studentId` int(11) DEFAULT NULL,
  `examDate` varchar(100) DEFAULT NULL,
  `code` int(11) DEFAULT NULL,
  `jkls` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_exam
-- ----------------------------
INSERT INTO `t_exam` VALUES ('1', '2', '计算机毕业考试', '5', '下午', '23', '瓦萨杜古');
INSERT INTO `t_exam` VALUES ('2', '2', '423', '6', '234', '234', '234');
INSERT INTO `t_exam` VALUES ('3', '2', '234', '5', '234', '21234', '2341');

-- ----------------------------
-- Table structure for `t_kc`
-- ----------------------------
DROP TABLE IF EXISTS `t_kc`;
CREATE TABLE `t_kc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kcName` varchar(100) DEFAULT NULL,
  `zy` varchar(100) DEFAULT NULL,
  `sfxu` varchar(100) DEFAULT NULL,
  `sksj` varchar(100) DEFAULT NULL,
  `skls` varchar(100) DEFAULT NULL,
  `skdd` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_kc
-- ----------------------------
INSERT INTO `t_kc` VALUES ('1', null, '计算机软件', '女', '每周上午10点', '张三丰', '人民大会堂');
INSERT INTO `t_kc` VALUES ('2', '计算机1', '计算急', '男', '上午10点', '张三丰', '人民大会堂');

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentName` varchar(100) DEFAULT NULL,
  `studentNo` varchar(100) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(100) DEFAULT NULL,
  `address` text,
  `mobile` varchar(100) DEFAULT NULL,
  `insertDate` datetime DEFAULT NULL,
  `classId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('2', '小熊', '001', '22', '男', '江苏无锡', '123456789', '2016-03-15 10:06:01', '3');
INSERT INTO `t_student` VALUES ('4', '小熊', '001', '22', '男', '江苏无锡', '123456789', '2016-03-15 11:02:20', '1');
INSERT INTO `t_student` VALUES ('5', '小熊', '001', '22', '男', '江苏无锡', '123456789', '2016-03-15 11:04:59', '3');
INSERT INTO `t_student` VALUES ('6', '小熊', '001', '22', '男', '江苏无锡', '123456789', '2016-03-15 11:07:06', null);
INSERT INTO `t_student` VALUES ('7', '小熊', '001', '22', '男', '江苏无锡', '123456789', '2016-03-15 11:09:19', null);
INSERT INTO `t_student` VALUES ('8', '小熊', '001', '22', '男', '江苏无锡', '123456789', '2016-03-15 11:09:48', null);
INSERT INTO `t_student` VALUES ('9', '小熊', '001', '22', '男', '江苏无锡', '123456789', '2016-03-15 11:13:22', null);
INSERT INTO `t_student` VALUES ('10', '小熊', '001', '22', '男', '江苏无锡', '123456789', '2016-03-15 11:14:31', null);
INSERT INTO `t_student` VALUES ('11', '小熊', '001', '22', '男', '江苏无锡', '123456789', '2016-03-15 11:19:12', null);
INSERT INTO `t_student` VALUES ('12', '小sdfsdf熊', '00sdf1', '23', 'asdf男', '江苏无锡', '123456789', '2016-03-15 11:19:47', null);
INSERT INTO `t_student` VALUES ('13', '小sdfsdf熊', '00sdf1', '23', 'asdf男', '江苏无锡', '123456789', '2016-03-15 11:23:09', null);
INSERT INTO `t_student` VALUES ('14', '小sdfsdf熊', '00sdf1', '23', 'asdf男', '江苏无锡', '123456789', '2016-03-15 11:24:06', null);
INSERT INTO `t_student` VALUES ('15', '小sdfsdf熊', '00sdf1', '23', 'asdf男', '江苏无锡', '123456789', '2016-03-15 11:25:07', null);
INSERT INTO `t_student` VALUES ('16', '小sdfsdf熊', '00sdf1', '23', 'asdf男', '江苏无锡', '123456789', '2016-03-15 11:26:45', null);
INSERT INTO `t_student` VALUES ('17', '小sdfsdf熊', '00sdf1', '23', 'asdf男', '江苏无锡', '123456789', '2016-03-15 11:28:48', null);
INSERT INTO `t_student` VALUES ('18', '小李子2', '06666', '55', '女', '江苏南京', '13888888888', null, '4');
