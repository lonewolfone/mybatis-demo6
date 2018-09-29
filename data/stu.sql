/*
Navicat MySQL Data Transfer

Source Server         : mm
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : world

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-10-24 10:17:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for stu
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `sname` varchar(255) DEFAULT NULL,
  `sage` int(11) DEFAULT NULL,
  `ssex` varchar(255) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu
-- ----------------------------
INSERT INTO `stu` VALUES ('1', '张三', '22', '男', '1');
INSERT INTO `stu` VALUES ('2', '李斯', '23', '男', '1');
INSERT INTO `stu` VALUES ('3', '无物', '34', '女', '2');
INSERT INTO `stu` VALUES ('4', '张三', '22', '男', '2');
INSERT INTO `stu` VALUES ('5', '张三', '22', '男', '3');
INSERT INTO `stu` VALUES ('6', '张三', '22', '男', '3');
INSERT INTO `stu` VALUES ('7', '张三', '22', '男', '3');
INSERT INTO `stu` VALUES ('8', '李斯', '29', '男', '4');
INSERT INTO `stu` VALUES ('9', '万物', '29', '男', '4');
INSERT INTO `stu` VALUES ('10', '张三', '22', '男', '5');
INSERT INTO `stu` VALUES ('11', '李沛', '22', '男', '5');
INSERT INTO `stu` VALUES ('12', '二狗', '22', '男', '5');
INSERT INTO `stu` VALUES ('13', '李沛', '22', '男', '1');
INSERT INTO `stu` VALUES ('14', '万物', '29', '男', '1');
INSERT INTO `stu` VALUES ('15', '艾小羊', '29', '男', '1');
INSERT INTO `stu` VALUES ('16', '三狗', '29', '男', '2');
INSERT INTO `stu` VALUES ('17', '三狗', '29', '男', '3');
INSERT INTO `stu` VALUES ('18', '旺财', '29', '男', '4');
INSERT INTO `stu` VALUES ('19', '旺财', '29', '男', '5');
INSERT INTO `stu` VALUES ('23', '艾小羊', '29', '男', '1');
INSERT INTO `stu` VALUES ('25', '艾小羊', '29', '男', '2');
INSERT INTO `stu` VALUES ('26', '艾小羊', '29', '男', '3');
INSERT INTO `stu` VALUES ('27', '雄安理', '29', '男', '4');
INSERT INTO `stu` VALUES ('28', '艾小羊', '29', '男', '5');
INSERT INTO `stu` VALUES ('29', '艾小羊', '29', '男', '5');
INSERT INTO `stu` VALUES ('31', '呜呜', '29', '男', '4');
INSERT INTO `stu` VALUES ('33', '万物', '29', '男', '3');
