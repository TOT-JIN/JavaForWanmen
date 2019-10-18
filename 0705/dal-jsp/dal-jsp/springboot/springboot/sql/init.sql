DROP DATABASE IF EXISTS dal_ecommerce;

-- create database;
CREATE DATABASE dal_ecommerce;

-- use database;
USE dal_ecommerce;

-- create user table

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `reset_token` varchar(255) DEFAULT NULL,
  `enable` boolean NOT NULL DEFAULT TRUE,
  PRIMARY KEY (`id`),
  UNIQUE KEY UK_EMAIL (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

CREATE UNIQUE INDEX UK_EMAIL ON `user`(`email`);

INSERT INTO USER(id,user_name,email, password) 
VALUES(1,"joshua","joshua@dataapplab.com","abcdefg");

SELECT * from user where `user_name`='jane' OR `email` ='joshua@dataapplab.com';
DELETE FROM `user` WHERE `id`=10;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_role_fk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `user_role_fk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
