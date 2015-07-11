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

INSERT INTO `user`(username, email, password) VALUES ('flasheur', 'francois.boiteux@gmail.com', 'ncc17010101');
INSERT INTO `user`(username, email, password) VALUES ('flo', 'flo.flo@gmail.com', 'ncc');
INSERT INTO `user`(username, email, password) VALUES ('cam', 'cam.cam@gmail.com', 'cam');
INSERT INTO `user`(username, email, password) VALUES ('jean', 'jean.jean@gmail.com', 'jean');

INSERT INTO `image`(name, path, userid, createdate) VALUES ('Jsf', 'http://www.tutorialspoint.com/images/jsf-mini-logo.png', 1, NOW());
INSERT INTO `image`(name, path, userid, createdate) VALUES ('Logo Multicouleur', 'http://www.joomlaworks.net/images/demos/galleries/abstract/7.jpg', 1, NOW());
INSERT INTO `image`(name, path, userid, createdate) VALUES ('Montgolfiere', 'http://www.menucool.com/slider/jsImgSlider/images/image-slider-2.jpg', 1, NOW());
INSERT INTO `image`(name, path, userid, createdate) VALUES ('jSF', 'http://www.tutorialspoint.com/images/jsf-mini-logo.png', 1, NOW());
INSERT INTO `image`(name, path, userid, createdate) VALUES ('jSF', 'http://www.tutorialspoint.com/images/jsf-mini-logo.png', 1, NOW());
INSERT INTO `image`(name, path, userid, createdate) VALUES ('jSF', 'http://www.tutorialspoint.com/images/jsf-mini-logo.png', 1, NOW());
INSERT INTO `image`(name, path, userid, createdate) VALUES ('jSF', 'http://www.tutorialspoint.com/images/jsf-mini-logo.png', 1, NOW());
INSERT INTO `image`(name, path, userid, createdate) VALUES ('jSF', 'http://www.tutorialspoint.com/images/jsf-mini-logo.png', 1, NOW());
INSERT INTO `image`(name, path, userid, createdate) VALUES ('jSF', 'http://www.tutorialspoint.com/images/jsf-mini-logo.png', 1, NOW());
INSERT INTO `image`(name, path, userid, createdate) VALUES ('jSF', 'http://www.tutorialspoint.com/images/jsf-mini-logo.png', 1, NOW());
INSERT INTO `image`(name, path, userid, createdate) VALUES ('jSF', 'http://www.tutorialspoint.com/images/jsf-mini-logo.png', 1, NOW());
INSERT INTO `image`(name, path, userid, createdate) VALUES ('jSF', 'http://www.tutorialspoint.com/images/jsf-mini-logo.png', 1, NOW());
INSERT INTO `image`(name, path, userid, createdate) VALUES ('jSF', 'http://www.tutorialspoint.com/images/jsf-mini-logo.png', 1, NOW());
INSERT INTO `image`(name, path, userid, createdate) VALUES ('jSF', 'http://www.tutorialspoint.com/images/jsf-mini-logo.png', 1, NOW());
INSERT INTO `image`(name, path, userid, createdate) VALUES ('jSF', 'http://www.tutorialspoint.com/images/jsf-mini-logo.png', 1, NOW());
INSERT INTO `image`(name, path, userid, createdate) VALUES ('jSF', 'http://www.tutorialspoint.com/images/jsf-mini-logo.png', 1, NOW());
INSERT INTO `image`(name, path, userid, createdate) VALUES ('jSF', 'http://www.tutorialspoint.com/images/jsf-mini-logo.png', 1, NOW());
INSERT INTO `image`(name, path, userid, createdate) VALUES ('jSF', 'http://www.tutorialspoint.com/images/jsf-mini-logo.png', 1, NOW());
INSERT INTO `image`(name, path, userid, createdate) VALUES ('jSF', 'http://www.tutorialspoint.com/images/jsf-mini-logo.png', 1, NOW());
