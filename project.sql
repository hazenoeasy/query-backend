/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : project

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 11/05/2022 04:11:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Answer
-- ----------------------------
DROP TABLE IF EXISTS `Answer`;
CREATE TABLE `Answer` (
  `qid` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `aid` varchar(36) NOT NULL,
  `uid` varchar(36) DEFAULT NULL,
  `text` text,
  `likes` varchar(36) DEFAULT NULL,
  `best` tinyint(1) DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`aid`) USING BTREE,
  KEY `uid` (`uid`),
  KEY `qid` (`qid`),
  CONSTRAINT `answer_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `User` (`uid`),
  CONSTRAINT `answer_ibfk_3` FOREIGN KEY (`qid`) REFERENCES `Question` (`qid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Answer
-- ----------------------------
BEGIN;
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1524295124881727490', '1524295423134490625', '1524295326447394817', 'Newtown', '0', 0, '2022-05-11 03:48:44');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1524294857255772162', '1524295477740134402', '1524295326447394817', 'They should ban guns', '0', 0, '2022-05-11 03:48:57');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1524294640548667393', '1524295537932591106', '1524295326447394817', 'for sure', '-1', 0, '2022-05-11 03:49:11');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1524294490245783553', '1524295606849200130', '1524295326447394817', 'You can DM Professor Juan', '0', 0, '2022-05-11 03:49:27');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1524294232858124289', '1524295671705722881', '1524295326447394817', 'use docker', '1', 0, '2022-05-11 03:49:43');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1524295810759483393', '1524295843181453313', '1524295326447394817', 'use Mybatis!', '1', 0, '2022-05-11 03:50:24');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1524296220073222145', '1524296551649730561', '1524296415578120193', 'Linus', '1', 0, '2022-05-11 03:53:13');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1524296114741665793', '1524296645853798401', '1524296415578120193', 'yes, we can use it with nyu email', '0', 0, '2022-05-11 03:53:35');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1524295810759483393', '1524296698416816130', '1524296415578120193', 'JDBC is good', '1', 0, '2022-05-11 03:53:48');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1524294232858124289', '1524296822421413889', '1524296415578120193', 'brew install mongodb', '0', 0, '2022-05-11 03:54:17');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1524294640548667393', '1524296985437233153', '1524296415578120193', 'no!', '0', 0, '2022-05-11 03:54:56');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1524294490245783553', '1524297112679833601', '1524296415578120193', 'you can check out HPC website', '0', 0, '2022-05-11 03:55:26');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1524295124881727490', '1524297149161889794', '1524296415578120193', 'Einstein!', '0', 0, '2022-05-11 03:55:35');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1524296220073222145', '1524297494910951426', '1524296415578120193', 'Linus built the first kernel, but it was mantained by public community', '1', 0, '2022-05-11 03:56:58');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1524296220073222145', '1524298699871580161', '1524298604832845825', 'ME!', '-1', 0, '2022-05-11 04:01:45');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1524295810759483393', '1524298785028534274', '1524298604832845825', 'Java sucks! Use Go!', '-1', 0, '2022-05-11 04:02:05');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1524295124881727490', '1524298817232400385', '1524298604832845825', 'Me!', '-1', 0, '2022-05-11 04:02:13');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1524294640548667393', '1524298859959775234', '1524298604832845825', 'I can be fired', '-1', 0, '2022-05-11 04:02:23');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1524294490245783553', '1524298925864873986', '1524298604832845825', 'I dont know!', '0', 0, '2022-05-11 04:02:39');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1524294232858124289', '1524298965161308161', '1524298604832845825', 'Google It!', '0', 0, '2022-05-11 04:02:48');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1524294857255772162', '1524299005003001857', '1524298604832845825', 'No way', '0', 0, '2022-05-11 04:02:58');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1524296220073222145', '1524300593960574978', '1524298604832845825', 'I wish I could', '0', 0, '2022-05-11 04:09:16');
COMMIT;

-- ----------------------------
-- Table structure for Question
-- ----------------------------
DROP TABLE IF EXISTS `Question`;
CREATE TABLE `Question` (
  `qid` varchar(36) NOT NULL,
  `uid` varchar(36) DEFAULT NULL,
  `title` text,
  `body` text,
  `resolved` tinyint(1) DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  `tid` varchar(36) DEFAULT NULL,
  `best` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`qid`),
  KEY `question_ibfk_1` (`uid`),
  KEY `question_ibfk_2` (`tid`),
  CONSTRAINT `question_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `User` (`uid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `question_ibfk_2` FOREIGN KEY (`tid`) REFERENCES `Topic` (`tid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Question
-- ----------------------------
BEGIN;
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('1524294232858124289', '1524293886710603777', 'Does any one know how to install mongoDB?', 'I have a assignment about MongoDB. But I don\'t know how to install it on M1 Mac', 0, '2022-05-11 03:44:00', '10', NULL);
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('1524294490245783553', '1524293886710603777', 'Does any one know how to run Hapdoop on HPC?', 'Homework 1', 0, '2022-05-11 03:45:01', '12', NULL);
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('1524294640548667393', '1524293886710603777', 'Can water be fired?', 'can?', 0, '2022-05-11 03:45:37', '2', NULL);
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('1524294857255772162', '1524293886710603777', 'How can the NYC protect citizen?', '.', 0, '2022-05-11 03:46:29', '3', NULL);
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('1524295124881727490', '1524293886710603777', 'Newton or Einstein who is greater？', 'Newton or Einstein who is greater？', 0, '2022-05-11 03:47:32', '4', NULL);
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('1524295810759483393', '1524295326447394817', 'How to connect Mysql with Java?', 'I am working on my final project', 0, '2022-05-11 03:50:16', '8', NULL);
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('1524296114741665793', '1524295326447394817', 'Can NYU student use oracle for free?', 'The licence is so expensive', 0, '2022-05-11 03:51:28', '9', NULL);
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('1524296220073222145', '1524295326447394817', 'Who built Linux?', 'who?', 0, '2022-05-11 03:51:54', '14', NULL);
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('1524299199773896706', '1524298604832845825', 'Can Spark predict if I can win LoL S12 champion ?', 'I\'m mid lane player in G2', 0, '2022-05-11 04:03:44', '13', NULL);
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('1524299362512891905', '1524298604832845825', 'Can javascript write a OS?', '?', 0, '2022-05-11 04:04:23', '14', NULL);
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('1524300832348037122', '1524298604832845825', 'What is the career road a chemsitry student?', 'This is my first year', 0, '2022-05-11 04:10:13', '2', NULL);
COMMIT;

-- ----------------------------
-- Table structure for Topic
-- ----------------------------
DROP TABLE IF EXISTS `Topic`;
CREATE TABLE `Topic` (
  `tid` varchar(36) NOT NULL,
  `parentId` varchar(36) DEFAULT NULL,
  `topic_name` varchar(36) DEFAULT NULL,
  `text` text,
  PRIMARY KEY (`tid`),
  KEY `parentId` (`parentId`),
  CONSTRAINT `topic_ibfk_1` FOREIGN KEY (`parentId`) REFERENCES `Topic` (`tid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Topic
-- ----------------------------
BEGIN;
INSERT INTO `Topic` (`tid`, `parentId`, `topic_name`, `text`) VALUES ('1', '1', 'Computer Science', 'This is Computer Science');
INSERT INTO `Topic` (`tid`, `parentId`, `topic_name`, `text`) VALUES ('10', '5', 'Mongodb', 'This is Mongodb');
INSERT INTO `Topic` (`tid`, `parentId`, `topic_name`, `text`) VALUES ('11', '3', 'NYC Citizen', 'This is NYC Citizen');
INSERT INTO `Topic` (`tid`, `parentId`, `topic_name`, `text`) VALUES ('12', '6', 'Hadoop', 'This is Hadoop');
INSERT INTO `Topic` (`tid`, `parentId`, `topic_name`, `text`) VALUES ('13', '6', 'Spark', 'This is Spark');
INSERT INTO `Topic` (`tid`, `parentId`, `topic_name`, `text`) VALUES ('14', '7', 'Linux', 'This is Linux');
INSERT INTO `Topic` (`tid`, `parentId`, `topic_name`, `text`) VALUES ('2', '2', 'Chemistry', 'This is Chemistry');
INSERT INTO `Topic` (`tid`, `parentId`, `topic_name`, `text`) VALUES ('3', '3', 'Civil', 'This is Civil');
INSERT INTO `Topic` (`tid`, `parentId`, `topic_name`, `text`) VALUES ('4', '4', 'Physics', 'This is Physics');
INSERT INTO `Topic` (`tid`, `parentId`, `topic_name`, `text`) VALUES ('5', '1', 'Database', 'This is Database');
INSERT INTO `Topic` (`tid`, `parentId`, `topic_name`, `text`) VALUES ('6', '1', 'Big Data', 'This is Big Data');
INSERT INTO `Topic` (`tid`, `parentId`, `topic_name`, `text`) VALUES ('7', '1', 'Operating System', 'This is Operating System');
INSERT INTO `Topic` (`tid`, `parentId`, `topic_name`, `text`) VALUES ('8', '5', 'Mysql', 'This is Mysql');
INSERT INTO `Topic` (`tid`, `parentId`, `topic_name`, `text`) VALUES ('9', '5', 'Oracle', 'This is Oracle');
COMMIT;

-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `uid` varchar(36) NOT NULL,
  `username` varchar(36) NOT NULL,
  `profile` varchar(128) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `city` varchar(128) DEFAULT NULL,
  `state` varchar(128) DEFAULT NULL,
  `country` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of User
-- ----------------------------
BEGIN;
INSERT INTO `User` (`uid`, `username`, `profile`, `status`, `email`, `password`, `city`, `state`, `country`) VALUES ('1', 'Matt', 'This is Matt', 1, 'yz7726@nyu.edu', 'xxx', 'New York City', 'New York', 'United State');
INSERT INTO `User` (`uid`, `username`, `profile`, `status`, `email`, `password`, `city`, `state`, `country`) VALUES ('1519190160277561346', 'yuhao', 'asdfsadf', 13, NULL, '80ac45e5bdfe767ebc03c0214dbba7b7', NULL, NULL, NULL);
INSERT INTO `User` (`uid`, `username`, `profile`, `status`, `email`, `password`, `city`, `state`, `country`) VALUES ('1522227772476289026', 'yu', NULL, NULL, NULL, '80ac45e5bdfe767ebc03c0214dbba7b7', NULL, NULL, NULL);
INSERT INTO `User` (`uid`, `username`, `profile`, `status`, `email`, `password`, `city`, `state`, `country`) VALUES ('1522235730032603137', 'yuhao1', NULL, NULL, NULL, '80ac45e5bdfe767ebc03c0214dbba7b7', NULL, NULL, NULL);
INSERT INTO `User` (`uid`, `username`, `profile`, `status`, `email`, `password`, `city`, `state`, `country`) VALUES ('1522717213348392962', 'yu334', NULL, NULL, NULL, '80ac45e5bdfe767ebc03c0214dbba7b7', NULL, NULL, NULL);
INSERT INTO `User` (`uid`, `username`, `profile`, `status`, `email`, `password`, `city`, `state`, `country`) VALUES ('1522717287939895297', 'zhangyuhao', NULL, NULL, NULL, '85af49baa49feb3f213c2ae9a937d568', NULL, NULL, NULL);
INSERT INTO `User` (`uid`, `username`, `profile`, `status`, `email`, `password`, `city`, `state`, `country`) VALUES ('1524278765317664770', 'MattZ', NULL, NULL, NULL, '80ac45e5bdfe767ebc03c0214dbba7b7', NULL, NULL, NULL);
INSERT INTO `User` (`uid`, `username`, `profile`, `status`, `email`, `password`, `city`, `state`, `country`) VALUES ('1524293886710603777', 'yz7726', NULL, 0, NULL, '80ac45e5bdfe767ebc03c0214dbba7b7', NULL, NULL, NULL);
INSERT INTO `User` (`uid`, `username`, `profile`, `status`, `email`, `password`, `city`, `state`, `country`) VALUES ('1524295326447394817', 'Jenson', NULL, 0, NULL, '80ac45e5bdfe767ebc03c0214dbba7b7', NULL, NULL, NULL);
INSERT INTO `User` (`uid`, `username`, `profile`, `status`, `email`, `password`, `city`, `state`, `country`) VALUES ('1524296415578120193', 'Michael', NULL, 0, NULL, '80ac45e5bdfe767ebc03c0214dbba7b7', NULL, NULL, NULL);
INSERT INTO `User` (`uid`, `username`, `profile`, `status`, `email`, `password`, `city`, `state`, `country`) VALUES ('1524298604832845825', 'Caps', 'This is Caps', -4, 'ZYHzyh1217@qq.com', '80ac45e5bdfe767ebc03c0214dbba7b7', 'NYC', 'New York', 'US');
INSERT INTO `User` (`uid`, `username`, `profile`, `status`, `email`, `password`, `city`, `state`, `country`) VALUES ('1524299686812282881', 'Rookie', 'This is Rookie', 0, 'Rookie@qq.com', '80ac45e5bdfe767ebc03c0214dbba7b7', 'Shanghai', 'Shanghai', 'China');
INSERT INTO `User` (`uid`, `username`, `profile`, `status`, `email`, `password`, `city`, `state`, `country`) VALUES ('2', 'Kobe', 'This is Kobe', -1, 'Kobe@nyu.edu', 'xxx', 'LA', 'CA', 'United State');
INSERT INTO `User` (`uid`, `username`, `profile`, `status`, `email`, `password`, `city`, `state`, `country`) VALUES ('3', 'Jordan', 'This is Jordan', -1, 'Jordan@nyu.edu', 'xxx', 'Miami', ' Florida', 'United State');
INSERT INTO `User` (`uid`, `username`, `profile`, `status`, `email`, `password`, `city`, `state`, `country`) VALUES ('4', 'Tom', 'This is Tom', 2, 'Tom@nyu.edu', 'xxx', 'New York City', 'New York', 'United State');
INSERT INTO `User` (`uid`, `username`, `profile`, `status`, `email`, `password`, `city`, `state`, `country`) VALUES ('5', 'Curry', 'This is Curry', -1, 'Curry@nyu.edu', 'xxx', 'San Francisco', 'CA', 'United State');
INSERT INTO `User` (`uid`, `username`, `profile`, `status`, `email`, `password`, `city`, `state`, `country`) VALUES ('6', 'Durant', 'This is Durant', 0, 'Durant@nyu.edu', 'xxx', 'Oklahoma City', 'Oklahoma', 'United State');
COMMIT;

-- ----------------------------
-- Table structure for UserLike
-- ----------------------------
DROP TABLE IF EXISTS `UserLike`;
CREATE TABLE `UserLike` (
  `aid` varchar(255) DEFAULT NULL,
  `uid` varchar(255) DEFAULT NULL,
  `likes` int DEFAULT NULL,
  `rid` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of UserLike
-- ----------------------------
BEGIN;
INSERT INTO `UserLike` (`aid`, `uid`, `likes`, `rid`) VALUES ('1524295843181453313', '1524296415578120193', 1, '1524296666519134209');
INSERT INTO `UserLike` (`aid`, `uid`, `likes`, `rid`) VALUES ('1524296698416816130', '1524296415578120193', 1, '1524296710689349633');
INSERT INTO `UserLike` (`aid`, `uid`, `likes`, `rid`) VALUES ('1524295671705722881', '1524296415578120193', 1, '1524296753492221953');
INSERT INTO `UserLike` (`aid`, `uid`, `likes`, `rid`) VALUES ('1524295537932591106', '1524296415578120193', -1, '1524296990793359361');
INSERT INTO `UserLike` (`aid`, `uid`, `likes`, `rid`) VALUES ('1524296551649730561', '1524296415578120193', 1, '1524297329856700417');
INSERT INTO `UserLike` (`aid`, `uid`, `likes`, `rid`) VALUES ('1524297494910951426', '1524296415578120193', 1, '1524297502267760641');
INSERT INTO `UserLike` (`aid`, `uid`, `likes`, `rid`) VALUES ('1524298699871580161', '1524298604832845825', -1, '1524298706582466561');
INSERT INTO `UserLike` (`aid`, `uid`, `likes`, `rid`) VALUES ('1524298785028534274', '1524298604832845825', -1, '1524298791621980161');
INSERT INTO `UserLike` (`aid`, `uid`, `likes`, `rid`) VALUES ('1524298817232400385', '1524298604832845825', -1, '1524298825029611522');
INSERT INTO `UserLike` (`aid`, `uid`, `likes`, `rid`) VALUES ('1524298859959775234', '1524298604832845825', -1, '1524298868608430081');
COMMIT;

-- ----------------------------
-- View structure for userview
-- ----------------------------
DROP VIEW IF EXISTS `userview`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `userview` AS select `user`.`uid` AS `uid`,`user`.`username` AS `username`,`user`.`profile` AS `profile`,(case when (`user`.`status` > 100) then 'gold' when (`user`.`status` > 50) then 'silver' when (`user`.`status` > 10) then 'bronze' else 'starter' end) AS `status`,`user`.`email` AS `email`,`user`.`password` AS `password`,`user`.`city` AS `city`,`user`.`state` AS `state`,`user`.`country` AS `country` from `user`;

-- ----------------------------
-- Triggers structure for table Answer
-- ----------------------------
DROP TRIGGER IF EXISTS `user_status`;
delimiter ;;
CREATE TRIGGER `user_status` AFTER UPDATE ON `Answer` FOR EACH ROW BEGIN
	if new.likes != old.likes or new.best!=old.best then
	update User set User.status = User.status+(new.likes-old.likes)+(new.best-old.best)*10 where old.uid = User.uid;
	end if;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
