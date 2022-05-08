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

 Date: 07/05/2022 22:48:44
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
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('3', '1', '1', '...', '-1', 0, '2022-04-12 02:15:06');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1', '1522401282952790018', '1519190160277561346', 'sdfas', '0', 0, NULL);
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1', '1522401300447232002', '1519190160277561346', 'sdfassadfsa', '0', 0, NULL);
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1522387864144306177', '1522722017642586113', '1519190160277561346', 'asdf', '0', 0, NULL);
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('3', '1522776870799486977', '1519190160277561346', 'dfgdfg', '-1', 0, NULL);
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1522387864144306177', '1522779835627155457', '1519190160277561346', 'sadfads', '0', 0, NULL);
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1', '1522780143304519682', '1519190160277561346', 'asdasd', '0', 0, NULL);
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1', '1522780239475752961', '1519190160277561346', 'asdfsafd', '0', 0, NULL);
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('3', '1522780724987387905', '1519190160277561346', 'sdfasdf', '-1', 0, '2022-05-06 23:29:51');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('3', '1522781251959713794', '1519190160277561346', 'asdfasdf', '-1', 0, '2022-05-06 23:31:57');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('3', '1522781496173064193', '1519190160277561346', 'asdfsad', '-1', 0, '2022-05-06 23:32:55');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1520628448974913538', '1522848701212491778', '1519190160277561346', 'sdfasdf', '0', 0, '2022-05-07 03:59:58');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1520628448974913538', '1522850203821854722', '1519190160277561346', 'asdfasdfsdf', '0', 0, '2022-05-07 04:05:58');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1522850349901062146', '1522850369316495361', '1519190160277561346', 'sdfsdfsadf', '1', 0, '2022-05-07 04:06:36');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1522850349901062146', '1522851156948074498', '1519190160277561346', 'asdfsda', '0', 0, '2022-05-07 04:09:44');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1522850349901062146', '1522851368314650626', '1519190160277561346', 'asdfas', '0', 0, '2022-05-07 04:10:34');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('3', '2', '2', '.....', '-1', 0, '2022-04-12 02:15:06');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('3', '3', '4', '....', '2', 0, '2022-04-12 02:15:06');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('3', '4', '3', '......', '-1', 0, '2022-04-12 02:15:06');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('3', '5', '5', 'project!!', '-1', 0, '2022-04-12 17:15:53');
INSERT INTO `Answer` (`qid`, `aid`, `uid`, `text`, `likes`, `best`, `datetime`) VALUES ('1', '6', '2', 'tewt', '0', 0, '2022-04-12 17:15:53');
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
  KEY `uid` (`uid`),
  KEY `tid` (`tid`),
  CONSTRAINT `question_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `User` (`uid`),
  CONSTRAINT `question_ibfk_2` FOREIGN KEY (`tid`) REFERENCES `Topic` (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Question
-- ----------------------------
BEGIN;
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('1', '1', 'final project?', 'how to write project proposal?', 0, '2022-04-12 01:35:27', '5', NULL);
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('1520628448974913538', '1519190160277561346', 'ahahah', 'fdsd', 0, '2022-05-01 00:57:29', '1', NULL);
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('1522387085819895810', '1519190160277561346', 'asdf', 'asdfsadf', 0, '2022-05-05 21:25:41', '2', NULL);
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('1522387864144306177', '1519190160277561346', 'asdf', 'sadfasdf', 0, '2022-05-05 21:28:46', '1521935134246236162', NULL);
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('1522387939578863617', '1519190160277561346', 'sadfsad', 'sdfsadfsadf', 0, '2022-05-05 21:29:04', '1521935134246236162', NULL);
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('1522718431734984705', '1519190160277561346', 'sdfsad', 'asdfas', 1, '2022-05-06 19:22:20', '1521951009791709185', NULL);
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('1522780562856591361', '1519190160277561346', 'zCXzx', 'ZXCzXC', 0, '2022-05-06 23:29:45', '1', NULL);
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('1522850349901062146', '1519190160277561346', 'dsfs', 'sadfsadfasd', 0, '2022-05-07 04:06:31', '2', '');
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('2', '2', 'final project', 'I have no idea', 0, '2022-04-12 01:37:15', '5', NULL);
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('3', '3', 'final project3', 'project', 0, '2022-04-12 01:38:55', '5', '');
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('4', '4', 'final', 'project', 0, '2022-04-12 01:38:55', '5', NULL);
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('5', '5', 'final', 'I have no idea', 0, '2022-04-12 01:38:55', '5', NULL);
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('6', '6', 'final project3', '', 0, '2022-04-12 01:38:55', '5', NULL);
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('7', '1', 'how to write function in mysql?', '', 0, '2022-04-12 01:38:55', '8', NULL);
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('8', '1', 'group project', 'does any one wanna do a group project with me?', 0, '2022-04-12 17:14:49', '1', NULL);
INSERT INTO `Question` (`qid`, `uid`, `title`, `body`, `resolved`, `datetime`, `tid`, `best`) VALUES ('9', '2', 'Tutor', 'sfds', 0, '2022-04-12 17:15:24', '1', NULL);
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
INSERT INTO `Topic` (`tid`, `parentId`, `topic_name`, `text`) VALUES ('1521935134246236162', '1', 'str', 'str');
INSERT INTO `Topic` (`tid`, `parentId`, `topic_name`, `text`) VALUES ('1521935823936614401', '1', 'sdf', 'sdf');
INSERT INTO `Topic` (`tid`, `parentId`, `topic_name`, `text`) VALUES ('1521936081487851521', '1', 'sdfsdfsdf', 'sdfsdfsdf');
INSERT INTO `Topic` (`tid`, `parentId`, `topic_name`, `text`) VALUES ('1521936277949100033', '1', 'sdfsdfsdfsadf', '234asdfsa');
INSERT INTO `Topic` (`tid`, `parentId`, `topic_name`, `text`) VALUES ('1521951009791709185', '1521935823936614401', 'testss', 'testtest');
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
INSERT INTO `User` (`uid`, `username`, `profile`, `status`, `email`, `password`, `city`, `state`, `country`) VALUES ('1519190160277561346', 'yuhao', 'asdfsadf', -2, NULL, '80ac45e5bdfe767ebc03c0214dbba7b7', NULL, NULL, NULL);
INSERT INTO `User` (`uid`, `username`, `profile`, `status`, `email`, `password`, `city`, `state`, `country`) VALUES ('1522227772476289026', 'yu', NULL, NULL, NULL, '80ac45e5bdfe767ebc03c0214dbba7b7', NULL, NULL, NULL);
INSERT INTO `User` (`uid`, `username`, `profile`, `status`, `email`, `password`, `city`, `state`, `country`) VALUES ('1522235730032603137', 'yuhao1', NULL, NULL, NULL, '80ac45e5bdfe767ebc03c0214dbba7b7', NULL, NULL, NULL);
INSERT INTO `User` (`uid`, `username`, `profile`, `status`, `email`, `password`, `city`, `state`, `country`) VALUES ('1522717213348392962', 'yu334', NULL, NULL, NULL, '80ac45e5bdfe767ebc03c0214dbba7b7', NULL, NULL, NULL);
INSERT INTO `User` (`uid`, `username`, `profile`, `status`, `email`, `password`, `city`, `state`, `country`) VALUES ('1522717287939895297', 'zhangyuhao', NULL, NULL, NULL, '85af49baa49feb3f213c2ae9a937d568', NULL, NULL, NULL);
INSERT INTO `User` (`uid`, `username`, `profile`, `status`, `email`, `password`, `city`, `state`, `country`) VALUES ('2', 'Kobe', 'This is Kobe', -2, 'Kobe@nyu.edu', 'xxx', 'LA', 'CA', 'United State');
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
INSERT INTO `UserLike` (`aid`, `uid`, `likes`, `rid`) VALUES ('3', '1519190160277561346', -1, '1522775710617227265');
INSERT INTO `UserLike` (`aid`, `uid`, `likes`, `rid`) VALUES ('5', '1519190160277561346', -1, '1522776572622221314');
INSERT INTO `UserLike` (`aid`, `uid`, `likes`, `rid`) VALUES ('4', '1519190160277561346', -1, '1522776582202011649');
INSERT INTO `UserLike` (`aid`, `uid`, `likes`, `rid`) VALUES ('1', '1519190160277561346', -1, '1522776597611884546');
INSERT INTO `UserLike` (`aid`, `uid`, `likes`, `rid`) VALUES ('1522776870799486977', '1519190160277561346', -1, '1522776882811973633');
INSERT INTO `UserLike` (`aid`, `uid`, `likes`, `rid`) VALUES ('1522781496173064193', '1519190160277561346', -1, '1522847389599105026');
INSERT INTO `UserLike` (`aid`, `uid`, `likes`, `rid`) VALUES ('1522781251959713794', '1519190160277561346', -1, '1522847397979324418');
INSERT INTO `UserLike` (`aid`, `uid`, `likes`, `rid`) VALUES ('1522780724987387905', '1519190160277561346', -1, '1522847400378466305');
INSERT INTO `UserLike` (`aid`, `uid`, `likes`, `rid`) VALUES ('1522850369316495361', '1519190160277561346', 1, '1522850377637994498');
INSERT INTO `UserLike` (`aid`, `uid`, `likes`, `rid`) VALUES ('6', '1519190160277561346', -1, '1523073524551327745');
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
