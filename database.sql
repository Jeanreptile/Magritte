DROP DATABASE IF EXISTS `magrittedb`;
CREATE DATABASE `magrittedb`;
USE `magrittedb`;

CREATE TABLE `user` (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(127) NOT NULL UNIQUE,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `image` (
  `imageid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  `userid` bigint(20) NOT NULL,
  `createdate` datetime NOT NULL,
  PRIMARY KEY (`imageid`),
  FOREIGN KEY (`userid`) REFERENCES user(`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `user`(username, email, password) VALUES ('flasheur', 'francois.boiteux@gmail.com', 'ncc1701');
INSERT INTO `image`(name, path, userid, createdate) VALUES ('Test1', 'PathNotExist', 1, NOW());
