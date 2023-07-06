/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : tao

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 06/07/2023 20:13:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `commentid` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论的id自动增加',
  `body` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评论的内容',
  `author` int(11) NOT NULL COMMENT '评论的作者',
  `parentpost` int(11) NOT NULL COMMENT '评论的帖子的id',
  `created` date NULL DEFAULT NULL COMMENT '创建时间',
  `deleted` time(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`commentid`) USING BTREE,
  INDEX `parent`(`parentpost`) USING BTREE,
  INDEX `commentauthor`(`author`) USING BTREE,
  CONSTRAINT `commentauthor` FOREIGN KEY (`author`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `parent` FOREIGN KEY (`parentpost`) REFERENCES `post` (`postid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (11, '梦里什么都有 ', 3, 3, '2023-07-05', NULL);
INSERT INTO `comment` VALUES (22, '明明是汪涵', 2, 5, '2023-07-06', NULL);
INSERT INTO `comment` VALUES (23, '在监狱里表演电音rap', 2, 11, '2023-07-06', NULL);
INSERT INTO `comment` VALUES (26, '会呀', 3, 9, '2023-07-06', NULL);
INSERT INTO `comment` VALUES (32, 'f', 41, 11, '2023-07-06', NULL);
INSERT INTO `comment` VALUES (34, 'f', 41, 11, '2023-07-06', NULL);
INSERT INTO `comment` VALUES (35, 'f', 41, 11, '2023-07-06', NULL);
INSERT INTO `comment` VALUES (38, '是的是的', 2, 15, '2023-07-06', NULL);
INSERT INTO `comment` VALUES (39, '你干嘛，哎呦', 2, 11, '2023-07-06', NULL);

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `postid` int(20) NOT NULL AUTO_INCREMENT COMMENT '自动增加的序号',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '帖子的标题',
  `body` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '帖子的内容主体',
  `author` int(11) NOT NULL COMMENT '帖子的作者',
  `created` date NULL DEFAULT NULL COMMENT '创建时间',
  `deleted` time(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`postid`) USING BTREE,
  INDEX `postauthor`(`author`) USING BTREE,
  CONSTRAINT `postauthor` FOREIGN KEY (`author`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (3, '发财', '发财好难', 3, '2023-07-05', NULL);
INSERT INTO `post` VALUES (5, '湖南卫视', '湖南卫视第一主持人何日火', 2, '2023-07-05', NULL);
INSERT INTO `post` VALUES (9, '监狱', '只因会进监狱陪老公凡凡吗？', 3, '2023-07-05', NULL);
INSERT INTO `post` VALUES (11, '监狱', '签子在监狱里干啥？做数据线还是印刷高考试卷', 2, '2023-07-06', NULL);
INSERT INTO `post` VALUES (12, '面', '想和吴签共进大碗宽面', 3, '2023-07-06', NULL);
INSERT INTO `post` VALUES (13, '日本', '日本人爱说八嘎，所以小鬼子又名小八嘎', 2, '2023-07-06', NULL);
INSERT INTO `post` VALUES (14, '韩国', '韩国人爱说西八，所以小泡菜又名小西八', 2, '2023-07-06', NULL);
INSERT INTO `post` VALUES (15, '中国', '中国人从不说脏话', 2, '2023-07-06', NULL);
INSERT INTO `post` VALUES (22, ' 1212', ' 1212', 41, '2023-07-06', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `permission` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '未上传头像.png',
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `signature` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '请输入你的个性签名',
  `created` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zwg', '123', 'hdkahdk@qq.com', '管理员', '未上传头像.png', '男', '大家好，我们是第十三组,hello!', '2023-07-03');
INSERT INTO `user` VALUES (2, '哈哈', '456', 'adihk@qq.com', '用户', '头像.png', '男', '我喜欢蔡徐坤，我的梦想是和蔡徐坤一起打篮球', '2023-07-03');
INSERT INTO `user` VALUES (3, '某某某', '789', 'ghklfhsk@qq.com', '用户', '未上传头像.png', '男', '想和吴亦凡共进大碗宽面', '2023-07-03');
INSERT INTO `user` VALUES (4, 'lpl', '123', NULL, '用户', '未上传头像.png', '男', '111', '2023-07-06');
INSERT INTO `user` VALUES (41, '马坤', '123', 'adjalksd@qq.com', '用户', '未上传头像.png', '男', '大家好我是马坤', '2023-07-06');
INSERT INTO `user` VALUES (43, 'ad', '123', NULL, '用户', '未上传头像.png', NULL, '222', '2023-07-06');

SET FOREIGN_KEY_CHECKS = 1;
