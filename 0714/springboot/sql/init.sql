DROP DATABASE IF EXISTS dal_ecommerce;

-- create database;
CREATE DATABASE dal_ecommerce;

-- use database;
USE dal_ecommerce;

-- create user table

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `reset_token` varchar(255) DEFAULT NULL,
  `enable` boolean NOT NULL DEFAULT TRUE,
  `create_date` DATE,
  `modified_date` DATE,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY UK_EMAIL (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

CREATE UNIQUE INDEX UK_EMAIL ON `user`(`email`);

INSERT INTO USER(user_id,user_name,email, password) 
VALUES
(1,"joshua","joshua@dataapplab.com","abcdefg"),
(2,"peize","peize@dataapplab.com","123456"),
(3,"shen","shen@dataapplab.com","67890");



SELECT * from user where `user_name`='jane' OR `email` ='joshua@dataapplab.com';
DELETE FROM `user` WHERE `id`=10;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `dal_ecommerce`.`role`
(`role_id`,`name`,`description`)
VALUES
(1,'customer','authorization for customers'),
(2,'seller','authorization for sellers'),
(3,'administrator','platform admin'),
(4,'root','platform root for developer');


DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_role_fk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `user_role_fk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

INSERT INTO `dal_ecommerce`.`user_role`
(`id`,`user_id`,`role_id`)
VALUES
(1,1,3),
(2,1,2),
(3,1,1),
(4,2,1);


SELECT * FROM user WHERE email='123@gmail.com' or user_name='joshua' LIMIT 1;


SELECT u.*, ur.role_id, r.name, r.description from
(SELECT * FROM user WHERE email='123@gmail.com' or user_name='joshua' LIMIT 1) u
left join user_role ur on u.user_id = ur.user_id
left join role r on ur.role_id = r.role_id;



-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `display_order` int(10) DEFAULT 0,
  `parent_id` int(11) DEFAULT NULL,
  `create_date` DATE,
  `modified_date` DATE,  
  PRIMARY KEY (`id`),
  CONSTRAINT FK_CATEGOR_PARENT FOREIGN KEY (`parent_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

ALTER TABLE `category` ADD COLUMN `` VARCHAR(100) NOT NULL after name;

select * from category;

SELECT t1.name AS lev1, t2.name as lev2
FROM category AS t1
LEFT JOIN category AS t2 ON t2.parent_id = t1.category_id
WHERE t1.name = '饮料';

SELECT t1.name AS lev1, t2.name as lev2
FROM category AS t1
LEFT JOIN category AS t2 ON t2.parent_id = t1.category_id
LEFT JOIN category AS t3 ON t3.parent_id = t2.category_id
WHERE t1.name = '饮料';


DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `detail` text DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `price` decimal(20,2) NOT NULL DEFAULT 0.0,
  `category_id` int(11) DEFAULT NULL,
  `status` enum('NEW','ON_SHELF','OUT_OF_STOCK','DEPRECATED') DEFAULT 'NEW',
  `create_date` DATE,
  `modified_date` DATE,  
  PRIMARY KEY (`product_id`),
  CONSTRAINT FK_PRODUCTS_CATEGORY FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

INSERT INTO `product` (product_id,name,detail,image_url,price,category_id,status,create_date,modified_date) VALUES 
 (1,'青岛啤酒','',
 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1941087378,2718589709&fm=27&gp=0.jpg',
 8.5,null,null,'2018-07-05','2018-07-05'),
 (2,'麒麟啤酒','',
 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527042926822&di=257be99bfda1827faa9cddfb37a37932&imgtype=0&src=http%3A%2F%2Fimage01.71.net%2Fimage01%2F36%2F88%2F85%2F66%2F74024567-5444-4461-b813-4f99b754f752.jpg',
 7.5,null,null,'2018-07-05','2018-07-05');


INSERT INTO `dal_ecommerce`.`category`
(`id`,
`name`,
`display_order`,
`parent_id`,
`create_date`,
`modified_date`)
VALUES
(1,'饮料',null,null,'2018-07-05','2018-07-05'),
(2,'啤酒',null,1,'2018-07-05','2018-07-05'),
(3,'白酒',null,1,'2018-07-05','2018-07-05');

select * from category c1 left join category c2 on c1.parent_id = c2.category_id ;

select * from category c left join product p on p.category_id =c.category_id 
where c.category_id = 2;

