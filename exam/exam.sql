/*
 Navicat MySQL Data Transfer

 Source Server         : zhike
 Source Server Type    : MySQL
 Source Server Version : 50713
 Source Host           : 47.105.45.23:3306
 Source Schema         : exam

 Target Server Type    : MySQL
 Target Server Version : 50713
 File Encoding         : 65001

 Date: 18/06/2020 15:12:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) NOT NULL COMMENT '总分',
  `content_count` int(11) NOT NULL COMMENT '题目数量',
  `date_time` timestamp(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES (1, 100, 10, '2020-06-17 00:00:00');

-- ----------------------------
-- Table structure for exam_content
-- ----------------------------
DROP TABLE IF EXISTS `exam_content`;
CREATE TABLE `exam_content`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '题目详情',
  `A` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'A 类容',
  `B` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'B类容',
  `C` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'C类容',
  `D` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'D类容',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '答案',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_content
-- ----------------------------
INSERT INTO `exam_content` VALUES (1, 'JDK是()', '一种全新的程序语言 ', '一种程序开发辅助工具 ', '一种由Java写成的，并支持Java Applet的浏览器 ', '一种游戏软件', 'B');
INSERT INTO `exam_content` VALUES (2, 'Java语言中下面哪个可以用作正确的变量名称（ ） ', '3D', 'name', 'extends', 'implements', 'B');
INSERT INTO `exam_content` VALUES (3, '构造函数何时被调用( )', '类定义时', '创建对象时', '调用对象方法时', '使用对象的变量时', 'B');
INSERT INTO `exam_content` VALUES (4, 'Java中，哪种不可以用来限制存取权限的关键字（ ）', 'public', 'protected   ', 'extends     ', 'private ', 'C');
INSERT INTO `exam_content` VALUES (5, '要想定义一个不能被实例化的抽象类，在类定义中必须加上修饰符( )', 'final  ', 'public    ', 'private     ', 'abstract ', 'D');
INSERT INTO `exam_content` VALUES (6, 'Java源文件和编译后的文件扩展名分别为（ ）', '.class和 .java', '.java和 .class', '.class和 .class  ', '.java和 .java ', 'B');
INSERT INTO `exam_content` VALUES (7, '若已定义 byte[ ] x= {11,22,33,-66} ; 其中0≤k≤3，则对x数组元素错误的引用是(  )', ' x[5-3]', 'x[k] ', 'x[k+5]', ' x[0]', 'C');
INSERT INTO `exam_content` VALUES (8, '数组中可以包含什么类型的元素？_____________。', ' int', 'string', '数组', '8以上都可以', 'D');
INSERT INTO `exam_content` VALUES (9, '以下哪个方法用于定义线程的执行体？', 'start()', 'main()', 'run()', 'init()', 'A');
INSERT INTO `exam_content` VALUES (10, 'Java语言具有许多优点和特点，下列选项中，哪个反映了Java程序并行机制的特点(　　) ', '安全性', ' 多线程', '跨平台 ', '可移植', 'B');

-- ----------------------------
-- Table structure for exam_record
-- ----------------------------
DROP TABLE IF EXISTS `exam_record`;
CREATE TABLE `exam_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `result` decimal(11, 0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_record
-- ----------------------------
INSERT INTO `exam_record` VALUES (1, 2, 100);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `role` int(11) NOT NULL COMMENT '角色 0为学生 1为教师',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zs', '123', 1);
INSERT INTO `user` VALUES (2, 'lsi', '123', 0);

SET FOREIGN_KEY_CHECKS = 1;
